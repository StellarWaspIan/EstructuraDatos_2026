package Entrega_TP6;

public class TrieNodeMatriz extends TrieNode {
    private int indice;
    public TrieNodeMatriz(char character) {
        super(character);
        indice = -1;
    }
    public int getIndice() {
        return indice;
    }
    public void setIndice(int indice) {
        this.indice = indice;
    }
}


