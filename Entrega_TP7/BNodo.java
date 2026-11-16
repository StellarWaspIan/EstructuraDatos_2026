package Entrega_TP7;


public class BNodo {
    Keys claves;
    BNodo[] hijos;
    int cantidadHijos;
    int orden;

    public BNodo(int orden) {
        this.orden = orden;
        // Capacidad temporal para permitir el desbordamiento.
        claves = new Keys(orden);
        // Un nodo puede tener como maximo orden hijos.
        hijos = new BNodo[orden];
        cantidadHijos = 0;
    }

    // Obtiene el conjunto de claves del nodo.
    public Keys getClaves() {
        return claves;
    }

    // Establece el conjunto de claves del nodo.
    public void setClaves(Keys claves) {
        this.claves = claves;
    }

    // Obtiene un hijo segun su posicion.
    public BNodo obtenerHijo(int posicion) {
        if (posicion < 0 || posicion >= cantidadHijos) {
            return null;
        }
        return hijos[posicion];
    }

    // Agrega un hijo al final del arreglo.
    public boolean agregarHijo(BNodo hijo) {
        if (cantidadHijos >= hijos.length) {
            return false;
        }
        hijos[cantidadHijos] = hijo;
        cantidadHijos++;
        return true;
    }

    // Inserta un hijo en una posicion determinada.
    public boolean insertarHijo(BNodo hijo, int posicion) {
        if (cantidadHijos >= hijos.length) {
            return false;
        }
        if (posicion < 0 || posicion > cantidadHijos) {
            return false;
        }
        for (int i = cantidadHijos; i > posicion; i--) {
            hijos[i] = hijos[i - 1];
        }
        hijos[posicion] = hijo;
        cantidadHijos++;
        return true;
    }

    // Elimina un hijo segun su posicion.
    public BNodo eliminarHijo(int posicion) {
        if (posicion < 0 || posicion >= cantidadHijos) {
            return null;
        }
        BNodo hijoEliminado = hijos[posicion];
        for (int i = posicion; i < cantidadHijos - 1; i++) {
            hijos[i] = hijos[i + 1];
        }
        cantidadHijos--;
        hijos[cantidadHijos] = null;
        return hijoEliminado;
    }

    // Elimina un hijo buscando su referencia.
    public void quitarHijo(BNodo hijo) {
        for (int i = 0; i < cantidadHijos; i++) {
            if (hijos[i] == hijo) {
                eliminarHijo(i);
                return;
            }
        }
    }

    // Devuelve la cantidad de hijos del nodo.
    public int grado() {
        return cantidadHijos;
    }

    // Un nodo es hoja cuando no tiene hijos.
    public boolean esHoja() {
        return cantidadHijos == 0;
    }
}
