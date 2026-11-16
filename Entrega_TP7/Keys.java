package Entrega_TP7;


public class Keys {
    String[] claves;
    int cantidad;
    int capacidad;

    public Keys(int capacidad) {
        this.capacidad = capacidad;
        this.cantidad = 0;
        claves = new String[capacidad];
    }

    // Devuelve la clave ubicada en una posicion.
    public String obtenerClave(int posicion) {
        if (posicion < 0 || posicion >= cantidad) {
            return null;
        }
        return claves[posicion];
    }

    // Busca una clave.
    // Si la encuentra, devuelve -1.
    // Si no la encuentra, devuelve la posicion donde deberia insertarse.
    public int buscar(String clave) {
        for (int i = 0; i < cantidad; i++) {
            int comparacion = clave.compareTo(claves[i]);
            if (comparacion == 0) {
                return -1;
            }
            if (comparacion < 0) {
                return i;
            }
        }
        return cantidad;
    }

    // Inserta una clave manteniendo el orden.
    // Devuelve la posicion donde fue insertada.
    // Si ya existe, devuelve -1.
    public int insertar(String clave) {
        int posicion = buscar(clave);
        if (posicion == -1) {
            return -1;
        }
        for (int i = cantidad; i > posicion; i--) {
            claves[i] = claves[i - 1];
        }
        claves[posicion] = clave;
        cantidad++;
        return posicion;
    }

    // Elimina una clave determinada.
    public boolean eliminar(String clave) {
        int posicion = buscar(clave);
        if (posicion != -1) {
            return false;
        }
        // Buscar la posicion real de la clave.
        posicion = 0;
        while (!claves[posicion].equals(clave)) {
            posicion++;
        }
        // Desplazar las claves hacia la izquierda.
        for (int i = posicion; i < cantidad - 1; i++) {
            claves[i] = claves[i + 1];
        }
        cantidad--;
        claves[cantidad] = null;
        return true;
    }

    // Elimina una clave utilizando su posicion.
    public String eliminarEn(int posicion) {
        if (posicion < 0 || posicion >= cantidad) {
            return null;
        }
        String claveEliminada = claves[posicion];
        for (int i = posicion; i < cantidad - 1; i++) {
            claves[i] = claves[i + 1];
        }
        cantidad--;
        claves[cantidad] = null;
        return claveEliminada;
    }

    // Modifica una clave en una posicion determinada.
    public void establecerClave(int posicion, String clave) {
        claves[posicion] = clave;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getCapacidad() {
        return capacidad;
    }
}
