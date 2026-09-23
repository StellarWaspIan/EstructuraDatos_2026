package Entrega_TP2.Ejercicio2;

public class Pasajero {
    int legajo, prioridad;
    String nombre;
    double promedio;
    public Pasajero(int legajo, int prioridad, String nombre, double promedio) {
        this.legajo = legajo;
        this.prioridad = prioridad;
        this.nombre = nombre;
        this.promedio = promedio;
    }
    public int getLegajo() {
        return legajo;
    }
    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }
    public int getPrioridad() {
        return prioridad;
    }
    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPromedio() {
        return promedio;
    }
    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
     
    public void mostrar(){
        System.out.println("Pasajero - "+legajo+"| Nombre: "+nombre+", Prioridad: "+prioridad+", Promedio: "+promedio);
    }
}
