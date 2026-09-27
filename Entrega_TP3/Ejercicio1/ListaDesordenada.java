package Entrega_TP3.Ejercicio1;

public class ListaDesordenada {
    NodoLista lista;
    public ListaDesordenada() {
        lista = null;
    }
    // INSERTAR AL FINAL
    public void insertarElemento(char valor) {
        NodoLista nuevo = new NodoLista(valor);
        // Lista vacía
        if (lista == null) {
            lista = nuevo;
            return;
        }
        // Buscar el último nodo
        NodoLista puntero = lista;
        while (puntero.getSig() != null) {
            puntero = puntero.getSig();
        }
        // Insertar al final
        puntero.setSig(nuevo);
    }

    // BUSCAR POR CARÁCTER
    public NodoLista buscarElemento(char valor) {
        NodoLista puntero = lista;
        while (puntero != null) {
            if (puntero.getInfo() == valor) {
                return puntero;
            }
            puntero = puntero.getSig();
        }
        return null;
    }

    // ELIMINAR POR CARÁCTER
    public boolean eliminarNodo(char valor) {
        NodoLista nodoEliminar = buscarElemento(valor);
        // Lista vacía o nodo no encontrado
        if (lista == null || nodoEliminar == null) {
            return false;
        }
        // Eliminar primero
        if (lista == nodoEliminar) {
            lista = lista.getSig();
            return true;
        }
        NodoLista puntero = lista;
        while (puntero.getSig() != null && puntero.getSig() != nodoEliminar) {
            puntero = puntero.getSig();
        }
        // Nodo encontrado
        if (puntero.getSig() == nodoEliminar) {
            puntero.setSig(nodoEliminar.getSig());
            return true;
        }
        return false;
    }
}
