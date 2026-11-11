package Entrega_TP6;
public class TrieNodeListas extends TrieNode {
    private TrieNodeListas right;
    private TrieNodeListas down;
    public TrieNodeListas(char character) {
        super(character);
        right = null;
        down = null;
    }
    public TrieNodeListas getRight() {
        return right;
    }
    public void setRight(TrieNodeListas right) {
        this.right = right;
    }
    public TrieNodeListas getDown() {
        return down;
    }
    public void setDown(TrieNodeListas down) {
        this.down = down;
    }
}

