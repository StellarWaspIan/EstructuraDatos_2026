package TP_2_Ordenamiento.Ejercicio_10;

public class Sorts {
    //unidad segundos 1, decena segundos 2
    //unidad minutos 3, decena minutos 4
    //unidad horas 5, decena horas 6
    public static void radixSortCronologico(Evento[] eventos, int cantidad) {
        //segundos
        radixSort(eventos, cantidad, 1);
        radixSort(eventos, cantidad, 2);
        //minutos
        radixSort(eventos, cantidad, 3);
        radixSort(eventos, cantidad, 4);
        //horas
        radixSort(eventos, cantidad, 5);
        radixSort(eventos, cantidad, 6);
    }
    private static void radixSort(Evento[] eventos, int cantidad, int posicion) {
        Cola[] urnas = new Cola[10];
        for (int i = 0; i < urnas.length; i++) {
            urnas[i] = new Cola();
        }
        for (int i = 0; i < cantidad; i++) {
            int clave = getKey(eventos[i], posicion);
            urnas[clave].meter(eventos[i]);
        }
        int j = 0;
        for (int i = 0; i < 10; i++) {
            while (!urnas[i].estaVacia()) {
                eventos[j] = urnas[i].sacar();
                j++;
            }
        }
    }
    private static int getKey(Evento evento, int posicion) {
        int valor;
        // el resto nos devuelve el digito decimal y la division nos devuelve el ultimo porque como son enteros los redondea
        switch (posicion) {
            case 1:
                valor = evento.getTiempo().getSegundo();
                return valor % 10;
            case 2:
                valor = evento.getTiempo().getSegundo();
                return valor / 10;
            case 3:
                valor = evento.getTiempo().getMinuto();
                return valor % 10;
            case 4:
                valor = evento.getTiempo().getMinuto();
                return valor / 10;
            case 5:
                valor = evento.getTiempo().getHora();
                return valor % 10;
            case 6:
                valor = evento.getTiempo().getHora();
                return valor / 10;
            default:
                return 0;
        }
    }
}
