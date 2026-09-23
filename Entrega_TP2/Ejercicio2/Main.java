package Entrega_TP2.Ejercicio2;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Pasajero[] pasajeros = new Pasajero[100];
        int cantidadPasajeros = 0;
        int opcion;
        do {
            System.out.println("--- menu ---");
            System.out.println("1- Crear Pasajero");
            System.out.println("2- Mostrar Pasajeros cargados");
            System.out.println("3- Ordenar por Legajo ShellSort)");
            System.out.println("4- Ordenar Alfabeticamente por nombre (MergeSort)");
            System.out.println("5- Ordenar por Prioridad  (HeapSort)");
            System.out.println("6- Ordenar por Promedio (QuickSort)");
            System.out.println("7- Ordenar por Promedio (ShakerSort)");
            System.out.println("8- Vaciar arreglo");
            System.out.println("0- Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    if (cantidadPasajeros < pasajeros.length) {
                        pasajeros[cantidadPasajeros] = crearPasajero();
                        cantidadPasajeros++;
                        System.out.println("Pasajero cargado correctamente.");
                    } else {
                        System.out.println("El arreglo esta lleno.");
                    }
                    break;
                case 2:
                    mostrarPasajeros(pasajeros, cantidadPasajeros);
                    break;
                case 3:
                    if (cantidadPasajeros > 0) {
                        Sorts.shellSort(pasajeros, cantidadPasajeros);
                        System.out.println("Pasajeros ordenados por legajo:");
                        mostrarPasajeros(pasajeros, cantidadPasajeros);

                    } else {
                        System.out.println("No hay pasajeros cargados.");
                    }
                    break;
                case 4:
                    if (cantidadPasajeros > 0) {
                        Sorts.mergeSort(pasajeros, cantidadPasajeros);
                        System.out.println("Pasajeros ordenados alfabeticamente:");
                        mostrarPasajeros(pasajeros, cantidadPasajeros);
                    } else {
                        System.out.println("No hay pasajeros cargados.");
                    }
                    break;

                case 5:
                    if (cantidadPasajeros > 0) {
                        Sorts.heapSort(pasajeros, cantidadPasajeros);
                        System.out.println("Pasajeros ordenados por prioridad:");
                        mostrarPasajeros(pasajeros, cantidadPasajeros);
                    } else {
                        System.out.println("No hay pasajeros cargados.");
                    }
                    break;
                case 6:
                    if (cantidadPasajeros > 0) {
                        Pasajero[] copiaQuick = copiarPasajeros(pasajeros, cantidadPasajeros);
                        Contadores resultadoQuick = Sorts.quickSort(copiaQuick, cantidadPasajeros);
                        System.out.println("Pasajeros ordenados por promedio (QuickSort):");
                        mostrarPasajeros(copiaQuick, cantidadPasajeros);
                        System.out.println("--- Estadisticas QuickSort ---");
                        System.out.println("Comparaciones: " + resultadoQuick.comparaciones);
                        System.out.println("Intercambios: " + resultadoQuick.intercambios);
                    } else {
                        System.out.println("No hay pasajeros cargados.");
                    }
                    break;
                case 7:
                    if (cantidadPasajeros > 0) {
                        Pasajero[] copiaShaker = copiarPasajeros(pasajeros, cantidadPasajeros);
                        Contadores resultadoShaker = Sorts.shakerSort(copiaShaker, cantidadPasajeros);
                        System.out.println("asajeros ordenados por promedio (ShakerSort):");
                        mostrarPasajeros(copiaShaker, cantidadPasajeros);
                        System.out.println("--- Estadisticas ShakerSort ---");
                        System.out.println("Comparaciones: "+ resultadoShaker.comparaciones);
                        System.out.println("Intercambios: " + resultadoShaker.intercambios);
                    } else {
                        System.out.println("No hay pasajeros cargados.");
                    }
                    break;
                case 8:
                    for (int i = 0; i < cantidadPasajeros; i++) {
                        pasajeros[i] = null;
                    }
                    cantidadPasajeros = 0;
                    System.out.println("Arreglo vaciado correctamente.");
                    break;
                case 9:
                    if (cantidadPasajeros == 0) {
                        cantidadPasajeros = cargaRapida(pasajeros);
                        System.out.println("Se cargaron 20 pasajeros.");
                    } else {
                        System.out.println("Ya hay pasajeros cargados.");
                        System.out.println("Vacie el arreglo antes de realizar una carga rapida.");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo....");
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
                    break;
            }
        } while (opcion != 0);
        sc.close();
    }

    public static Pasajero crearPasajero() {
        System.out.println("\n--- Crear Pasajero ---");
        System.out.print("Ingrese legajo: ");
        int legajo = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese prioridad: ");
        int prioridad = sc.nextInt();
        System.out.print("Ingrese promedio: ");
        double promedio = sc.nextDouble();
        sc.nextLine();
        return new Pasajero(legajo,prioridad,nombre,promedio);
    }
    public static void mostrarPasajeros(Pasajero[] pasajeros,int cantidadPasajeros) {
        if (cantidadPasajeros == 0) {
            System.out.println("No hay pasajeros cargados.");
            return;
        }
        System.out.println("\n--- Pasajeros ---");
        for (int i = 0; i < cantidadPasajeros; i++) {
            pasajeros[i].mostrar();
        }
    }
    public static Pasajero[] copiarPasajeros(Pasajero[] pasajeros,int cantidadPasajeros) {
        Pasajero[] copia = new Pasajero[cantidadPasajeros];
        for (int i = 0; i < cantidadPasajeros; i++) {
            copia[i] = pasajeros[i];
        }
        return copia;
    }

    public static int cargaRapida(Pasajero[] pasajeros) {
        pasajeros[0] = new Pasajero(105, 2, "Carlos", 7.5);
        pasajeros[1] = new Pasajero(23, 1, "Ana", 8.9);
        pasajeros[2] = new Pasajero(87, 3, "Pedro", 6.2);
        pasajeros[3] = new Pasajero(156, 2, "Lucia", 9.1);
        pasajeros[4] = new Pasajero(42, 1, "Martin", 7.8);
        pasajeros[5] = new Pasajero(9, 3, "Sofia", 5.6);
        pasajeros[6] = new Pasajero(134, 2, "Diego", 8.3);
        pasajeros[7] = new Pasajero(67, 1, "Valentina", 9.5);
        pasajeros[8] = new Pasajero(198, 3, "Juan", 6.8);
        pasajeros[9] = new Pasajero(31, 2, "Camila", 7.1);
        pasajeros[10] = new Pasajero(76, 1, "Federico", 8.7);
        pasajeros[11] = new Pasajero(12, 3, "Maria", 6.4);
        pasajeros[12] = new Pasajero(145, 2, "Nicolas", 7.9);
        pasajeros[13] = new Pasajero(54, 1, "Florencia", 9.0);
        pasajeros[14] = new Pasajero(91, 3, "Gonzalo", 5.9);
        pasajeros[15] = new Pasajero(38, 2, "Paula", 8.1);
        pasajeros[16] = new Pasajero(167, 1, "Santiago", 7.3);
        pasajeros[17] = new Pasajero(4, 3, "Julieta", 9.7);
        pasajeros[18] = new Pasajero(119, 2, "Matias", 6.7);
        pasajeros[19] = new Pasajero(82, 1, "Carolina", 8.5);
        return 20;
    }
}
