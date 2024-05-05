package scanner;

import java.util.Scanner;

import Gestor.Gestor;
import modelo.Cliente;
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
    System.out.println("4) Productos");
    System.out.println("5) Salir");

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
        break;
      case 3:
        gestor.getListaEmpleados();
        System.out.println("Seleccione el empleado a eliminar: ");
        int i  = scanner.nextInt();
        gestor.eliminarEmpleado(gestor.getEmpleado(i).getId());
        break;
      case 4:
        MenuPrincipal();
        break;
      default:
      System.out.println("Opcion invalida.");
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
        gestor.getListaClientes();
        break;
      case 2:
        String nombre;
        String direccion;
        int contacto;

        System.out.println("\nIngrese el nombre: ");
        nombre = scanner.nextLine();
        System.out.println("\nIngrese la direccion: ");
        direccion = scanner.nextLine();
        System.out.println("\nIngrese un telefono de contacto: ");
        contacto = scanner.nextInt();

        Cliente nuevoCliente = new Cliente(nombre, direccion, contacto);

        gestor.agregarCliente(nuevoCliente);
        break;
      case 3:
        gestor.getListaClientes();
        System.out.println("Seleccione el cliente a eliminar: ");
        int i  = scanner.nextInt();
        gestor.eliminarCliente(gestor.getCliente(i).getId());
        break;
      case 4:
        MenuPrincipal();
        break;
      default:
        System.out.println("Opcion invalida.");
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

  public int MenuProductos() {
    System.out.println("\n---- Productos ----");
    System.out.println("1) Mostrar productos");
    System.out.println("2) Agregar producto nuevo");
    System.out.println("3) Eliminar producto");
    System.out.println("4) Atras");

    return scanner.nextInt();
  }

  public void limpiarBuffer() {
    scanner.nextLine();
  }
}
