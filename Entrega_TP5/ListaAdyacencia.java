
public class ListaAdyacencia {
    CentroLogistico[] centros;
    NodoRuta[] listas;
    int cantidadCentros;
    private class NodoRuta {
        int destino; RutaTransporte ruta; NodoRuta siguiente;
        public NodoRuta(int destino, RutaTransporte ruta) {
            this.destino = destino;
            this.ruta = ruta;
            this.siguiente = null;}
    }
    public ListaAdyacencia(int capacidad) {
        centros = new CentroLogistico[capacidad];
        listas = new NodoRuta[capacidad];
        cantidadCentros = 0;
    }
    public void agregarCentro(CentroLogistico centro) {
        centros[cantidadCentros] = centro;
        listas[cantidadCentros] = null;
        cantidadCentros++;
    }
    private int buscarIndice(String id) {
        for (int i = 0; i < cantidadCentros; i++) {
            if (centros[i].getId().equals(id)) {return i;}}
        return -1;
    }
    private void agregarRutaDirigida(int origen, int destino, RutaTransporte ruta) {
        NodoRuta nuevo = new NodoRuta(destino, ruta);
        if (listas[origen] == null) { listas[origen] = nuevo;} else {
            NodoRuta actual = listas[origen];
            while (actual.siguiente != null) {
                actual = actual.siguiente;}
            actual.siguiente = nuevo;
        }
    }
    public void agregarRuta(String origenId, String destinoId, RutaTransporte ruta) {
        int origen = buscarIndice(origenId);
        int destino = buscarIndice(destinoId);
        agregarRutaDirigida(origen, destino, ruta);
        agregarRutaDirigida(destino, origen, ruta);
    }

    public void dijkstraMulticriterio(String origenId, CriterioRuta criterio) {
        int origen = buscarIndice(origenId);
        double[] distanciasMinimas = new double[cantidadCentros];
        int[] predecesores = new int[cantidadCentros];
        boolean[] visitados = new boolean[cantidadCentros];
        for (int i = 0; i < cantidadCentros; i++) {
            distanciasMinimas[i] = Double.POSITIVE_INFINITY;
            predecesores[i] = -1;
            visitados[i] = false;}
        distanciasMinimas[origen] = 0;
        for (int i = 0; i < cantidadCentros; i++) {
            int actual = -1;
            double menorDistancia = Double.POSITIVE_INFINITY;
            for (int j = 0; j < cantidadCentros; j++) {
                if (!visitados[j] && distanciasMinimas[j] < menorDistancia) {
                    menorDistancia = distanciasMinimas[j];
                    actual = j;}}
            if (actual == -1) {break;}
            visitados[actual] = true;
            NodoRuta vecino = listas[actual];
            while (vecino != null) {
                int destino = vecino.destino;
                if (!visitados[destino]) {
                    double peso = vecino.ruta.obtenerPeso(criterio);
                    double nuevaDistancia = distanciasMinimas[actual] + peso;
                    if (nuevaDistancia < distanciasMinimas[destino]) {
                        distanciasMinimas[destino] = nuevaDistancia;
                        predecesores[destino] = actual;}}
                vecino = vecino.siguiente;}
        }
        System.out.println("Criterio seleccionado: " + criterio);
        System.out.println("Centro de origen: " + centros[origen].getCiudad());
        for (int i = 0; i < cantidadCentros; i++) {
            System.out.print("Destino: " + centros[i].getCiudad());
            if (distanciasMinimas[i] == Double.POSITIVE_INFINITY) {
                System.out.println(" | No existe camino");} else {
                System.out.println(" | Valor mínimo según el criterio: " + distanciasMinimas[i]);
                System.out.print("Camino: ");
                mostrarCamino(i, predecesores);}}
    }
    private void mostrarCamino(int actual, int[] predecesores) {
        if (predecesores[actual] != -1) {
            mostrarCamino(predecesores[actual], predecesores);
            System.out.print(" -> ");}
        System.out.print(centros[actual].getCiudad());}
}
