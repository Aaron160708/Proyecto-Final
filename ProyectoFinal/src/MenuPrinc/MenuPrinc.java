
package MenuPrinc;

import Inven.MenuInven.MenuInven;
import Util.Leer;
import java.util.Scanner;

public class MenuPrinc {
    //System.out.println("");
    public void MenuPrinc() {
    Scanner sc = Leer.getScanner();
    int opc;
    MenuInven mi = new MenuInven();

    do {
        System.out.println("------MENU PRINCIPAL------");
        System.out.println("1. Acceder al Sistema de Ventas");
        System.out.println("2. Acceder al Inventario");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opcion: ");
        
        while (!sc.hasNextInt()) {
            System.out.print("Opcion invalida");
            sc.next();
        }
        opc = sc.nextInt();
        sc.nextLine();

        switch (opc) {
            case 1:
                System.out.println("noay");
                break;
            case 2:
                mi.mi();
                break;
            case 3:
                System.out.println("Saliendo del sistema.");
                break;
            default:
                System.out.println("Opcion invalida");
        }
    } while (opc != 3);
}

}
