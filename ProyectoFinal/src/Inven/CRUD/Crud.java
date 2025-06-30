package Inven.CRUD;

import MenuPrinc.MenuPrinc;
import Prod.Prod;
import Prov.Prov;
import Util.Leer;
import java.util.Scanner;

public class Crud {

    MenuPrinc mp = new MenuPrinc();
    Prov prov = new Prov();
    Prod prod = new Prod();
    Scanner sc = Leer.getScanner();

    public void CRUDprod() {
        int opc;
        do {
            System.out.println("------Menu de Productos------");
            System.out.println("1. Dar de Alta un Producto");
            System.out.println("2. Dar de Baja un Producto");
            System.out.println("3. Modificar un Producto");
            System.out.println("4. Mostrar los Productos");
            System.out.println("--------------------------");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            while (!sc.hasNextInt()) {
                System.out.print("Opcion invalida");
                sc.next();
            }
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    prod.AltaProd();
                    break;
                case 2:
                    prod.BajaProd();
                    break;
                case 3:
                    prod.ModProd();
                    break;
                case 4:
                    prod.LeerProd();
                    break;
                case 5:
                    System.out.println("Regresando.");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (opc != 5);
    }

    public void CRUDprov() {
        int opc;
        do {
            System.out.println("------Menu de Proveedores------");
            System.out.println("1. Dar de Alta un Proveedor");
            System.out.println("2. Dar de Baja un Proveedor");
            System.out.println("3. Modificar un Proveedor");
            System.out.println("4. Mostrar los Proveedores");
            System.out.println("--------------------------");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            while (!sc.hasNextInt()) {
                System.out.print("Opcion invalida");
                sc.next();
            }
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    prov.AltaProv();
                    break;
                case 2:
                    prov.BajaProv();
                    break;
                case 3:
                    prov.ModProv();
                    break;
                case 4:
                    prov.LeerProv();
                    break;
                case 5:
                    System.out.println("Regresando.");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (opc != 5);
    }
}
