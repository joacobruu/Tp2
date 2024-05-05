import Gestor.Gestor;
import modelo.Empleado;

public class App {
    public static void main(String[] args) throws Exception {

        Empleado joaquin = new Empleado("joaquin", "neyer", 1139007490, 1200000);
        Empleado laura = new Empleado("Laura", "pepepe", 1139007490, 1231300);

        Gestor gestor = new Gestor();

        gestor.agregarEmpleado(joaquin);
        gestor.agregarEmpleado(laura);

        gestor.getListaEmpleados();
        gestor.eliminarEmpleado(laura.getId());
        gestor.getListaEmpleados();

        /*
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
        } while (opcion !=4); */
    }
}
