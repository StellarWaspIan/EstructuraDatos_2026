package TP_2_Ordenamiento.Ejercicio_10;

public class Cola {
    private Nodo frente;
    private Nodo fin;
    public Cola() {
        frente = null;
        fin = null;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void meter(Evento evento) {
        Nodo nuevo = new Nodo(evento);
        if (estaVacia()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.sig = nuevo;
            fin = nuevo;
        }
    }

    public Evento sacar() {
        if (estaVacia()) {
            return null;
        }
        Evento evento = frente.info;
        frente = frente.sig;
        if (frente == null) {
            fin = null;
        }
        return evento;
    }
}
