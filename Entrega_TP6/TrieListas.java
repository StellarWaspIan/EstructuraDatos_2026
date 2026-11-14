package Entrega_TP6;
public class TrieListas extends Trie {
    public TrieListas() {
        super();
    }

    @Override
    protected TrieNode crearNodo(char character) {
        return new TrieNodeListas(character);
    }

    @Override
    protected TrieNode obtenerHijo(TrieNode nodo, char character) {
        TrieNodeListas actual = (TrieNodeListas) nodo;
        actual = actual.getDown();
        while (actual != null) {
            if (actual.getCharacter() == character) 
                return actual;
            actual = actual.getRight();
        }
        return null;
    }

    @Override
    protected void establecerHijo(TrieNode nodo, char character, TrieNode nuevoNodo) {
        TrieNodeListas actual = (TrieNodeListas) nodo;
        TrieNodeListas nuevo = (TrieNodeListas) nuevoNodo;
        if (actual.getDown() == null) {
            actual.setDown(nuevo);
        } else {
            TrieNodeListas auxiliar = actual.getDown();
            while (auxiliar.getRight() != null)
                auxiliar = auxiliar.getRight();
            auxiliar.setRight(nuevo);
        }
    }
}
