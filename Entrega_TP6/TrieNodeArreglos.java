package Entrega_TP6;
public class TrieNodeArreglos extends TrieNode {
    private TrieNodeArreglos[] hijos;
    public TrieNodeArreglos(char character, int cantidadCaracteres) {
        super(character);
        hijos = new TrieNodeArreglos[cantidadCaracteres];
    }
    public TrieNodeArreglos getHijo(int posicion) {
        return hijos[posicion];
    }
    public void setHijo(int posicion, TrieNodeArreglos nuevoHijo) {
        hijos[posicion] = nuevoHijo;
    }
}

