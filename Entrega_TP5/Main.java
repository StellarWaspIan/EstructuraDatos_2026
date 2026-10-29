import java.util.*;
public class Main {
    static Scanner sc = new Scanner(System.in);
    static MatrizAdyacencia m;
    static ListaAdyacencia l;
    public static void main(String[] args) {
        int op=0;
        do{
            System.out.println("- Menu -");
            System.out.println("1- Crear Grafo");
            System.out.println("2- Consultar Ruta mas Corta");
            System.out.println("3- Consultar Ruta mas Barata");
            System.out.println("4- Consultar Ruta mas Rapida");
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
                default:
                    System.out.println("Opcion Incorrecta..");
                    break;
            }
        }while(op!=0);
        sc.close();
    }
    public static void crearGrafo(){
        //crea el grafo no dirigido, la matriz y lista
    }
    public static void rutaCorta(){
        String id;
        System.out.println("Ingrese ID Origen: ");
        id=sc.nextLine();
        m.dijkstraMulticriterio(id, CriterioRuta.DISTANCIA);
        l.dijkstraMulticriterio(id, CriterioRuta.DISTANCIA);
    }
    public static void rutaBarata(){
        String id;
        System.out.println("Ingrese ID Origen: ");
        id=sc.nextLine();
        m.dijkstraMulticriterio(id, CriterioRuta.COSTO_MONETARIO);
        l.dijkstraMulticriterio(id, CriterioRuta.COSTO_MONETARIO);
    }
    public static void rutaRapida(){
        String id;
        System.out.println("Ingrese ID Origen: ");
        id=sc.nextLine();
        m.dijkstraMulticriterio(id, CriterioRuta.TIEMPO);
        l.dijkstraMulticriterio(id, CriterioRuta.TIEMPO);
    }
}
