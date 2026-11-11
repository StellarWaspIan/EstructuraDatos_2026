package Entrega_TP6;
public abstract class TrieNode {
    protected char character;
    protected boolean finPalabra;
    public TrieNode(char character) {
        this.character = character;
        this.finPalabra = false;
    }
    public char getCharacter() {
        return character;
    }
    public boolean esFinPalabra() {
        return finPalabra;
    }
    public void setFinPalabra(boolean finPalabra) {
        this.finPalabra = finPalabra;
    }
}

