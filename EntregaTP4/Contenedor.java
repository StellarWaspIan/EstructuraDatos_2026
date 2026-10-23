package EntregaTP4;

public class Contenedor {
    int codigoSKU;
    String descripcion;
    double pesoToneladas;
    String paisOrigen;

    public Contenedor(int codigoSKU, String descripcion, double pesoToneladas, String paisOrigen) {
        this.codigoSKU = codigoSKU;
        this.descripcion = descripcion;
        this.pesoToneladas = pesoToneladas;
        this.paisOrigen = paisOrigen;
    }

    public int getCodigoSKU() {
        return codigoSKU;
    }

    public void setCodigoSKU(int codigoSKU) {
        this.codigoSKU = codigoSKU;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPesoToneladas() {
        return pesoToneladas;
    }

    public void setPesoToneladas(double pesoToneladas) {
        this.pesoToneladas = pesoToneladas;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    @Override
    public String toString() {
        return ("SKU: " +codigoSKU+", Descripcion: "+descripcion+", Peso: "+pesoToneladas+" t, Pais de origen: "+paisOrigen);
    }
}


