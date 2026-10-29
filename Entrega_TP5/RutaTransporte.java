public class RutaTransporte {
    double distanciaKm;
    double tiempoMinutos;
    double costoMonetarioUSD;
    public RutaTransporte(double distanciaKm, double tiempoMinutos, double costoMonetarioUSD) {
        this.distanciaKm = distanciaKm;
        this.tiempoMinutos = tiempoMinutos;
        this.costoMonetarioUSD = costoMonetarioUSD;
    }
    public double getDistanciaKm() {
        return distanciaKm;
    }
    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }
    public double getTiempoMinutos() {
        return tiempoMinutos;
    }
    public void setTiempoMinutos(double tiempoMinutos) {
        this.tiempoMinutos = tiempoMinutos;
    }
    public double getCostoMonetarioUSD() {
        return costoMonetarioUSD;
    }
    public void setCostoMonetarioUSD(double costoMonetarioUSD) {
        this.costoMonetarioUSD = costoMonetarioUSD;
    }
    public double obtenerPeso(CriterioRuta criterio) {
        switch (criterio) {
            case DISTANCIA:
                return distanciaKm;
            case TIEMPO:
                return tiempoMinutos;
            case COSTO_MONETARIO:
                return costoMonetarioUSD;
            default:
                System.out.println("Criterio de ruta no válido");
                return -1;
        }
    }
    @Override
    public String toString() {
        return "RutaTransporte: " +"Distancia Km: " + distanciaKm + ", Tiempo Minutos: " + tiempoMinutos + ", Costo Monetario (USD): " + costoMonetarioUSD;
    }
}
