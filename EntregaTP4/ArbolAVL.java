package EntregaTP4;
import java.util.*;

public class ArbolAVL {
    NodoAVL raiz;
    
    public ArbolAVL() {
        raiz = null;
    }

    // METODOS AUXILIARES
    private int altura(NodoAVL nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.getAltura();
    }

    private int factorEquilibrio(NodoAVL nodo) {
        if (nodo == null) {
            return 0;
        }
        return altura(nodo.getDerecho())- altura(nodo.getIzquierdo());
    }

    private void actualizarAltura(NodoAVL nodo) {
        int alturaIzquierda = altura(nodo.getIzquierdo());
        int alturaDerecha = altura(nodo.getDerecho());
        nodo.setAltura(1 + Math.max(alturaIzquierda, alturaDerecha));
    }

    // ROTACIONES
    
    // RSI
    private NodoAVL rotarIzquierda(NodoAVL nodo) {
        NodoAVL nuevoPadre = nodo.getDerecho();
        NodoAVL subarbol = nuevoPadre.getIzquierdo();

        nuevoPadre.setIzquierdo(nodo);
        nodo.setDerecho(subarbol);

        actualizarAltura(nodo);
        actualizarAltura(nuevoPadre);

        return nuevoPadre;
    }

    // RSD
    private NodoAVL rotarDerecha(NodoAVL nodo) {
        NodoAVL nuevoPadre = nodo.getIzquierdo();
        NodoAVL subarbol = nuevoPadre.getDerecho();
        nuevoPadre.setDerecho(nodo);
        nodo.setIzquierdo(subarbol);
        actualizarAltura(nodo);
        actualizarAltura(nuevoPadre);
        return nuevoPadre;
    }

    private NodoAVL rebalancear(NodoAVL nodo) {
        if (nodo == null) {
            return null;
        }
        actualizarAltura(nodo);
        int fe = factorEquilibrio(nodo);
        // Desequilibrio hacia la derecha
        if (fe > 1) {
            // Caso derecha-izquierda (RL)
            if (factorEquilibrio(nodo.getDerecho()) < 0) {
                nodo.setDerecho(rotarDerecha(nodo.getDerecho()));
            }
            // Caso derecha-derecha (RR)
            return rotarIzquierda(nodo);
        }

        // Desequilibrio hacia la izquierda
        if (fe < -1) {
            // Caso izquierda-derecha (LR)
            if (factorEquilibrio(nodo.getIzquierdo()) > 0) {
                nodo.setIzquierdo(
                    rotarIzquierda(nodo.getIzquierdo())
                );
            }
            // Caso izquierda-izquierda (LL)
            return rotarDerecha(nodo);
        }
        return nodo;
    }

    public void insertar(Contenedor c) {
        if (c == null) {
            return;
        }
        raiz = insertar(raiz, c);
    }

    private NodoAVL insertar(NodoAVL nodo, Contenedor c) {
        if (nodo == null) {
            return new NodoAVL(c);
        }
        int codigo = c.getCodigoSKU();
        int codigoActual = nodo.getCarga().getCodigoSKU();

        if (codigo < codigoActual) {
            nodo.setIzquierdo(insertar(nodo.getIzquierdo(), c));
        } else if (codigo > codigoActual) {
            nodo.setDerecho(insertar(nodo.getDerecho(), c));
        } else {
            nodo.setCarga(c);
            return nodo;
        }
        return rebalancear(nodo);
    }

    // ELIMINAR POR SKU
    public void eliminar(int codigoSKU) {
        raiz = eliminar(raiz, codigoSKU);
    }

    private NodoAVL eliminar(NodoAVL nodo, int codigoSKU) {
        if (nodo == null) {
            return null;
        }
        int codigoActual = nodo.getCarga().getCodigoSKU();

        if (codigoSKU < codigoActual) {
            nodo.setIzquierdo(eliminar(nodo.getIzquierdo(), codigoSKU));
        } else if (codigoSKU > codigoActual) {
            nodo.setDerecho(eliminar(nodo.getDerecho(), codigoSKU));
        } else {
            // Caso 1: nodo hoja
            if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                return null;
            }
            // Caso 2: solo hijo
            if (nodo.getIzquierdo() == null) {
                return nodo.getDerecho();
            }

            if (nodo.getDerecho() == null) {
                return nodo.getIzquierdo();
            }

            // Caso 3: el nodo tiene dos hijos, inorden menor derecho
            NodoAVL sucesor = nodo.getDerecho();

            while (sucesor.getIzquierdo() != null) {
                sucesor = sucesor.getIzquierdo();
            }
            nodo.setCarga(sucesor.getCarga());
            nodo.setDerecho(eliminar(nodo.getDerecho(),sucesor.getCarga().getCodigoSKU()));
        }

        return rebalancear(nodo);
    }

    public void eliminarPorPais(String paisOrigen) {
        List<Integer> codigos = new ArrayList<>();
        recolectarPorPais(raiz, paisOrigen, codigos);
        for (int codigo : codigos) {
            eliminar(codigo);
        }
    }

    private void recolectarPorPais(NodoAVL nodo,String paisOrigen,List<Integer> codigos) {
        if (nodo == null) {
            return;
        }
        Contenedor c = nodo.getCarga();
        if (paisOrigen != null && paisOrigen.equals(c.getPaisOrigen())) {
            codigos.add(c.getCodigoSKU());
        }

        recolectarPorPais(nodo.getIzquierdo(), paisOrigen, codigos);

        recolectarPorPais(nodo.getDerecho(), paisOrigen, codigos);
    }

    public void eliminarSuperanPeso(double pesoLimite) {
        List<Integer> codigos = new ArrayList<>();
        recolectarPorPeso(raiz, pesoLimite, codigos);
        for (int codigo : codigos) {
            eliminar(codigo);
        }
    }

    private void recolectarPorPeso(NodoAVL nodo, double pesoLimite, List<Integer> codigos) {
        if (nodo == null) {
            return;
        }
        Contenedor c = nodo.getCarga();
        if (c.getPesoToneladas() > pesoLimite) {
            codigos.add(c.getCodigoSKU());
        }
        recolectarPorPeso(nodo.getIzquierdo(), pesoLimite, codigos);

        recolectarPorPeso(nodo.getDerecho(), pesoLimite, codigos);
    }

    public void inorden() {
        if (raiz == null) {
            System.out.println("El arbol esta vacio.");
            return;
        }
        inorden(raiz);
    }

    private void inorden(NodoAVL nodo) {
        if (nodo == null) {
            return;
        }
        inorden(nodo.getIzquierdo());
        System.out.println(nodo.getCarga());
        inorden(nodo.getDerecho());
    }
}

