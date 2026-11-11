package Entrega_TP6;
public class TrieListas extends Trie {
    public TrieListas() {
        super();
    }
    // CREAR NODO
    @Override
    protected TrieNode crearNodo(char character) {
        return new TrieNodeListas(character);
    }
    // OBTENER HIJO
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
    // ESTABLECER HIJO
    @Override
    protected void establecerHijo(TrieNode nodo, char character, TrieNode nuevoNodo) {
        TrieNodeListas actual = (TrieNodeListas) nodo;
        TrieNodeListas nuevo = (TrieNodeListas) nuevoNodo;
        // Si no existen hijos, el nuevo nodo sera el primero
        if (actual.getDown() == null) {
            actual.setDown(nuevo);
        } else {
            // Recorrer hasta el ultimo hermano
            TrieNodeListas auxiliar = actual.getDown();
            while (auxiliar.getRight() != null)
                auxiliar = auxiliar.getRight();
            // Enlazar el nuevo nodo al final
            auxiliar.setRight(nuevo);
        }
    }
}
