
package Inven.MenuInven;

import Inven.CRUD.Crud;
import Util.Leer;
import java.util.Scanner;

public class MenuInven {
    public void mi() {
    Crud cr = new Crud();
    Scanner sc = Leer.getScanner();
    int opc;

    do {
        System.out.println("------MENU DE INVENTARIO------");
        System.out.println("1. Modificar Proveedores");
        System.out.println("2. Modificar Productos");
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
                cr.CRUDprov();
                break;
            case 2:
                cr.CRUDprod();
                break;
            case 3:
                System.out.println("Regresando al Menu Principal.");
                break;
            default:
                System.out.println("Opcion invalida");
        }
    } while (opc != 3);
}

}
