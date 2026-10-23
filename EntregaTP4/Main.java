package EntregaTP4;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int op;
        do {
            System.out.println("===== SISTEMA DE GESTION PORTUARIA =====");
            System.out.println("1- Simulacion automatizada por lote");
            System.out.println("2- Menu manual");
            System.out.println("0- Salir");
            System.out.print("Seleccione una opcion: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    simulacionAutomatizada();
                    break;
                case 2:
                    menuManual();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
                    break;
            }

        } while (op != 0);

        sc.close();
    }

    public static void simulacionAutomatizada() {

        ArbolAVL arbol = new ArbolAVL();

        // Carga de los ocho contenedores
        arbol.insertar(new Contenedor(500, "Maquinaria Industrial", 12.5, "Alemania"));

        arbol.insertar(new Contenedor(200, "Insumos Medicos", 4.2, "Brasil"));

        arbol.insertar(new Contenedor(100, "Componentes Electronicos", 8.0, "China"));

        arbol.insertar(new Contenedor(800, "Productos Textiles", 6.5, "India"));

        arbol.insertar(new Contenedor(900, "Calzado Deportivo", 5.1, "Brasil"));

        arbol.insertar(new Contenedor(700, "Alimentos Refrigerados", 11.0, "Argentina"));

        arbol.insertar(new Contenedor(150, "Herramientas de Precision", 3.8, "Japon"));

        arbol.insertar(new Contenedor(950, "Equipos Telecomunicacion", 14.0, "EEUU"));

        System.out.println("--- Arbol inicial ---");
        arbol.inorden();

        System.out.println("--- ETAPA A ---");
        arbol.eliminarPorPais("Brasil");
        System.out.println("Arbol resultante:");
        arbol.inorden();

        System.out.println("--- ETAPA B ---");
        System.out.println("Eliminar 100");
        arbol.eliminar(100);
        System.out.println("Arbol resultante:");        
        arbol.inorden();

        System.out.println("Eliminar 150");
        arbol.eliminar(150);
        System.out.println("Arbol resultante:");        
        arbol.inorden();

        System.out.println("Eliminar 800");
        arbol.eliminar(800);
        System.out.println("Arbol resultante:");
        arbol.inorden();
    }

    public static void menuManual() {
        ArbolAVL arbol = new ArbolAVL();
        int op;
        do {
            System.out.println("===== MENU INTERACTIVO =====");
            System.out.println("1- Ingresar contenedor");
            System.out.println("2- Mostrar contenedores por SKU");
            System.out.println("3- Eliminar por SKU");
            System.out.println("4- Eliminar por pais de origen");
            System.out.println("5- Eliminar por peso");
            System.out.println("0- Volver");
            System.out.print("Seleccione una opcion: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    ingresarContenedor(arbol);
                    break;
                case 2:
                    System.out.println("Contendores ordenador por SKU: ");
                    arbol.inorden();
                    break;
                case 3:
                    System.out.print("Ingrese el SKU a eliminar: ");
                    int codigoSKU = sc.nextInt();
                    sc.nextLine();
                    arbol.eliminar(codigoSKU);
                    break;
                case 4:
                    System.out.print("Ingrese el pais de origen: ");
                    String pais = sc.nextLine();
                    arbol.eliminarPorPais(pais);
                    break;
                case 5:
                    System.out.print("Ingrese el peso limite: ");
                    double pesoLimite = sc.nextDouble();
                    sc.nextLine();
                    arbol.eliminarSuperanPeso(pesoLimite);
                    break;
                case 0:
                    System.out.println("Volviendo al menu principal...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
                    break;
            }
        } while (op != 0);
    }

    public static void ingresarContenedor(ArbolAVL arbol) {
        System.out.println("--- INGRESO DE CONTENEDOR ---");
        System.out.print("Codigo SKU: ");
        int codigoSKU = sc.nextInt();
        sc.nextLine();
        System.out.print("Descripcion: ");
        String descripcion = sc.nextLine();
        System.out.print("Peso en toneladas: ");
        double pesoToneladas = sc.nextDouble();
        sc.nextLine();
        System.out.print("Pais de origen: ");
        String paisOrigen = sc.nextLine();
        Contenedor c = new Contenedor(codigoSKU, descripcion, pesoToneladas, paisOrigen);
        arbol.insertar(c);
        System.out.println("Contenedor ingresado correctamente.");
    }
}
