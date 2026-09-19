package TP_2_Ordenamiento.Ejercicio_10;

public class Sorts {
    public static void radixSortCronologico(Evento[] eventos, int cantidad) {
        for (int i = 0; i < 7; i++) {
            radixSort(eventos, cantidad, i);
        }
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
