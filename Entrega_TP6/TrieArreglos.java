package Entrega_TP6;
public class TrieArreglos extends Trie {
    public TrieArreglos() {
        super();
    }

    @Override
    protected TrieNode crearNodo(char character) {
        return new TrieNodeArreglos(character, ALFABETO.length());
    }

    @Override
    protected TrieNode obtenerHijo(TrieNode nodo, char character) {
        int posicion = ALFABETO.indexOf(character);
        if (posicion == -1)
            return null;
        TrieNodeArreglos actual = (TrieNodeArreglos) nodo;
        return actual.getHijo(posicion);
    }

    @Override
    protected void establecerHijo(TrieNode nodo, char character, TrieNode nuevoNodo) {
        int posicion = ALFABETO.indexOf(character);
        TrieNodeArreglos actual = (TrieNodeArreglos) nodo;
        actual.setHijo(posicion, (TrieNodeArreglos) nuevoNodo);
    }
}

