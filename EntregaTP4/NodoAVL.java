package EntregaTP4;


public class NodoAVL {
    Contenedor carga;
    NodoAVL izquierdo;
    NodoAVL derecho;
    int altura;

    public NodoAVL(Contenedor carga) {
        this.carga = carga;
        this.izquierdo = null;
        this.derecho = null;
        this.altura = 1;
    }

    public Contenedor getCarga() {
        return carga;
    }

    public void setCarga(Contenedor carga) {
        this.carga = carga;
    }

    public NodoAVL getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoAVL izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoAVL getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoAVL derecho) {
        this.derecho = derecho;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}

