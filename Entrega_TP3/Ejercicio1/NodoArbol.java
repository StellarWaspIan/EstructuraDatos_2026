package Entrega_TP3.Ejercicio1;

public class NodoArbol {
    char info;
    NodoArbol izquierda, derecha;

    public NodoArbol(char info) {
        this.info = info;
        this.izquierda = null;
        this.derecha = null;
    }

    public char getInfo() {
        return info;
    }

    public void setInfo(char info) {
        this.info = info;
    }

    public NodoArbol getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoArbol izquierda) {
        this.izquierda = izquierda;
    }

    public NodoArbol getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoArbol derecha) {
        this.derecha = derecha;
    }
}
