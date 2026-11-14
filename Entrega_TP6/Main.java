package Entrega_TP6;
import java.util.*;
public class Main {
    static Scanner sc = new Scanner(System.in);
    static Trie trieMatriz;
    static Trie trieListas;
    static Trie trieArreglos;
    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n===== SISTEMA PREDICTIVO GAMER =====");
            System.out.println("1. Crear Trie");
            System.out.println("2. Buscar con Matriz");
            System.out.println("3. Buscar con Lista Enlazada");
            System.out.println("4. Buscar con Arreglo Enlazado");
            System.out.println("5. Exportar");
            System.out.println("6. Mostrar Reporte");
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
    // CREAR TRIE DESDE ARCHIVO
    public static void crearTrie() {
    }

    // BUSCAR UTILIZANDO TRIE MATRIZ
    public static void buscarMatriz() {

    }

    // BUSCAR UTILIZANDO TRIE LISTAS ENLAZADAS
    public static void buscarListas() {

    }

    // BUSCAR UTILIZANDO TRIE ARREGLOS ENLAZADOS
    public static void buscarArreglos() {

    }

    // EXPORTAR / COMPRIMIR
    public static void exportar() {

    }

    // MOSTRAR REPORTE COMPARATIVO
    public static void mostrarReporte() {

    }

    // VERIFICAR SI LOS TRIE FUERON CREADOS
    public static boolean verificarTrie() {
        return trieMatriz != null && trieListas != null && trieArreglos != null;
    }
}
