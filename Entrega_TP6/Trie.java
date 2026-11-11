package Entrega_TP6;
import java.util.*;
public abstract class Trie {
    protected TrieNode root;
    protected static final String ALFABETO = "abcdefghijklmnopqrstuvwxyzñáéíóú";
    public Trie() {root = null;}
    // Operaciones que implementara cada representacion
    protected abstract TrieNode crearNodo(char character);
    protected abstract TrieNode obtenerHijo(TrieNode nodo, char character);
    protected abstract void establecerHijo(TrieNode nodo, char character, TrieNode nuevoNodo);
    // Normalizacion y validacion
    protected String normalizar(String palabra) {
        return palabra.toLowerCase(Locale.ROOT);
    }
    protected boolean caracterValido(char character) {
        return ALFABETO.indexOf(character) != -1;
    }
    // INSERTAR
    public void insertar(String palabra) {
        palabra = normalizar(palabra);
        if (palabra.isEmpty()) {
            return;
        }
        for (int i = 0; i < palabra.length(); i++) {
            if (!caracterValido(palabra.charAt(i))) 
                return;
        }
        if (root == null) 
            root = crearNodo('\0');
        TrieNode actual = root;
        for (int i = 0; i < palabra.length(); i++) {
            char character = palabra.charAt(i);
            TrieNode siguiente = obtenerHijo(actual, character);
            if (siguiente == null) {
                siguiente = crearNodo(character);
                establecerHijo(actual, character, siguiente);
            }
            actual = siguiente;
        }
        actual.setFinPalabra(true);
    }
    // BUSCAR
    public boolean buscar(String palabra) {
        palabra = normalizar(palabra);
        if (root == null || palabra.isEmpty())
            return false;
        TrieNode actual = root;
        for (int i = 0; i < palabra.length(); i++) {
            char character = palabra.charAt(i);
            if (!caracterValido(character)) 
                return false;
            actual = obtenerHijo(actual, character);
            if (actual == null) 
                return false;
        }
        return actual.esFinPalabra();
    }
    // CANTIDAD DE PALABRAS
    public int cantidadPalabras() {
        return contarPalabras(root);
    }
    private int contarPalabras(TrieNode nodo) {
        if (nodo == null) 
            return 0;
        int cantidad = 0;
        if (nodo.esFinPalabra())
            cantidad++;
        for (int i = 0; i < ALFABETO.length(); i++) {
            char character = ALFABETO.charAt(i);
            TrieNode hijo = obtenerHijo(nodo, character);
            cantidad += contarPalabras(hijo);
        }
        return cantidad;
    }
    // LISTAR TODAS LAS PALABRAS
    public ArrayList<String> listarPalabras() {
        ArrayList<String> palabras = new ArrayList<>();
        if (root != null)
            recorrerPalabras(root, "", palabras);
        return palabras;
    }
    private void recorrerPalabras(TrieNode nodo, String palabraActual, ArrayList<String> palabras) {
        if (nodo.esFinPalabra()) 
            palabras.add(palabraActual);
        for (int i = 0; i < ALFABETO.length(); i++) {
            char character = ALFABETO.charAt(i);
            TrieNode hijo = obtenerHijo(nodo, character);
            if (hijo != null) 
                recorrerPalabras(hijo, palabraActual + character, palabras);
        }
    }
    // BUSCAR POR PREFIJO
    public ArrayList<String> buscarPorPrefijo(String prefijo) {
        ArrayList<String> resultados = new ArrayList<>();
        prefijo = normalizar(prefijo);
        if (root == null || prefijo.isEmpty()) 
            return resultados;
        TrieNode actual = root;
        for (int i = 0; i < prefijo.length(); i++) {
            char character = prefijo.charAt(i);
            if (!caracterValido(character)) 
                return resultados;
            actual = obtenerHijo(actual, character);
            if (actual == null) 
                return resultados;
        }
        recorrerPalabras(actual, prefijo, resultados);
        return resultados;
    }
    // CONTAR PREFIJOS DISTINTOS
    public int cantidadPrefijos() {
        return contarPrefijos(root);
    }
    private int contarPrefijos(TrieNode nodo) {
        if (nodo == null)
            return 0;
        int cantidad = 0;
        for (int i = 0; i < ALFABETO.length(); i++) {
            char character = ALFABETO.charAt(i);
            TrieNode hijo = obtenerHijo(nodo, character);
            if (hijo != null) {
                cantidad++;
                cantidad += contarPrefijos(hijo);
            }
        }
        return cantidad;
    }
}

