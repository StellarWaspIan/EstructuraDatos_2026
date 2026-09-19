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
        switch (posicion) {
            case 1:
                return (evento.getTiempo().getSegundo()) % 10;
            case 2:
                return (evento.getTiempo().getSegundo()) / 10;
            case 3:
                return (evento.getTiempo().getMinuto()) % 10;
            case 4:
                return (evento.getTiempo().getMinuto()) / 10;
            case 5:
                return (evento.getTiempo().getHora()) % 10;
            case 6:
                return (evento.getTiempo().getHora()) / 10;
            default:
                return 0;
        }
    }
}
