package Entrega_TP3.Ejercicio1;
public class Arbol {
    Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    public void insertar(char info) {
        Nodo nuevo = new Nodo(info);

        if (raiz == null) {
            raiz = nuevo;
            return;
        }

        Nodo actual = raiz;

        while (true) {
            if (info < actual.info) {

                if (actual.izquierda == null) {
                    actual.izquierda = nuevo;
                    return;
                }

                actual = actual.izquierda;

            } else {

                if (actual.derecha == null) {
                    actual.derecha = nuevo;
                    return;
                }

                actual = actual.derecha;
            }
        }
    }
}
