package Entrega_TP2.Ejercicio2;

public class Sorts {
    
    private static void intercambio(Pasajero[] vec, int p1, int p2) {
        Pasajero aux = vec[p1];
        vec[p1] = vec[p2];
        vec[p2] = aux;
    }
    
    //PUNTO A - ORDENAR POR LEGAJO CON SHELLSORT
    public static void shellSort(Pasajero[] vec, int cantidad) {
        int intervalo = cantidad / 2;
        while (intervalo > 0) {
            for (int i = intervalo; i < cantidad; i++) {
                int j = i;
                while (j >= intervalo) {
                    if (vec[j - intervalo].getLegajo() <= vec[j].getLegajo()) {
                        j = 0;
                    } else {
                        intercambio(vec, j - intervalo, j);
                        j -= intervalo;
                    }
                }
            }
            intervalo /= 2;
        }
    }
    
    //PUNTO B - ORDENAR POR NOMBRE CON MERGESORT
    public static void mergeSort(Pasajero[] vec, int cantidad) {
        Pasajero[] tmp = new Pasajero[cantidad];
        mergeSort(vec, tmp, 0, cantidad - 1);
    }
    private static void mergeSort(Pasajero[] vec, Pasajero[] tmp, int left, int right) {
        if (left < right) {
            int center = (right + left) / 2;
            mergeSort(vec, tmp, left, center);
            mergeSort(vec, tmp, center + 1, right);
            merge(vec, tmp, left, center, right);
        }
    }
    private static void merge(Pasajero[] vec, Pasajero[] tmp, int left, int center, int right) {
        int aptr = left;
        int bptr = center + 1;
        int cptr = left;

        while (aptr <= center && bptr <= right) {
            if (vec[aptr].getNombre().compareTo(vec[bptr].getNombre()) <= 0) {
                tmp[cptr++] = vec[aptr++];
            } else {
                tmp[cptr++] = vec[bptr++];
            }
        }
        while (aptr <= center) {
            tmp[cptr++] = vec[aptr++];
        }
        while (bptr <= right) {
            tmp[cptr++] = vec[bptr++];
        }
        for (int i = left; i <= right; i++) {
            vec[i] = tmp[i];
        }
    }

    //PUNTO C - ORDENAR POR PRIORIDAD CON HEAPSORT
    public static void heapSort(Pasajero[] vec, int cantidad) {
        for (int i = (cantidad / 2) - 1; i >= 0; i--) {
            reHeapDown(vec, i, cantidad);
        }
        for (int i = cantidad - 1; i > 0; i--) {
            intercambio(vec, 0, i);
            reHeapDown(vec, 0, i);
        }
    }
    private static void reHeapDown(Pasajero[] vec, int startNode, int index) {
        boolean done = false;
        Pasajero aux = vec[startNode];
        int parent = startNode;
        int child = 2 * (startNode + 1) - 1;
        while (child < index && !done) {
            if (child < index - 1) {
                if (vec[child].getPrioridad() < vec[child + 1].getPrioridad()) {
                    child++;
                }
            }
            if (aux.getPrioridad() >= vec[child].getPrioridad()) {
                done = true;
            } else {
                vec[parent] = vec[child];
                parent = child;
                child = 2 * (parent + 1) - 1;
            }
        }
        vec[parent] = aux;
    }

    //PUNTO D - ORDENAR POR PROMEDIO CON QUICKSORT
    public static Contadores quickSort(Pasajero[] vec, int cantidad) {
        Contadores contadores = new Contadores();
        quickSort(vec, 0, cantidad - 1, contadores);
        return contadores;
    }
    private static void quickSort(Pasajero[] vec, int first, int last, Contadores contadores) {
        int center = (first + last) / 2;
        if (first < last) {
            center = division(vec, first, last, center, contadores);
            quickSort(vec, first, center, contadores);
            if (center == first) {
                quickSort(vec, center + 1, last, contadores);
            } else {
                quickSort(vec, center, last, contadores);
            }
        }
    }
    private static int division(Pasajero[] vec, int first, int last, int center, Contadores contadores) {
        int left, right;
        Pasajero data;
        data = vec[center];
        left = first;
        right = last;
        do {
            while (left < right) {
                contadores.comparaciones++;
                if (vec[left].getPromedio() < data.getPromedio()) {
                    left++;
                } else {
                    break;
                }
            }
            while (left < right) {
                contadores.comparaciones++;
                if (vec[right].getPromedio() > data.getPromedio()) {
                    right--;
                } else {
                    break;
                }
            }
            if (left < right) {
                intercambio(vec, left, right);
                contadores.intercambios++;
                left++;
                right--;
            }
        } while (left < right);
        if (left < right) {
            int pos = right;
            right = left;
            left = pos;
        }
        return left;
    }

    //PUNTO D - ORDENAR POR PROMEDIO CON SHAKERSORT
    public static Contadores shakerSort(Pasajero[] vec, int cantidad) {
        Contadores contadores = new Contadores();
        int left = 1;
        int right = cantidad - 1;
        int aux = cantidad - 1;
        do {
            for (int i = right; i >= left; i--) {
                contadores.comparaciones++;
                if (vec[i - 1].getPromedio() > vec[i].getPromedio()) {
                    intercambio(vec, i - 1, i);
                    contadores.intercambios++;
                    aux = i;
                }
            }
            left = aux + 1;
            for (int i = left; i <= right; i++) {
                contadores.comparaciones++;
                if (vec[i - 1].getPromedio() > vec[i].getPromedio()) {
                    intercambio(vec, i - 1, i);
                    contadores.intercambios++;
                    aux = i;
                }
            }
            right = aux - 1;
        } while (left < right);
        return contadores;
    }

}
