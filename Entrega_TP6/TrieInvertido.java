package Entrega_TP6;
import java.util.*;
public class TrieInvertido {
    Trie trie;
    public TrieInvertido(Trie trie) {
        this.trie = trie;
    }
    public void insertar(String palabra) {
        String palabraInvertida = invertir(palabra);
        trie.insertar(palabraInvertida);
    }
    public ArrayList<String> buscarPorSufijo(String sufijo) {
        ArrayList<String> resultados = new ArrayList<>();
        String sufijoInvertido = invertir(sufijo);
        ArrayList<String> palabrasInvertidas = trie.buscarPorPrefijo(sufijoInvertido);
        for (int i = 0; i < palabrasInvertidas.size(); i++) {
            resultados.add(invertir(palabrasInvertidas.get(i)));
        }
        return resultados;
    }
    private String invertir(String palabra) {
        return new StringBuilder(palabra).reverse().toString();
    }
}

