package scanner;

import java.util.Scanner;

import Gestor.Gestor;
import modelo.Empleado;

public class Menu {
  private Scanner scanner;
  private Gestor gestor = new Gestor();

  public Menu() {
    this.scanner = new Scanner(System.in);
  }

  public int MenuPrincipal() {
    System.out.println("\n---- Menu ----");
    System.out.println("1) Empleados");
    System.out.println("2) Clientes");
    System.out.println("3) Pedidos");
    System.out.println("4) Salir");

    return scanner.nextInt();
  }

  public void MenuEmpleados() {
    int opcion;

    System.out.println("\n---- Empleados ----");
    System.out.println("1) Mostrar empleados");
    System.out.println("2) Agregar empleado");
    System.out.println("3) Borrar empleado");
    System.out.println("4) Atras");

    opcion = scanner.nextInt();
    switch (opcion) {
      case 1:
        gestor.getListaEmpleados();
        break;
      case 2:
        String nombre;
        String direccion;
        int contacto;
        int salario;

        System.out.println("\nIngrese el nombre: ");
        nombre = scanner.nextLine();
        System.out.println("\nIngrese la direccion: ");
        direccion = scanner.nextLine();
        System.out.println("\nIngrese un telefono de contacto: ");
        contacto = scanner.nextInt();
        System.out.println("\nIngrese el salario: ");
        salario = scanner.nextInt();

        Empleado nuevoEmpleado = new Empleado(nombre, direccion, contacto, salario);

        gestor.agregarEmpleado(nuevoEmpleado);
      default:
        break;
    }
  }

  public void MenuClientes() {
    int opcion;

    System.out.println("\n---- Clientes ----");
    System.out.println("1) Mostrar clientes");
    System.out.println("2) Agregar cliente");
    System.out.println("3) Borrar cliente");
    System.out.println("4) Atras");

    opcion = scanner.nextInt();
    switch (opcion) {
      case 1:
        
        break;
    
      default:
        break;
    }
  }

  public int MenuPedidos() {
    System.out.println("\n---- Pedidos ----");
    System.out.println("1) Mostrar pedidos");
    System.out.println("2) Agregar pedido");
    System.out.println("3) Marcar pedido como realizado");
    System.out.println("4) Eliminar pedido");
    System.out.println("5) Atras");

    return scanner.nextInt();
  }

  public void limpiarBuffer() {
    scanner.nextLine();
  }
}
