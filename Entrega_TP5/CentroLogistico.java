
public class CentroLogistico {
    String id;
    String ciudad;
    boolean tienePuerto;
    public CentroLogistico(String id, String ciudad, boolean tienePuerto) {
        this.id = id;
        this.ciudad = ciudad;
        this.tienePuerto = tienePuerto;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public boolean isTienePuerto() {
        return tienePuerto;
    }
    public void setTienePuerto(boolean tienePuerto) {
        this.tienePuerto = tienePuerto;
    }
    @Override
    public String toString() {
        return "CentroLogistico - " +id+", Ciudad: " + ciudad +", Tiene Puerto?: " + tienePuerto;
    }
}

