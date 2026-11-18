package Entrega_TP7;

import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BArbol arbol = null;

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("----- ARBOL B -----");
            System.out.println("1. Crear Arbol B");
            System.out.println("2. Insertar clave");
            System.out.println("3. Borrar clave");
            System.out.println("4. Buscar clave");
            System.out.println("5. Mostrar arbol");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    crearArbol();
                    break;

                case 2:
                    insertarClave();
                    break;

                case 3:
                    borrarClave();
                    break;

                case 4:
                    buscarClave();
                    break;

                case 5:
                    mostrarArbol();
                    break;

                case 0:
                    System.out.println("Finalizando programa...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 0);
    }

    public static void crearArbol() {

        arbol = new BArbol(5);

        System.out.println("Arbol B creado correctamente.");
        System.out.println("Aridad: 5");
    }

    public static void insertarClave() {

        if (arbol == null) {
            System.out.println("Primero debe crear el arbol.");
            return;
        }

        System.out.print("Ingrese la clave a insertar: ");
        String clave = sc.nextLine();

        arbol.insertarClave(clave);

        System.out.println("Operacion de insercion realizada.");
    }

    public static void borrarClave() {

        if (arbol == null) {
            System.out.println("Primero debe crear el arbol.");
            return;
        }

        System.out.print("Ingrese la clave a borrar: ");
        String clave = sc.nextLine();

        if (arbol.eliminarClave(clave)) {
            System.out.println("Clave eliminada correctamente.");
        } else {
            System.out.println("La clave no existe en el arbol.");
        }
    }

    public static void buscarClave() {

        if (arbol == null) {
            System.out.println("Primero debe crear el arbol.");
            return;
        }

        System.out.print("Ingrese la clave a buscar: ");
        String clave = sc.nextLine();

        if (arbol.buscarClave(clave)) {
            System.out.println("La clave existe en el arbol.");
        } else {
            System.out.println("La clave no existe en el arbol.");
        }
    }

    public static void mostrarArbol() {

        if (arbol == null) {
            System.out.println("Primero debe crear el arbol.");
            return;
        }

        System.out.println("La operacion mostrar requiere implementar");
        System.out.println("el recorrido del arbol en la clase BArbol.");
    }
}
