package TP_2_Ordenamiento.Ejercicio_10;

public class Evento {
    String nombre;
    Tiempo tiempo;
    
    public Evento(String nombre, Tiempo tiempo){
        this.nombre=nombre;
        this.tiempo=tiempo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Tiempo getTiempo() {
        return tiempo;
    }
    public void setTiempo(Tiempo tiempo) {
        this.tiempo = tiempo;
    }

    public void mostrar(){
        System.out.println(nombre+", Hora:"+tiempo.hora+":"+tiempo.minuto+":"+tiempo.segundo);
    }
}
