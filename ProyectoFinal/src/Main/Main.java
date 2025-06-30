package Main;

import Usuario.Usuario;
import Util.Leer;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String nombre;
        String contra;

        Usuario usuario = new Usuario();
        Scanner sc = Leer.getScanner();

        int opc;

        do {
            System.out.println("------MENU PRINCIPAL------");
            System.out.println("1. Iniciar Sesion");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");

            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    usuario.IniciarSesion();
                    break;
                case 2:
                    System.out.print("Dime el nombre de usuario: ");
                    nombre = sc.nextLine();
                    System.out.print("Dime la contrasena: ");
                    contra = sc.nextLine();
                    usuario.RUsuario(nombre, contra);
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (opc != 3);
    }
}
