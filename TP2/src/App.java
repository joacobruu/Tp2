import java.util.Scanner;

import scanner.Menu;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();

        int opcion;
        do {
            opcion = menu.MenuPrincipal();
            menu.limpiarBuffer();

            switch (opcion) {
                case 1:
                    menu.MenuEmpleados();
                    break;
                case 2:
                    menu.MenuClientes();
                    break;
                case 3:
                    menu.MenuPedidos();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (opcion !=4);
    }
}
