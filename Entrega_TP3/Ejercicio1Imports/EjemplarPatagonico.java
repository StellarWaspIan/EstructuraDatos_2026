package Entrega_TP3.Ejercicio1Imports;

public class EjemplarPatagonico {
    int idchip;
    char codigozona;
    int idexpediente;
    public EjemplarPatagonico(int idchip, char codigozona, int idexpediente) {
        this.idchip = idchip;
        this.codigozona = codigozona;
        this.idexpediente = idexpediente;
    }
    public int getIdchip() {
        return idchip;
    }
    public void setIdchip(int idchip) {
        this.idchip = idchip;
    }
    public char getCodigozona() {
        return codigozona;
    }
    public void setCodigozona(char codigozona) {
        this.codigozona = codigozona;
    }
    public int getIdexpediente() {
        return idexpediente;
    }
    public void setIdexpediente(int idexpediente) {
        this.idexpediente = idexpediente;
    }
    @Override
    public String toString() {
        return "idchip= " + idchip + ", codigozona= " + codigozona + ", idexpediente= " + idexpediente;
    }
}
