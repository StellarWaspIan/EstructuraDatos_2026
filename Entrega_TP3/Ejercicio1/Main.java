package Entrega_TP3.Ejercicio1;

import java.util.Scanner;

public class Main {
    static EjemplarPatagonico[] vectorFauna = new EjemplarPatagonico[16];
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int op=0;
        do {
            System.out.println("---Menu---");
            System.out.println("1- Cargar Elementos");
            System.out.println("2- Mostrar Arreglo");
            System.out.println("0- Salir");
            op=sc.nextInt();
            sc.nextLine();
            switch (op) {
                case 1:
                    cargarEjemplares();
                    System.out.println("16 Ejemplares Cargados");
                    break;
                case 2:
                    if(vectorFauna.length==0){
                        System.out.println("Arreglo Vacio");
                    } else{
                        mostrarEjemplares();
                    }
                    break;
                case 0:
                    System.out.println("Saliendo.....");
                    break;
                default:
                    break;
            }
        } while (op!=0);
    }

    public static  void mostrarEjemplares(){
        for (int i = 0; i < vectorFauna.length; i++) {
            System.out.println("Ejemplar "+i+": "+vectorFauna[i]);
        }
    }

    public static void busquedaCodigoZona(){
        //ARREGLO (MANUAL) DESORDENADO
        char[] arregloCodigoZonaDesordenado = new char[16];
        for (int i = 0; i < vectorFauna.length; i++) {
            arregloCodigoZonaDesordenado[i]=vectorFauna[i].getCodigozona();
        }
        //TERMINAR - ARREGLO (MANUAL) ORDENADO SEGUN ASCII
        char[] arregloCodigoZonaOrdenado = new char[16];
        for (int i = 0; i < vectorFauna.length; i++) {
            arregloCodigoZonaOrdenado[i]=vectorFauna[i].getCodigozona();
        }
        //LISTA ENLAZADA (MANUAL) DESORDENADA
        
        //LISTA ENLAZADA (MANUAL) ORDENADA SEGUN ASCII
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
