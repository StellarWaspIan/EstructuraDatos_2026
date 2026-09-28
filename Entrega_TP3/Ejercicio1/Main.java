package Entrega_TP3.Ejercicio1;

import java.util.*;

public class Main {    
    static EjemplarPatagonico[] vectorFauna = new EjemplarPatagonico[16];
    
    //ARREGLO (MANUAL) DESORDENADO
    static char[] arregloCodigoZonaDesordenado = new char[16];
    //TERMINAR - ARREGLO (MANUAL) ORDENADO SEGUN ASCII
    static char[] arregloCodigoZonaOrdenado = new char[16];
    //LISTA ENLAZADA DESORDENADA
    static ArrayList<Character> listaCodigoZonaDesordenada = new ArrayList<>();    
    //LISTA ENLAZADA ORDENADA SEGUN ASCII
    static ArrayList<Character> listaCodigoZonaOrdenada = new ArrayList<>();
    //ARBOL BINARIO DE BUSQUEDA
    static Arbol arbolCodigoZona = new Arbol();
    
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int op=0;
        do {
            System.out.println("---Menu---");
            System.out.println("1- Cargar Elementos");
            System.out.println("2- Mostrar Arreglo");
            System.out.println("3- Crear Estructuras (Arreglos, Listas y ABB)");
            System.out.println("4- Busqueda en Estructuras");
            System.out.println("0- Salir");
            op=sc.nextInt();
            sc.nextLine();
            switch (op) {
                case 1:
                    if (vectorFauna.length==16) {
                        System.out.println("Arreglo Lleno");
                    }
                    cargarEjemplares();
                    System.out.println("16 Ejemplares Cargados");
                    break;
                case 2:
                    if(vectorFauna.length==0){
                        System.out.println("Arreglo Vacio");
                    } else{
                        mostrarVectorFauna();
                    }
                    break;
                case 3:
                    almacenarElementos();
                    System.out.println("Arreglos Desordenados y Ordenados por ASCII");
                    mostrarArreglos();
                    break;
                case 4:
                    System.out.println("Busquedas en Estructuras");
                    buscarCodigoZona();
                case 0:
                    System.out.println("Saliendo.....");
                    break;
                default:
                    break;
            }
        } while (op!=0);
    }

    public static void mostrarVectorFauna(){
        for (int i = 0; i < vectorFauna.length; i++) {
            System.out.println("Ejemplar "+i+": "+vectorFauna[i]);
        }
    }

    public static void mostrarArreglos(){
        System.out.println("Arreglo Desordenado: ");
        System.out.print("[");
        for (int i = 0; i < arregloCodigoZonaDesordenado.length; i++) {
            if (i==15) {
                System.out.print(arregloCodigoZonaDesordenado[i]);    
            } else{
            System.out.print(arregloCodigoZonaDesordenado[i]+", ");
            }
        }
        System.out.println("]");
        System.out.println("Arreglo Ordenado: ");
        System.out.print("[");
        for (int i = 0; i < arregloCodigoZonaOrdenado.length; i++) {
            if (i==15) {
                System.out.print(arregloCodigoZonaOrdenado[i]);    
            } else{
            System.out.print(arregloCodigoZonaOrdenado[i]+", ");
            }
        }
        System.out.println("]");
        System.out.println("Lista Desordenada: ");
        System.out.println(listaCodigoZonaDesordenada);
        System.out.println("Lista Ordenada: ");
        System.out.println(listaCodigoZonaOrdenada);
    }

    public static void almacenarElementos(){
        //ARREGLO (MANUAL) DESORDENADO
        for (int i = 0; i < vectorFauna.length; i++) {
            arregloCodigoZonaDesordenado[i]=vectorFauna[i].getCodigozona();
        }
        //TERMINAR ARREGLO (MANUAL) ORDENADO POR ASCII
        for (int i = 0; i < vectorFauna.length; i++) {
            arregloCodigoZonaOrdenado[i]=vectorFauna[i].getCodigozona();
        }
        Arrays.sort(arregloCodigoZonaOrdenado);
        
        //LISTA DESORDENADA
        for (int i = 0; i < vectorFauna.length; i++) {
            listaCodigoZonaDesordenada.add(vectorFauna[i].getCodigozona());
        }
        //TERMINAR LISTA ORDENADA POR ASCII
        
        for (int i = 0; i < vectorFauna.length; i++) {
            listaCodigoZonaOrdenada.add(vectorFauna[i].getCodigozona());
        }   
        listaCodigoZonaOrdenada.sort(null);

        for (int i = 0; i < vectorFauna.length; i++) {
            arbolCodigoZona.insertar(vectorFauna[i].getCodigozona());
        }
    }

    public static void buscarCodigoZona(){
        EstructurasBusqueda e=new EstructurasBusqueda();

        System.out.println("- - Arreglo Desordenado - -");
        System.out.println("Cantidad de Comparacion al buscar caracter 'M': "+e.sequentialSearch(arregloCodigoZonaDesordenado, 'M'));
        System.out.println("Cantidad de Comparacion al buscar caracter 'o': "+e.sequentialSearch(arregloCodigoZonaDesordenado, 'o'));
        System.out.println("Cantidad de Comparacion al buscar caracter 'u': "+e.sequentialSearch(arregloCodigoZonaDesordenado, 'u'));
        System.out.println("Cantidad de Comparacion al buscar caracter '3': "+e.sequentialSearch(arregloCodigoZonaDesordenado, '3'));
        System.out.println("Cantidad de Comparacion al buscar caracter 'E': "+e.sequentialSearch(arregloCodigoZonaDesordenado, 'E'));
        System.out.println("Cantidad de Comparacion al buscar caracter 'X': "+e.sequentialSearch(arregloCodigoZonaDesordenado, 'X'));
        System.out.println("Cantidad de Comparacion al buscar caracter 'w': "+e.sequentialSearch(arregloCodigoZonaDesordenado, 'w'));
        System.out.println("");
        System.out.println("- - Arreglo Ordenado - -");
        System.out.println("Cantidad de Comparacion al buscar caracter 'M': "+e.binarySearch(arregloCodigoZonaOrdenado, 'M'));
        System.out.println("Cantidad de Comparacion al buscar caracter 'o': "+e.binarySearch(arregloCodigoZonaOrdenado, 'o'));
        System.out.println("Cantidad de Comparacion al buscar caracter 'u': "+e.binarySearch(arregloCodigoZonaOrdenado, 'u'));
        System.out.println("Cantidad de Comparacion al buscar caracter '3': "+e.binarySearch(arregloCodigoZonaOrdenado, '3'));
        System.out.println("Cantidad de Comparacion al buscar caracter 'E': "+e.binarySearch(arregloCodigoZonaOrdenado, 'E'));
        System.out.println("Cantidad de Comparacion al buscar caracter 'X': "+e.binarySearch(arregloCodigoZonaOrdenado, 'X'));
        System.out.println("Cantidad de Comparacion al buscar caracter 'w': "+e.binarySearch(arregloCodigoZonaOrdenado, 'w'));
        System.out.println("");
        System.out.println("- - Lista Desordenada - -");
        System.out.println("Cantidad de Comparacion al buscar caracter 'M': "+e.sequentialSearchList(listaCodigoZonaDesordenada, 'M'));
        System.out.println("Cantidad de Comparacion al buscar caracter 'o': "+e.sequentialSearchList(listaCodigoZonaDesordenada, 'o'));
        System.out.println("Cantidad de Comparacion al buscar caracter 'u': "+e.sequentialSearchList(listaCodigoZonaDesordenada, 'u'));
        System.out.println("Cantidad de Comparacion al buscar caracter '3': "+e.sequentialSearchList(listaCodigoZonaDesordenada, '3'));
        System.out.println("Cantidad de Comparacion al buscar caracter 'E': "+e.sequentialSearchList(listaCodigoZonaDesordenada, 'E'));
        System.out.println("Cantidad de Comparacion al buscar caracter 'X': "+e.sequentialSearchList(listaCodigoZonaDesordenada, 'X'));
        System.out.println("Cantidad de Comparacion al buscar caracter 'w': "+e.sequentialSearchList(listaCodigoZonaDesordenada, 'w'));
        System.out.println("");
        System.out.println("- - Lista Ordenada - -");
        System.out.println("Cantidad de Comparacion al buscar caracter 'M': "+e.binarySearchList(listaCodigoZonaOrdenada,'M'));
        System.out.println("Cantidad de Comparacion al buscar caracter 'o': "+e.binarySearchList(listaCodigoZonaOrdenada, 'o'));
        System.out.println("Cantidad de Comparacion al buscar caracter 'u': "+e.binarySearchList(listaCodigoZonaOrdenada, 'u'));
        System.out.println("Cantidad de Comparacion al buscar caracter '3': "+e.binarySearchList(listaCodigoZonaOrdenada, '3'));
        System.out.println("Cantidad de Comparacion al buscar caracter 'E': "+e.binarySearchList(listaCodigoZonaOrdenada, 'E'));
        System.out.println("Cantidad de Comparacion al buscar caracter 'X': "+e.binarySearchList(listaCodigoZonaOrdenada, 'X'));
        System.out.println("Cantidad de Comparacion al buscar caracter 'w': "+e.binarySearchList(listaCodigoZonaOrdenada, 'w'));
        System.out.println("");
        System.out.println("- - Lista Ordenada - -");
        System.out.println("Cantidad de Comparacion al buscar caracter 'M': "+e.binarySearchABB(arbolCodigoZona,'M'));
        System.out.println("Cantidad de Comparacion al buscar caracter 'o': "+e.binarySearchABB(arbolCodigoZona, 'o'));
        System.out.println("Cantidad de Comparacion al buscar caracter 'u': "+e.binarySearchABB(arbolCodigoZona, 'u'));
        System.out.println("Cantidad de Comparacion al buscar caracter '3': "+e.binarySearchABB(arbolCodigoZona, '3'));
        System.out.println("Cantidad de Comparacion al buscar caracter 'E': "+e.binarySearchABB(arbolCodigoZona, 'E'));
        System.out.println("Cantidad de Comparacion al buscar caracter 'X': "+e.binarySearchABB(arbolCodigoZona, 'X'));
        System.out.println("Cantidad de Comparacion al buscar caracter 'w': "+e.binarySearchABB(arbolCodigoZona, 'w'));
    }

    public static void cargarEjemplares(){
        int i=0;
        EjemplarPatagonico e; 
        e = new EjemplarPatagonico(1000, 'M', 25);
        vectorFauna[i]=e;
        i++;
        e = new EjemplarPatagonico(1150, '8', 43);
        vectorFauna[i]=e;
        i++;
        e = new EjemplarPatagonico(1300, 'z', 56);
        vectorFauna[i]=e;
        i++;
        e = new EjemplarPatagonico(1450, '&', 35);
        vectorFauna[i]=e;
        i++;
        e = new EjemplarPatagonico(1600, 'o', 54);
        vectorFauna[i]=e;
        i++;
        e = new EjemplarPatagonico(1750, 'A', 13);
        vectorFauna[i]=e;
        i++;
        e = new EjemplarPatagonico(1900, 'u', 80);
        vectorFauna[i]=e;
        i++;
        e = new EjemplarPatagonico(2050, '7', 104);
        vectorFauna[i]=e;
        i++;
        e = new EjemplarPatagonico(2200, '3', 17);
        vectorFauna[i]=e;
        i++;
        e = new EjemplarPatagonico(2350, 'Q', 29);
        vectorFauna[i]=e;
        i++;
        e = new EjemplarPatagonico(2500, '%', 61);
        vectorFauna[i]=e;
        i++;
        e = new EjemplarPatagonico(2650, 'E', 88);
        vectorFauna[i]=e;
        i++;
        e = new EjemplarPatagonico(2800, '@', 99);
        vectorFauna[i]=e;
        i++;
        e = new EjemplarPatagonico(2950, 'H', 41);
        vectorFauna[i]=e;
        i++;
        e = new EjemplarPatagonico(3100, 'c', 73);
        vectorFauna[i]=e;
        i++;
        e = new EjemplarPatagonico(3100, 'l', 98);
        vectorFauna[i]=e;
        i++;
    }
   

}
