package TP_2_Ordenamiento.Ejercicio_10;

public class Tiempo{
    int hora, minuto, segundo;
    public Tiempo(int hora, int minuto, int segundo){
        this.hora=hora;
        this.minuto=minuto;
        this.segundo=segundo;
    }
    public int getHora() {
        return hora;
    }
    public void setHora(int hora) {
        this.hora = hora;
    }
    public int getMinuto() {
        return minuto;
    }
    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }
    public int getSegundo() {
        return segundo;
    }
    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    /* 
    public int conversionSeg(){
        //Pasando todo a seg nos ahorramos comparar todo por separado
        return hora * 3600 + minuto * 60 + segundo;
    }
    */
    
}