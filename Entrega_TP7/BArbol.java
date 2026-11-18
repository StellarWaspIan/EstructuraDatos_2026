package Entrega_TP7;

import java.util.*;

public class BArbol {
    BNodo raiz;
    int orden;
    public BArbol(int orden) {
        this.orden = orden;
        raiz = null;
    }

    // BUSQUEDA
    public boolean buscarClave(String clave) {
        BNodo nodoActual = raiz;
        while (nodoActual != null) {
            Keys claves = nodoActual.getClaves();
            int posicion = claves.buscar(clave);
            // La clave fue encontrada.
            if (posicion == -1) {
                return true;
            }
            // Si es hoja, la clave no existe.
            if (nodoActual.esHoja()) {
                return false;
            }
            // Continuar por el hijo correspondiente.
            nodoActual = nodoActual.obtenerHijo(posicion);
        }
        return false;
    }

    // INSERCION
    public void insertarClave(String clave) {
        // Evitar claves repetidas.
        if (buscarClave(clave)) {
            return;
        }
        // Caso inicial: arbol vacio.
        if (raiz == null) {
            raiz = new BNodo(orden);
            raiz.getClaves().insertar(clave);
            return;
        }
        BNodo nodoActual = raiz;
        Stack<BNodo> camino = new Stack<>();
        // Buscar la hoja donde se insertara la clave.
        while (!nodoActual.esHoja()) {
            Keys claves = nodoActual.getClaves();
            int posicion = claves.buscar(clave);
            camino.push(nodoActual);
            nodoActual = nodoActual.obtenerHijo(posicion);
        }
        // Insertar la clave en la hoja.
        nodoActual.getClaves().insertar(clave);
        // Resolver posibles desbordamientos.
        while (nodoActual.getClaves().getCantidad() == orden) {
            Keys clavesActuales = nodoActual.getClaves();
            // Obtener la posicion de la mediana.
            int medio = orden / 2;
            String mediana = clavesActuales.obtenerClave(medio);
            // Crear el nuevo nodo derecho.
            BNodo nuevoNodo = new BNodo(orden);
            // Mover las claves mayores que la mediana.
            for (int i = medio + 1; i < clavesActuales.getCantidad(); i++) {
                nuevoNodo.getClaves().insertar(clavesActuales.obtenerClave(i));
            }
            // Eliminar las claves que fueron movidas.
            while (clavesActuales.getCantidad() > medio) {
                clavesActuales.eliminarEn(medio);
            }
            // Si el nodo tenia hijos, mover los hijos derechos.
            if (!nodoActual.esHoja()) {
                while (nodoActual.grado() > medio + 1) {
                    BNodo hijo = nodoActual.eliminarHijo(medio + 1);
                    nuevoNodo.agregarHijo(hijo);
                }
            }
            // Si el nodo desbordado era la raiz.
            if (nodoActual == raiz) {
                BNodo nuevaRaiz = new BNodo(orden);
                nuevaRaiz.getClaves().insertar(mediana);
                nuevaRaiz.agregarHijo(nodoActual);
                nuevaRaiz.agregarHijo(nuevoNodo);
                raiz = nuevaRaiz;
                return;
            }
            // Recuperar el padre.
            BNodo padre = camino.pop();
            Keys clavesPadre = padre.getClaves();
            // Insertar la mediana en el padre.
            int posicion = clavesPadre.insertar(mediana);
            // Insertar el nuevo hijo a la derecha de la mediana.
            padre.insertarHijo(nuevoNodo, posicion + 1);
            // Continuar verificando el padre.
            nodoActual = padre;
        }
    }

    // ELIMINACION
    public boolean eliminarClave(String clave) {
        if (!buscarClave(clave)) {
            return false;
        }
        eliminarRecursivo(raiz, clave);

        // Si la raiz queda vacia, reducir la altura.
        if (raiz != null &&
                raiz.getClaves().getCantidad() == 0) {
            if (raiz.esHoja()) {
                raiz = null;
            } else {
                raiz = raiz.obtenerHijo(0);
            }
        }
        return true;
    }

    void eliminarRecursivo(BNodo nodo, String clave) {
        Keys claves = nodo.getClaves();
        int posicion = claves.buscar(clave);

        // CASO 1: LA CLAVE ESTA EN EL NODO
        if (posicion == -1) {
            // Si es hoja, eliminar directamente.
            if (nodo.esHoja()) {
                claves.eliminar(clave);
                return;
            }
            // Si no es hoja, buscar el predecesor.
            BNodo nodoPredecesor = nodo.obtenerHijo(posicion);
            while (!nodoPredecesor.esHoja()) {
                nodoPredecesor = nodoPredecesor.obtenerHijo(nodoPredecesor.grado() - 1);
            }
            Keys clavesPredecesor = nodoPredecesor.getClaves();
            String predecesor = clavesPredecesor.obtenerClave(clavesPredecesor.getCantidad() - 1);
            // Reemplazar la clave por su predecesora.
            claves.eliminar(clave);
            claves.insertar(predecesor);
            // Eliminar el predecesor de su hoja.
            eliminarRecursivo(nodoPredecesor, predecesor);
            return;
        }

        // CASO 2: LA CLAVE NO ESTA EN EL NODO
        if (nodo.esHoja()) {
            return;
        }
        eliminarRecursivo(nodo.obtenerHijo(posicion), clave);
    }
}
