package Entrega_TP3.Ejercicio1;

public class ListaASCII {
    NodoLista lista;
    public ListaASCII() {
        lista = null;
    }
    // INSERTAR ORDENADO SEGÚN ASCII
    public void insertarElemento(char valor) {
        NodoLista nuevo = new NodoLista(valor);
        // CASO 1: Lista vacía
        if (lista == null) {
            lista = nuevo;
            return;
        }
        // CASO 2: Insertar antes del primero
        if (valor < lista.getInfo()) {
            nuevo.setSig(lista);
            lista = nuevo;
            return;
        }
        NodoLista puntero = lista;
        // Buscar posición
        while (puntero.getSig() != null && puntero.getSig().getInfo() < valor) {
            puntero = puntero.getSig();
        }
        // CASO 3 y 4: Insertar en medio o al final
        nuevo.setSig(puntero.getSig());
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
        // Lista vacía o Nodo no encontrado
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
