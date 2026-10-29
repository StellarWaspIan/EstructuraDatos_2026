
public class MatrizAdyacencia {
    CentroLogistico[] centros;
    double[][] distancias;
    double[][] tiempos;
    double[][] costos;
    int cantidadCentros;
    public MatrizAdyacencia(int capacidad) {
        centros = new CentroLogistico[capacidad];
        distancias = new double[capacidad][capacidad];
        tiempos = new double[capacidad][capacidad];
        costos = new double[capacidad][capacidad];
        cantidadCentros = 0;
        for (int fila = 0; fila < capacidad; fila++) {
            for (int columna = 0; columna < capacidad; columna++) {
                distancias[fila][columna] = Double.POSITIVE_INFINITY;
                tiempos[fila][columna] = Double.POSITIVE_INFINITY;
                costos[fila][columna] = Double.POSITIVE_INFINITY;}}
    }
    public void agregarCentro(CentroLogistico centro) {
        centros[cantidadCentros] = centro;
        cantidadCentros++;
    }
    private int buscarId(String id) {
        for (int i = 0; i < cantidadCentros; i++) {
            if (centros[i].getId().equals(id)) {
                return i;}}
        return -1;
    }
    public void agregarRuta(String origenId, String destinoId, RutaTransporte ruta) {
        int origen = buscarId(origenId);
        int destino = buscarId(destinoId);
        distancias[origen][destino] = ruta.getDistanciaKm();
        distancias[destino][origen] = ruta.getDistanciaKm();
        tiempos[origen][destino] = ruta.getTiempoMinutos();
        tiempos[destino][origen] = ruta.getTiempoMinutos();
        costos[origen][destino] = ruta.getCostoMonetarioUSD();
        costos[destino][origen] = ruta.getCostoMonetarioUSD();
    }
    private double[][] obtenerMatriz(CriterioRuta criterio) {
        switch (criterio) {
            case DISTANCIA: return distancias;
            case TIEMPO: return tiempos;
            case COSTO_MONETARIO: return costos;
            default: return null;
        }
    }

    public void dijkstraMulticriterio(String origenId, CriterioRuta criterio) {
        int origen = buscarId(origenId);
        double[][] matrizPesos = obtenerMatriz(criterio);
        double[] distanciasMinimas = new double[cantidadCentros];
        int[] predecesores = new int[cantidadCentros];
        boolean[] visitados = new boolean[cantidadCentros];
        for (int i = 0; i < cantidadCentros; i++) {
            distanciasMinimas[i] = Double.POSITIVE_INFINITY;
            predecesores[i] = -1;
            visitados[i] = false;
        }
        distanciasMinimas[origen] = 0;
        for (int i = 0; i < cantidadCentros; i++) {
            int actual = -1;
            double menorDistancia = Double.POSITIVE_INFINITY;
            for (int j = 0; j < cantidadCentros; j++) {
                if (!visitados[j] && distanciasMinimas[j] < menorDistancia) {
                    menorDistancia = distanciasMinimas[j];
                    actual = j;}
            } if (actual == -1) {
                break;}
            visitados[actual] = true;
            for (int vecino = 0; vecino < cantidadCentros; vecino++) {
                if (!visitados[vecino] && matrizPesos[actual][vecino] != Double.POSITIVE_INFINITY) {
                    double nuevaDistancia = distanciasMinimas[actual] + matrizPesos[actual][vecino];
                    if (nuevaDistancia < distanciasMinimas[vecino]) {
                        distanciasMinimas[vecino] = nuevaDistancia;
                        predecesores[vecino] = actual;}}}}
        System.out.println("Criterio seleccionado: " + criterio);
        System.out.println("Centro de origen: " + centros[origen].getCiudad());
        for (int i = 0; i < cantidadCentros; i++) {
            System.out.print("Destino: " + centros[i].getCiudad());
            if (distanciasMinimas[i] == Double.POSITIVE_INFINITY) {
                System.out.println(" | No existe camino");} 
                else {
                System.out.println(" | Costo mínimo: " + distanciasMinimas[i]);
                System.out.print("Camino: ");
                mostrarCamino(i, predecesores);}}
    }
    private void mostrarCamino(int actual, int[] predecesores) {
        if (predecesores[actual] != -1) {
            mostrarCamino(predecesores[actual], predecesores);
            System.out.print(" -> ");
        } System.out.print(centros[actual].getCiudad());}
}
