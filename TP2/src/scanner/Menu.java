package scanner;

import java.util.ArrayList;
import java.util.Scanner;

import Gestor.Gestor;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Pedido;
import modelo.Producto;

public class Menu {
  private Scanner scanner;
  private Gestor gestor = new Gestor();

  public Menu() {
    this.scanner = new Scanner(System.in);
  }

  public void MenuPrincipal() {
    System.out.println("\n---- Menu ----");
    System.out.println("1) Empleados");
    System.out.println("2) Clientes");
    System.out.println("3) Pedidos");
    System.out.println("4) Productos");
    System.out.println("5) Salir");
  }

  public void MenuEmpleados() {
    limpiarBuffer();
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
    limpiarBuffer();
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
    limpiarBuffer();
    int opcion;

    System.out.println("\n---- Pedidos ----");
    System.out.println("1) Mostrar pedidos");
    System.out.println("2) Agregar pedido");
    System.out.println("3) Marcar pedido como realizado");
    System.out.println("4) Eliminar pedido");
    System.out.println("5) Atras");

    opcion = scanner.nextInt();
    switch (opcion) {
      case 1:
        gestor.getListaPedidos();
        break;
      case 2:
        subMenuPedidos();
        break;
      case 3:
        gestor.getListaPedidos();
        System.out.println("Seleccione el pedido: ");
        int i = scanner.nextInt();
        gestor.pedidoRealizado(gestor.getPedido(i).getId());
        break;
      case 4:
        gestor.getListaPedidos();
        System.out.println("Seleccione el pedido a eliminar: ");
        int j = scanner.nextInt();
        gestor.eliminarPedido(gestor.getPedido(j).getId());
        break;
      case 5:
        MenuPrincipal();
        break;
      default:
        System.out.println("Opcion invalida.");
        break;
    }

    return scanner.nextInt();
  }

  public int subMenuPedidos() {
    limpiarBuffer();
    int opcion;
    ArrayList<Producto> productos = new ArrayList<Producto>();

    System.out.println("\n---- Agregar Pedido ----");
    System.out.println("1) Agregar producto");
    System.out.println("2) Quitar producto");
    System.out.println("3) Finalizar pedido");
    System.out.println("4) Atras");

    opcion = scanner.nextInt();
    switch (opcion) {
      case 1:
        gestor.getListaProductos();
        System.out.println("Seleccione el producto: ");
        int i = scanner.nextInt();
        productos.add(gestor.getProducto(i));
        System.out.println("Producto agregado");
        break;
      case 2:
        int j = 0;

        for (Producto producto : productos) {
           j++;

          System.out.println(j + ")" + "\n" +
          "Nombre: " + producto.getNombre() + "\n" +
          "Precio: " + producto.getPrecio() + "\n");
        };
        System.out.println("Seleccione producto a quitar: ");
        int k = scanner.nextInt();
        productos.remove(k-1);
        System.out.println("Producto eliminado");
        break;
      case 3:
        Cliente clientePedido;
        gestor.getListaClientes();
        System.out.println("Seleccione el cliente: ");
        clientePedido = gestor.getCliente(scanner.nextInt());
        Pedido nuevoPedido = new Pedido(productos, clientePedido);
        gestor.agregarPedido(nuevoPedido, clientePedido);
        System.out.println("Nuevo pedido agregado.");
      case 4:
        MenuPrincipal();
        break;
      default:
        System.out.println("Opcion invalida.");
        break;
    }
    return scanner.nextInt();
  }

  public int MenuProductos() {
    limpiarBuffer();
    int opcion;

    System.out.println("\n---- Productos ----");
    System.out.println("1) Mostrar productos");
    System.out.println("2) Agregar producto nuevo");
    System.out.println("3) Eliminar producto");
    System.out.println("4) Atras");

    opcion = scanner.nextInt();
    switch (opcion) {
      case 1:
        gestor.getListaProductos();
        break;
      case 2:
        String nombre;
        int precio;

        System.out.println("\nIngrese el nombre del producto: ");
        nombre = scanner.nextLine();
        System.out.println("\nIngrese el precio del producto: ");
        precio = scanner.nextInt();

        Producto nuevoProducto = new Producto(precio, nombre);

        gestor.agregarProducto(nuevoProducto);
        break;
      case 3:
        gestor.getListaProductos();
        System.out.println("Seleccione el producto a eliminar: ");
        int j = scanner.nextInt();
        gestor.eliminarProducto(j);
      break;
      default:
        break;
    }

    return scanner.nextInt();
  }

  public void limpiarBuffer() {
    scanner.nextLine();
  }
}
