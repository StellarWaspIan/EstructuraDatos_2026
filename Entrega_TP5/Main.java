import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op=0;
        do{
            System.out.println("- Menu -");
            System.out.println("1- Crear Grafo");
            System.out.println("2- Consultar Ruta mas Corta");
            System.out.println("3- Consultar Ruta mas Barata");
            System.out.println("4- Consultar Ruta mas Rapida");
            op = sc.nextInt();
            sc.nextLine();
        }while(op!=0);
    }
}
