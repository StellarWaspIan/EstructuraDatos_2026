package Entrega_TP3.Ejercicio1;

public class NodoLista {
    char info;
    NodoLista sig;

    public NodoLista(char valor) {
        info = valor;
        sig = null;
    }
    void setInfo(char valor) {
        info = valor;
    }
    void setSig(NodoLista dir) {
        sig = dir;
    }
    char getInfo() {
        return info;
    }
    NodoLista getSig() {
        return sig;
    }
}
