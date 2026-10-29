import java.util.*;
public class Main {
    static Scanner sc = new Scanner(System.in);
    static MatrizAdyacencia m; static ListaAdyacencia l;
    public static void main(String[] args) {
        int op;
        do {
            System.out.println("--- MENU ---");
            System.out.println("1 - Crear Grafo");
            System.out.println("2 - Consultar Ruta mas Corta");
            System.out.println("3 - Consultar Ruta mas Barata");
            System.out.println("4 - Consultar Ruta mas Rapida");
            System.out.println("0 - Salir");
            System.out.print("Seleccione una opcion: ");
            op = sc.nextInt();
            sc.nextLine();
            switch (op) {
                case 1:
                    crearGrafo();
                    break;
                case 2:
                    rutaCorta();
                    break;
                case 3:
                    rutaBarata();
                    break;
                case 4:
                    rutaRapida();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
                    break;
            }
        } while (op != 0);
        sc.close();
    }
    public static void crearGrafo() {
        m = new MatrizAdyacencia(5);
        l = new ListaAdyacencia(5);
        CentroLogistico caba = new CentroLogistico("CABA", "Buenos Aires", false);
        CentroLogistico ros = new CentroLogistico("ROS", "Rosario", false);
        CentroLogistico cor = new CentroLogistico("COR", "Cordoba", false);
        CentroLogistico mdz = new CentroLogistico("MDZ", "Mendoza", false);
        CentroLogistico bar = new CentroLogistico("BAR", "Bariloche", false);
        m.agregarCentro(caba);
        m.agregarCentro(ros);
        m.agregarCentro(cor);
        m.agregarCentro(mdz);
        m.agregarCentro(bar);
        l.agregarCentro(caba);
        l.agregarCentro(ros);
        l.agregarCentro(cor);
        l.agregarCentro(mdz);
        l.agregarCentro(bar);
        m.agregarRuta("CABA", "ROS", new RutaTransporte(300, 210, 80));
        l.agregarRuta("CABA", "ROS", new RutaTransporte(300, 210, 80));
        m.agregarRuta("ROS", "COR", new RutaTransporte(400, 270, 110));
        l.agregarRuta("ROS", "COR", new RutaTransporte(400, 270, 110));
        m.agregarRuta("CABA", "COR", new RutaTransporte(700, 450, 190));
        l.agregarRuta("CABA", "COR", new RutaTransporte(700, 450, 190));
        m.agregarRuta("COR", "MDZ", new RutaTransporte(600, 420, 160));
        l.agregarRuta("COR", "MDZ", new RutaTransporte(600, 420, 160));
        m.agregarRuta("CABA", "BAR", new RutaTransporte(1550, 1100, 450));
        l.agregarRuta("CABA", "BAR", new RutaTransporte(1550, 1100, 450));
        m.agregarRuta("MDZ", "BAR", new RutaTransporte(1200, 850, 340));
        l.agregarRuta("MDZ", "BAR", new RutaTransporte(1200, 850, 340));
    }
    public static void rutaCorta() {
        if (!grafoCreado()) {return;}
        System.out.print("Ingrese ID del centro de origen: ");
        String id = sc.nextLine();
        System.out.println("--- MATRIZ DE ADYACENCIA ---");
        m.dijkstraMulticriterio(id, CriterioRuta.DISTANCIA);
        System.out.println("--- LISTA DE ADYACENCIA ---");
        l.dijkstraMulticriterio(id, CriterioRuta.DISTANCIA);
    }
    public static void rutaBarata() {
        if (!grafoCreado()) {return;}
        System.out.print("Ingrese ID del centro de origen: ");
        String id = sc.nextLine();
        System.out.println("--- MATRIZ DE ADYACENCIA ---");
        m.dijkstraMulticriterio(id, CriterioRuta.COSTO_MONETARIO);
        System.out.println("--- LISTA DE ADYACENCIA ---");
        l.dijkstraMulticriterio(id, CriterioRuta.COSTO_MONETARIO);
    }
    public static void rutaRapida() {
        if (!grafoCreado()) {return;}
        System.out.print("Ingrese ID del centro de origen: ");
        String id = sc.nextLine();
        System.out.println("--- MATRIZ DE ADYACENCIA ---");
        m.dijkstraMulticriterio(id, CriterioRuta.TIEMPO);
        System.out.println("--- LISTA DE ADYACENCIA ---");
        l.dijkstraMulticriterio(id, CriterioRuta.TIEMPO);
    }
    public static boolean grafoCreado() {
        if (m == null || l == null) {
            System.out.println("Primero debe crear el grafo.");
            return false;
        } return true;}
}