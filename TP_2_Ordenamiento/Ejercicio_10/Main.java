package TP_2_Ordenamiento.Ejercicio_10;
import java.util.*;
public class Main {
    static Scanner sc = new Scanner(System.in);
    static Evento[] listaEventos = new Evento[100];
    static int cantidadEventos=0;
    public static void main(String[] args) {
        int opcion=0;
        do{
            System.out.println("1- Crear Evento");
            System.out.println("2- Mostrar Eventos cargados");
            System.out.println("3- Ordenar Cronologicamente y Mostrar Eventos");
            System.out.println("4- Cargar 20 eventos (test9");
            System.out.println("0- Salir");
            opcion=sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    if(cantidadEventos==listaEventos.length){
                        System.out.println("Areglo Lleno");
                    } else {
                        System.out.println("Ingrese Nombre del Evento: ");
                        String nombre = sc.nextLine();
                        System.out.println("Ingrese Hora del Evento: ");
                        int hora = sc.nextInt();
                        System.out.println("Ingrese Minuto del Evento: ");
                        int minuto = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Ingrese Segundo del Evento: ");
                        int segundo = sc.nextInt();
                        sc.nextLine();
                        crearEvento(nombre, hora, minuto, segundo);
                        cantidadEventos++;
                    }
                    break;
                case 2:
                    if(cantidadEventos==0){
                        System.out.println("No hay eventos cargados");
                    }else {
                        System.out.println("---- Eventos sin Ordenar ----");
                        mostrarEventos();
                    }
                    break;
                case 3:
                    if(cantidadEventos==0){
                        System.out.println("No hay eventos cargados");
                    }else {
                        System.out.println("---- Eventos Ordenados ----");
                        ordenarEventos();
                        mostrarEventos();
                    }
                    break;
                case 4:
                    cargarEventosPrueba();
                    break;
                case 0:
                    System.out.println("Saliendo....");
                    break;
                default:
                    System.out.println("opcion incfrecta");
                    break;
            }
        }while(opcion!=0);
        sc.close();    
    }
    static public void crearEvento(String nombre, int hora, int minuto, int segundo){
        Tiempo t = new Tiempo(hora, minuto, segundo);
        Evento e = new Evento(nombre, t);
        listaEventos[cantidadEventos]=e;
    }
    static public void mostrarEventos(){
        for (int i = 0; i < cantidadEventos; i++) {
            listaEventos[i].mostrar();
        }
    }
    static public void ordenarEventos(){
        Sorts.radixSortCronologico(listaEventos, cantidadEventos);
    }








    static public void cargarEventosPrueba() {

        if (cantidadEventos + 20 > listaEventos.length) {

            System.out.println("No hay espacio suficiente para cargar los eventos.");

            return;
        }

        crearEvento("Evento 1", 14, 35, 42);
        cantidadEventos++;

        crearEvento("Evento 2", 3, 12, 8);
        cantidadEventos++;

        crearEvento("Evento 3", 22, 47, 15);
        cantidadEventos++;

        crearEvento("Evento 4", 01, 05, 33);
        cantidadEventos++;

        crearEvento("Evento 5", 12, 25, 51);
        cantidadEventos++;

        crearEvento("Evento 6", 0, 45, 12);
        cantidadEventos++;

        crearEvento("Evento 7", 12, 30, 7);
        cantidadEventos++;

        crearEvento("Evento 8", 05, 18, 59);
        cantidadEventos++;

        crearEvento("Evento 9", 20, 03, 25);
        cantidadEventos++;

        crearEvento("Evento 10", 10, 55, 41);
        cantidadEventos++;

        crearEvento("Evento 11", 23, 10, 5);
        cantidadEventos++;

        crearEvento("Evento 12", 6, 42, 18);
        cantidadEventos++;

        crearEvento("Evento 13", 15, 7, 36);
        cantidadEventos++;

        crearEvento("Evento 14", 02, 59, 44);
        cantidadEventos++;

        crearEvento("Evento 15", 20, 15, 29);
        cantidadEventos++;

        crearEvento("Evento 16", 9, 33, 10);
        cantidadEventos++;

        crearEvento("Evento 17", 13, 20, 55);
        cantidadEventos++;

        crearEvento("Evento 18", 1, 8, 22);
        cantidadEventos++;

        crearEvento("Evento 19", 21, 50, 3);
        cantidadEventos++;

        crearEvento("Evento 20", 7, 27, 48);
        cantidadEventos++;

        System.out.println("Se cargaron 20 eventos de prueba.");
    }

}
