package Entrega_TP6;

import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static Trie trieMatriz;
    static Trie trieListas;
    static Trie trieArreglos;

    static TrieInvertido invertidoMatriz;
    static TrieInvertido invertidoListas;
    static TrieInvertido invertidoArreglos;

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("----- Menu -----");
            System.out.println("1. Crear Trie");
            System.out.println("2. Buscar con Matriz");
            System.out.println("3. Buscar con Lista Enlazada");
            System.out.println("4. Buscar con Arreglo Enlazado");
            System.out.println("5. Exportar");
            System.out.println("6. Mostrar Reporte Comparativo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    crearTrie();
                    break;

                case 2:
                    buscarMatriz();
                    break;

                case 3:
                    buscarListas();
                    break;

                case 4:
                    buscarArreglos();
                    break;

                case 5:
                    exportar();
                    break;

                case 6:
                    mostrarReporte();
                    break;

                case 0:
                    System.out.println("Finalizando programa...");
                    break;

                default:
                    System.out.println("Opcion incorrecta.");
                    break;
            }

        } while (opcion != 0);
    }


    public static void crearTrie() {

        trieMatriz = new TrieMatriz();
        trieListas = new TrieListas();
        trieArreglos = new TrieArreglos();

        invertidoMatriz = new TrieInvertido(new TrieMatriz());
        invertidoListas = new TrieInvertido(new TrieListas());
        invertidoArreglos = new TrieInvertido(new TrieArreglos());

        int cantidadCargada = 0;

        try (BufferedReader archivo = Files.newBufferedReader(
                Paths.get("palabras.txt"), StandardCharsets.UTF_8)) {

            String palabra;

            while ((palabra = archivo.readLine()) != null) {

                palabra = palabra.trim();

                if (!palabra.isEmpty()) {

                    trieMatriz.insertar(palabra);
                    trieListas.insertar(palabra);
                    trieArreglos.insertar(palabra);

                    invertidoMatriz.insertar(palabra);
                    invertidoListas.insertar(palabra);
                    invertidoArreglos.insertar(palabra);

                    cantidadCargada++;
                }
            }

            System.out.println("Trie creados correctamente.");
            System.out.println("Palabras leidas del archivo: " + cantidadCargada);

            System.out.println("Palabras almacenadas:");
            mostrarResultados(trieMatriz.listarPalabras());

        } catch (IOException e) {

            System.out.println("Error al leer el archivo palabras.txt");
            System.out.println(e.getMessage());

            trieMatriz = null;
            trieListas = null;
            trieArreglos = null;

            invertidoMatriz = null;
            invertidoListas = null;
            invertidoArreglos = null;
        }
    }

    public static void buscarMatriz() {
        if (!verificarTrie()) return;
        menuBusqueda(trieMatriz, invertidoMatriz, "MATRIZ");
    }

    public static void buscarListas() {
        if (!verificarTrie()) return;
        menuBusqueda(trieListas, invertidoListas, "LISTAS ENLAZADAS");
    }

    public static void buscarArreglos() {
        if (!verificarTrie()) return;
        menuBusqueda(trieArreglos, invertidoArreglos, "ARREGLOS ENLAZADOS");
    }

    public static void menuBusqueda(Trie trie, TrieInvertido invertido, String representacion) {

        int opcion;

        do {
            System.out.println("----- BUSQUEDA: " + representacion + " -----");
            System.out.println("1. Buscar palabra exacta o parecida");
            System.out.println("2. Buscar por prefijo");
            System.out.println("3. Buscar por sufijo");
            System.out.println("4. Mostrar totales");
            System.out.println("0. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    buscarPalabra(trie);
                    break;

                case 2:
                    buscarPrefijo(trie);
                    break;

                case 3:
                    buscarSufijo(invertido);
                    break;

                case 4:
                    mostrarTotales(trie);
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opcion incorrecta.");
                    break;
            }
        } while (opcion != 0);
    }


    public static void buscarPalabra(Trie trie) {
        System.out.print("Ingrese la palabra a buscar: ");
        String palabra = sc.nextLine();
        if (trie.buscar(palabra)) {
            System.out.println("La palabra existe en el Trie.");

        } else {
            System.out.println("La palabra no existe.");
            int longitud = Math.max(1, palabra.length() / 2);
            String coincidencia = palabra.substring(0, longitud);

            System.out.println("Palabras parecidas:");

            ArrayList<String> resultados = trie.buscarPorPrefijo(coincidencia);

            if (resultados.isEmpty()) {
                System.out.println("No se encontraron coincidencias.");
            } else {
                mostrarResultados(resultados);
            }
        }
    }

    public static void buscarPrefijo(Trie trie) {

        System.out.print("Ingrese el prefijo: ");
        String prefijo = sc.nextLine();

        ArrayList<String> resultados = trie.buscarPorPrefijo(prefijo);

        System.out.println("Palabras que comienzan con '" + prefijo + "':");

        if (resultados.isEmpty()) {
            System.out.println("No se encontraron coincidencias.");
        } else {
            mostrarResultados(resultados);
        }
    }

    public static void buscarSufijo(TrieInvertido invertido) {

        System.out.print("Ingrese el sufijo: ");
        String sufijo = sc.nextLine();

        ArrayList<String> resultados = invertido.buscarPorSufijo(sufijo);

        System.out.println("Palabras que terminan con '" + sufijo + "':");

        if (resultados.isEmpty()) {
            System.out.println("No se encontraron coincidencias.");
        } else {
            mostrarResultados(resultados);
        }
    }

    public static void mostrarTotales(Trie trie) {

        System.out.println("----- TOTALES -----");
        System.out.println("Cantidad de palabras: " + trie.cantidadPalabras());
        System.out.println("Cantidad de prefijos distintos: " + trie.cantidadPrefijos());
    }

    public static void mostrarResultados(ArrayList<String> resultados) {

        for (int i = 0; i < resultados.size(); i++) {
            System.out.println("- " + resultados.get(i));
        }
    }

    public static void exportar() {

        if (!verificarTrie()) return;

        System.out.println("El modulo de compresion todavia no esta implementado.");
        System.out.println("Se incorporara al desarrollar COPIAR(X,Y) y la descompresion.");
    }

    public static void mostrarReporte() {

        if (!verificarTrie()) return;

        System.out.print("Ingrese la palabra que desea comparar: ");
        String palabra = sc.nextLine();

        long inicioMatriz = System.nanoTime();
        boolean resultadoMatriz = trieMatriz.buscar(palabra);
        long tiempoMatriz = System.nanoTime() - inicioMatriz;

        long inicioListas = System.nanoTime();
        boolean resultadoListas = trieListas.buscar(palabra);
        long tiempoListas = System.nanoTime() - inicioListas;

        long inicioArreglos = System.nanoTime();
        boolean resultadoArreglos = trieArreglos.buscar(palabra);
        long tiempoArreglos = System.nanoTime() - inicioArreglos;

        System.out.println("---------- COMPARACIONES ----------");
        System.out.println("Palabra buscada: " + palabra);

        System.out.println("MATRIZ");
        System.out.println("Encontrada: " + resultadoMatriz);
        System.out.println("Tiempo: " + tiempoMatriz + " nanosegundos");
        System.out.println("Cantidad de palabras: " + trieMatriz.cantidadPalabras());
        System.out.println("Cantidad de prefijos: " + trieMatriz.cantidadPrefijos());

        System.out.println("LISTAS ENLAZADAS");
        System.out.println("Encontrada: " + resultadoListas);
        System.out.println("Tiempo: " + tiempoListas + " nanosegundos");
        System.out.println("Cantidad de palabras: " + trieListas.cantidadPalabras());
        System.out.println("Cantidad de prefijos: " + trieListas.cantidadPrefijos());

        System.out.println("ARREGLOS ENLAZADOS");
        System.out.println("Encontrada: " + resultadoArreglos);
        System.out.println("Tiempo: " + tiempoArreglos + " nanosegundos");
        System.out.println("Cantidad de palabras: " + trieArreglos.cantidadPalabras());
        System.out.println("Cantidad de prefijos: " + trieArreglos.cantidadPrefijos());
    }

    public static boolean verificarTrie() {

        if (trieMatriz == null || trieListas == null || trieArreglos == null || 
            invertidoMatriz == null || invertidoListas == null || invertidoArreglos == null) {
                
            System.out.println("Primero debe crear los Trie desde la opcion 1.");
            return false;
        }

        return true;
    }
}
