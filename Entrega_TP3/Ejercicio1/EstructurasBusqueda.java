package Entrega_TP3.Ejercicio1;

public class EstructurasBusqueda {
    public static int interpolationSearch(int[] vec, int search) {
        int first=0;
        int mid;
        int last=vec.length - 1;
        while(search>=vec[first] & search<=vec[last]) {
            mid= first + (int)Math.abs(Math.floor((search - vec[first]) * (last-first) / (vec[last]-vec[first])));
            if(search==vec[mid]){
                return mid;
            } else{
                if(search<vec[mid]){
                    last=mid - 1;
                } else{
                    first=mid + 1;
                }
            }
        }
        return -1;
    }

    public static int busquedaSequencial(int[] vec, int search) {
        int pos=0;
        while(pos<vec.length) {
            if(vec[pos] == search){
                return pos;
            }
            pos++;
        }
        return -1;
    }
    public static int binarySearch(int[] vec, int search) {
        int first=0;
        int mid;
        int last=vec.length - 1;
        while(first<=last) {
            mid=(first + last) / 2;
            if(vec[mid]==search)
            return mid;
            else
            if(vec[mid]>search)
            last=mid - 1;
            else
            first=mid + 1;
        }
        return -1;
        }
}
