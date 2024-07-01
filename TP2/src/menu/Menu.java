/* Clase Menu, esta clase se encarga del control del menu y la interaccion por teclado con el usuario */

package menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import Gestor.GestorCliente;
import Gestor.GestorEmpleado;
import Gestor.GestorPedido;
import Gestor.GestorProducto;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Producto;

public class Menu {
  private Scanner scanner = new Scanner(System.in); // Inicializo el Scanner para poder leer el input por teclado del
                                                    // usuario
  private GestorCliente gestorCliente = new GestorCliente();
  private GestorEmpleado gestorEmpleado = new GestorEmpleado();
  private GestorPedido gestorPedido = new GestorPedido();
  private GestorProducto gestorProducto = new GestorProducto();

  public Menu() {
    this.scanner = new Scanner(System.in);
  }

  // Menu principal
  public void MenuPrincipal() {
    int opcion = 0; // Inicializo la variable opcion para poder manejar las distintas secciones del
                    // menu a travez del scanner

    // DoWhile para mostrar el menu principal y sus distintas opciones
    do {
      // Muestro en consola las distintas opcines del menu
      System.out.println("\n---- Menu ----");
      System.out.println("1) Empleados");
      System.out.println("2) Clientes");
      System.out.println("3) Pedidos");
      System.out.println("4) Productos");
      System.out.println("5) Salir");
      System.out.println(" Eliga una opcion:");

      try {
        opcion = scanner.nextInt(); // Leo el input que realizo el usuario
      } catch (InputMismatchException e) {
        System.out.println("Debe ingresar un numero");
        System.out.println(e);
        break;
      }
      

      // Switch para las distintas opciones del menu acorde al input del usuario y
      // poder acceder a los distintos sub-menus y sus opciones
      switch (opcion) {
        case 1:
          limpiarBuffer(); // Metodo para limpiar el buffer del scanner y poder tomar el nuevo input del
                           // usuario
          MenuEmpleados(); // Metodo para mostrar el menu de Empleados
          break;
        case 2:
          limpiarBuffer();
          MenuClientes(); // Metodo para mostrar el menu de Cliente
          break;
        case 3:
          limpiarBuffer();
          MenuPedidos(); // Metodo para mostrar el menu de Pedidos
          break;
        case 4:
          limpiarBuffer();
          MenuProductos(); // Metodo para mostrar el menu de Productos
          break;
        case 5:
          limpiarBuffer();
          System.out.println("Saliendo del programa...");
          break;
        default:
          System.out.println("Opcion invalida");
          break;
      }
    } while (opcion != 5);

  }

  // Menu de empleados
  public void MenuEmpleados() {
    int opcion;
    do {
      System.out.println("\n---- Empleados ----");
      System.out.println("1) Mostrar empleados");
      System.out.println("2) Agregar empleado");
      System.out.println("3) Borrar empleado");
      System.out.println("4) Atras");

      try {
        opcion = scanner.nextInt(); // Leo el input que realizo el usuario
      } catch (InputMismatchException e) {
        System.out.println("Debe ingresar un numero");
        System.out.println(e);
        break;
      }
      switch (opcion) {
        case 1:
          limpiarBuffer();
          // Metodo para mostrar los empleados actuales
          gestorEmpleado.getLista();
          break;
        case 2:
          limpiarBuffer();

          // Declaro nuevas variables para guardar los datos que ingresa el usuario por
          // teclado
          String nombre;
          String direccion;
          int contacto;
          int salario;

          System.out.println("\nIngrese el nombre: ");
          nombre = scanner.nextLine();
          System.out.println("\nIngrese la direccion: ");
          direccion = scanner.nextLine();
          System.out.println("\nIngrese un telefono de contacto: ");
          try {
            contacto = scanner.nextInt(); // Leo el input que realizo el usuario
          } catch (InputMismatchException e) {
            System.out.println("Debe ingresar un numero");
            System.out.println(e);
            break;
          }
          System.out.println("\nIngrese el salario: ");
          try {
            salario = scanner.nextInt(); // Leo el input que realizo el usuario
          } catch (InputMismatchException e) {
            System.out.println("Debe ingresar un numero");
            System.out.println(e);
            break;
          }

          // Una vez obtenidos cada uno de los datos, creo un nuevo empleado a travez del
          // contructor de la clase Empleado
          Empleado nuevoEmpleado = new Empleado(nombre, direccion, contacto, salario);

          // Agrego este nuevo empleado a la lista de empleados
          gestorEmpleado.agregarEmpleado(nuevoEmpleado);
          break;
        case 3:
          limpiarBuffer();
          gestorEmpleado.getLista();
          System.out.println("Seleccione el empleado a eliminar: ");
          int i; // Inicializo una variable para poder saber que empleado selecciono el unsuario
          try {
            i = scanner.nextInt(); // Leo el input que realizo el usuario
          } catch (InputMismatchException e) {
            System.out.println("Debe ingresar un numero");
            System.out.println(e);
            break;
          }
          gestorEmpleado.eliminarEmpleado(gestorEmpleado.getEmpleado(i).getId()); // Metodo para eliminar el empleado seleccionado
          break;
        case 4:
          limpiarBuffer();
          MenuPrincipal();
          break;
        default:
          System.out.println("Opcion invalida.");
          break;
      }
    } while (opcion != 4);

  }

  public void MenuClientes() {
    int opcion = 0;
    do {
      System.out.println("\n---- Clientes ----");
      System.out.println("1) Mostrar clientes");
      System.out.println("2) Agregar cliente");
      System.out.println("3) Borrar cliente");
      System.out.println("4) Atras");

      try {
        opcion = scanner.nextInt(); // Leo el input que realizo el usuario
      } catch (InputMismatchException e) {
        System.out.println("Debe ingresar un numero");
        System.out.println(e);
        break;
      }
      switch (opcion) {
        case 1:
          limpiarBuffer();
          gestorCliente.getLista();
          break;
        case 2:
          limpiarBuffer();
          String nombre;
          String direccion;
          int contacto;

          System.out.println("\nIngrese el nombre: ");
          nombre = scanner.nextLine();
          System.out.println("\nIngrese la direccion: ");
          direccion = scanner.nextLine();
          System.out.println("\nIngrese un telefono de contacto: ");
          try {
            contacto = scanner.nextInt(); // Leo el input que realizo el usuario
          } catch (InputMismatchException e) {
            System.out.println("Debe ingresar un numero");
            System.out.println(e);
            break;
          }

          // Una vez obtenidos los datos creo un nuevo cliente a partir del constructor de
          // la clase Cliente
          Cliente nuevoCliente = new Cliente(nombre, direccion, contacto);

          // Agrego al nuevo cliente a la lista de clientes
          gestorCliente.agregarCliente(nuevoCliente);
          break;
        case 3:
          limpiarBuffer();
          gestorCliente.getLista();
          System.out.println("Seleccione el cliente a eliminar: ");
          int i;
          try {
            i = scanner.nextInt(); // Leo el input que realizo el usuario
          } catch (InputMismatchException e) {
            System.out.println("Debe ingresar un numero");
            System.out.println(e);
            break;
          }
          gestorCliente.eliminarCliente(gestorCliente.getCliente(i).getId());
          break;
        case 4:
          limpiarBuffer();
          MenuPrincipal();
          break;
        default:
          System.out.println("Opcion invalida.");
          break;
      }
    } while (opcion != 4);

  }

  public int MenuPedidos() {
    int opcion = 0;
    do {
      System.out.println("\n---- Pedidos ----");
      System.out.println("1) Mostrar pedidos");
      System.out.println("2) Agregar pedido");
      System.out.println("3) Marcar pedido como realizado");
      System.out.println("4) Eliminar pedido");
      System.out.println("5) Atras");

      try {
        opcion = scanner.nextInt(); // Leo el input que realizo el usuario
      } catch (InputMismatchException e) {
        System.out.println("Debe ingresar un numero");
        System.out.println(e);
        break;
      }
      switch (opcion) {
        case 1:
          limpiarBuffer();
          gestorPedido.getLista();
          break;
        case 2:
          limpiarBuffer();
          subMenuPedidos();
          break;
        case 3:
          limpiarBuffer();
          gestorPedido.getLista();
          System.out.println("Seleccione el pedido: ");
          int i;
          try {
            i = scanner.nextInt(); // Leo el input que realizo el usuario
          } catch (InputMismatchException e) {
            System.out.println("Debe ingresar un numero");
            System.out.println(e);
            break;
          }

          // Metodo para indicar que el pedido fue realizado y cambiar su estado a
          // Realizado
          gestorPedido.pedidoRealizado(gestorPedido.getPedido(i).getId());
          break;
        case 4:
          limpiarBuffer();
          gestorPedido.getLista();
          System.out.println("Seleccione el pedido a eliminar: ");
          int j;
          try {
            j = scanner.nextInt(); // Leo el input que realizo el usuario
          } catch (InputMismatchException e) {
            System.out.println("Debe ingresar un numero");
            System.out.println(e);
            break;
          }

          // Metodo para eliminar pedido de la lista
          gestorPedido.eliminarPedido(gestorPedido.getPedido(j).getId());
          break;
        case 5:
          limpiarBuffer();
          MenuPrincipal();
          break;
        default:
          System.out.println("Opcion invalida.");
          break;
      }
    } while (opcion != 5);

    return scanner.nextInt();
  }

  public int subMenuPedidos() {
    int opcion = 0;
    do {
      System.out.println("\n---- Nuevo Pedido ----");
      System.out.println("1) Agregar producto");
      System.out.println("2) Quitar producto");
      System.out.println("3) Finalizar pedido");
      System.out.println("4) Atras");

      try {
        opcion = scanner.nextInt(); // Leo el input que realizo el usuario
      } catch (InputMismatchException e) {
        System.out.println("Debe ingresar un numero");
        System.out.println(e);
        break;
      }
      switch (opcion) {
        case 1:
          limpiarBuffer();
          gestorProducto.getLista();
          System.out.println("Seleccione el producto: ");
          int i;
          try {
            i = scanner.nextInt(); // Leo el input que realizo el usuario
          } catch (InputMismatchException e) {
            System.out.println("Debe ingresar un numero");
            System.out.println(e);
            break;
          }

          // MEtodo para agregar un nuevo producto al pedido
          gestorPedido.agregarProducto(gestorProducto.getProducto(i));
          System.out.println("Producto agregado");
          break;
        case 2:
          limpiarBuffer();
          int j = 0;

          // ForEach para recorrer la lista de productos que hay en el pedido y mostrar
          // sus datos para que el usuario seleccione el producto que desa quitar
          for (Producto producto : gestorPedido.getListaProductos()) {
            j++;

            System.out.println(j + ")" + "\n" +
                "Nombre: " + producto.getNombre() + "\n" +
                "Precio: " + producto.getPrecio() + "\n");
          }
          ;
          System.out.println("Seleccione producto a quitar: ");
          int k;
          try {
            k = scanner.nextInt(); // Leo el input que realizo el usuario
          } catch (InputMismatchException e) {
            System.out.println("Debe ingresar un numero");
            System.out.println(e);
            break;
          }

          // Metodo que elimina el producto de la lista
          gestorPedido.eliminarProducto(k);
          System.out.println("Producto eliminado");
          break;
        case 3:
          limpiarBuffer();
          Cliente clientePedido; // Declaro un nuevo cliente para poder agregar el nuevo pedido
          gestorCliente.getLista();

          // Seleccion del cliente al que corresponde el nuevo pedido
          System.out.println("Seleccione el cliente: ");
          int cliente;
          try {
            cliente = scanner.nextInt(); // Leo el input que realizo el usuario
          } catch (InputMismatchException e) {
            System.out.println("Debe ingresar un numero");
            System.out.println(e);
            break;
          }
          clientePedido = gestorCliente.getCliente(cliente); // El cliente al que se le desea agregar el nuevo pedido
                                                                // es almacenado en la variable ClientePedido
          gestorPedido.agregarPedido(gestorPedido.getListaProductos(), clientePedido); // Metodo para agregar el nuevo pedido
                                                                                 // con su lista de productos y cliente
                                                                                 // seleccionado
          gestorPedido.resetLista(); // Metodo para resetear la lista de productos y poder crear un nuevo pedido
          System.out.println("Nuevo pedido agregado.");
        case 4:
          limpiarBuffer();
          MenuPrincipal();
          break;
        default:
          System.out.println("Opcion invalida.");
          break;
      }
    } while (opcion != 4);

    return scanner.nextInt();
  }

  public int MenuProductos() {
    int opcion = 0;
    do {
      System.out.println("\n---- Productos ----");
      System.out.println("1) Mostrar productos");
      System.out.println("2) Agregar producto nuevo");
      System.out.println("3) Eliminar producto");
      System.out.println("4) Atras");

      try {
        opcion = scanner.nextInt(); // Leo el input que realizo el usuario
      } catch (InputMismatchException e) {
        System.out.println("Debe ingresar un numero");
        System.out.println(e);
        break;
      }
      switch (opcion) {
        case 1:
          limpiarBuffer();
          gestorProducto.getLista();
          break;
        case 2:
          limpiarBuffer();
          String nombre;
          int precio;

          System.out.println("\nIngrese el nombre del producto: ");
          nombre = scanner.nextLine();
          System.out.println("\nIngrese el precio del producto: ");
          try {
            precio = scanner.nextInt(); // Leo el input que realizo el usuario
          } catch (InputMismatchException e) {
            System.out.println("Debe ingresar un numero");
            System.out.println(e);
            break;
          }

          // Creacion del nuevo producto a travez del constructor de la clase Producto
          Producto nuevoProducto = new Producto(precio, nombre);

          gestorProducto.agregarProducto(nuevoProducto); // Metodo para agregar el nuevo producto a la lista de productos
                                                 // disponibles
          break;
        case 3:
          limpiarBuffer();
          gestorProducto.getLista();
          System.out.println("Seleccione el producto a eliminar: ");
          int j;
          try {
            j = scanner.nextInt(); // Leo el input que realizo el usuario
          } catch (InputMismatchException e) {
            System.out.println("Debe ingresar un numero");
            System.out.println(e);
            break;
          }
          gestorProducto.eliminarProducto(j); // Metodo para eliminar el producto seleccionado
          break;
        case 4:
          limpiarBuffer();
          MenuPrincipal();
          break;
        default:
          System.out.println("Opcion invalida");
          break;
      }
    } while (opcion != 4);

    return scanner.nextInt();
  }

  // Metodo que limpia el buffer de scanner para poder obtener los nuevos ingresos
  // por teclado del usuario
  public void limpiarBuffer() {
    scanner.nextLine();
  }
}
