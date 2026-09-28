package Entrega_TP3.Ejercicio1;
import java.util.ArrayList;

public class EstructurasBusqueda {
    public int sequentialSearch(char[] vec, char search) {
        int cant=0;
        for (int i = 0; i < vec.length; i++) {
            if (vec[i]==search) {
                cant++;
                return cant;
            }
            cant++;
        }
        return cant;
    }

    public int binarySearch(char[] vec, char search) {
        int first=0, mid, last=vec.length - 1, cant=0;
        while(first<=last) {
            mid=(first + last) / 2;
            if(vec[mid]==search){
                cant++;
                return cant;
            } else if(vec[mid]>search){
                last=mid - 1;
                cant++;
            } else{
                first=mid + 1;
            }
            cant+=2;
        }
        return cant;
    }

    public int sequentialSearchList(ArrayList<Character> vec, char search) {
        int cant=0;
        for (int i = 0; i < vec.size(); i++) {
            if (vec.get(i)==search) {
                cant++;
                return cant;
            }
            cant++;
        }
        return cant;
    }

    public int binarySearchList(ArrayList<Character> vec, char search) {
        int first=0, mid, last=vec.size() - 1, cant=0;
        while(first<=last) {
            mid=(first + last) / 2;
            if(vec.get(mid)==search){
                cant++;
                return cant;
            } else if(vec.get(mid)>search){
                last=mid - 1;
                cant++;
            } else{
                first=mid + 1;
            }
            cant+=2;
        }
        return cant;
    }

    public int binarySearchABB(Arbol abb, char search){
        Nodo actual = abb.raiz;
        int cant = 0;
        while (actual != null) {
            cant++;
            if (actual.info == search) {
                return cant;
            }
            cant++;
            if (search < actual.info) {
                actual = actual.izquierda;
            } else {
                actual = actual.derecha;
            }
        }
        return cant;
    }
    
}
