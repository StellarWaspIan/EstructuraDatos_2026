package Entrega_TP6;

public class TrieMatriz extends Trie {
    private static final int MAX_NODOS = 10000;
    private int[][] matriz;
    private char[] caracteres;
    private TrieNodeMatriz[] nodos;
    private int cantidadNodos;
    
    public TrieMatriz() {
        matriz = new int[MAX_NODOS][ALFABETO.length()];
        caracteres = new char[MAX_NODOS];
        nodos = new TrieNodeMatriz[MAX_NODOS];
        cantidadNodos = 0;
        for (int i = 0; i < MAX_NODOS; i++) {
            for (int j = 0; j < ALFABETO.length(); j++) {
                matriz[i][j] = -1;
            }
        }
    }

    @Override
    protected TrieNode crearNodo(char character) {
        if (cantidadNodos >= MAX_NODOS) 
            throw new IllegalStateException("Trie Lleno");
        TrieNodeMatriz nuevo = new TrieNodeMatriz(character);
        nuevo.setIndice(cantidadNodos);
        caracteres[cantidadNodos] = character;
        nodos[cantidadNodos] = nuevo;
        cantidadNodos++;
        return nuevo;
    }

    @Override
    protected TrieNode obtenerHijo(TrieNode nodo, char character) {
        int fila = ((TrieNodeMatriz) nodo).getIndice();
        int columna = ALFABETO.indexOf(character);
        if (columna == -1) 
            return null;
        int indiceHijo = matriz[fila][columna];
        if (indiceHijo == -1) 
            return null;
        return nodos[indiceHijo];
    }

    @Override
    protected void establecerHijo(TrieNode nodo, char character, TrieNode nuevoNodo) {
        int fila = ((TrieNodeMatriz) nodo).getIndice();
        int columna = ALFABETO.indexOf(character);
        int indiceHijo = ((TrieNodeMatriz) nuevoNodo).getIndice();
        matriz[fila][columna] = indiceHijo;
    }
}


