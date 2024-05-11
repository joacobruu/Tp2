/* Clase Gestor, se encarga de toda la logica detras de la aplicacion */

package Gestor;

import java.util.ArrayList;
import java.util.UUID;

import modelo.Cliente;
import modelo.Empleado;
import modelo.Pedido;
import modelo.Producto;

public class Gestor {
  private ArrayList<Empleado> listaEmpleados;
  private ArrayList<Cliente> listaClientes;
  private ArrayList<Pedido> listaPedidos;
  private ArrayList<Producto> listaProductos;
  private ArrayList<Producto> listaProductosPedido;
  
  public Gestor() {
    this.listaEmpleados = new ArrayList<Empleado>();
    this.listaClientes = new ArrayList<Cliente>();
    this.listaPedidos = new ArrayList<Pedido>();
    this.listaProductos = new ArrayList<Producto>();
    this.listaProductosPedido = new ArrayList<Producto>();
  }

  //Metodo que devuelve la lista de empleados
  public void getListaEmpleados() {
    int i = 0;

        //ForEach que recorre la lista de empleados y muestra en pantalla los datos de cada uno de ellos
        for (Empleado empleado : listaEmpleados) {
            i++;

            System.out.println(i + ")" + empleado.toString());
        };
  }

  //Metodo para obtener buscar un empleado especifico
  public Empleado getEmpleado(int i) {
    return listaEmpleados.get(i-1);
  }
  
  //Metodo para agregar un nuevo empleado a la lista de empleados
  public void agregarEmpleado(Empleado empleado) {
    listaEmpleados.add(empleado);
  }

  //Metodo para eliminar un empleado a travez de su ID
  public void eliminarEmpleado(UUID id){
    //ForEach para recorrer la lista de empleados
    for (Empleado empleadoID : listaEmpleados) {
      //If que compara el id de cada empleado en la lista hasta encontrar el empleado correcto y quitarlo de la lista
      if (empleadoID.getId().equals(id)) {
        listaEmpleados.remove(empleadoID);
        System.out.println("Empleado: " + empleadoID.getNombre() + ", ha sido borrado.");
        break;
      }
    }
  }

  //Metodo que devuelve la lista de clientes
  public void getListaClientes() {
    int i = 0;

        //ForEach que recorre la lista de clientes y muestra en pantalla los datos de cada uno de ellos
        for (Cliente cliente : listaClientes) {
            i++;

            System.out.println(i + ")" + "\n" + cliente.toString());
        };
  }

  //Metodo para obtener buscar un cliente especifico
  public Cliente getCliente(int i) {
    return listaClientes.get(i-1);
  }

  //Metodo para agregar un nuevo cliente a la lista de clientes
  public void agregarCliente(Cliente cliente) {
    listaClientes.add(cliente);
  }

  //Metodo para eliminar un cliente a travez de su ID
  public void eliminarCliente(UUID id){
    //ForEach para recorrer la lista de clientes
    for (Cliente clienteID : listaClientes) {
      //If que compara el id de cada cliente en la lista hasta encontrar el cliente correcto y quitarlo de la lista
      if (clienteID.getId().equals(id)) {
        listaClientes.remove(clienteID);
        System.out.println("Cliente: " + clienteID.getNombre() + ", ha sido borrado.");
        break;
      }
    }
  }

  //Metodo para mostrar en pantalla cada uno de los pedidos en la lista con su informacion
  public void getListaPedidos() {
    int i = 0;
    for (Pedido pedido : listaPedidos) {
      i++;
      System.out.println(i + ")" + "\n" +
            "ID: " + pedido.getId() + "\n" +
            "Cliente: " + pedido.getCliente().getNombre() + "\n" +
            "Direccion: " + pedido.getCliente().getDireccion() + "\n" +
            "Fecha: " + pedido.getFecha() + "\n" +
            "Productos: " + pedido.getProductos() + "\n" +
            "Total: $" + pedido.getTotal() + "\n" +
            "Realizado: " + pedido.isRealizado() + "\n");
    }
  }

  //Metodo para obtener buscar un pedido especifico
  public Pedido getPedido(int i) {
    return listaPedidos.get(i-1);
  }

  //Metodo para agregar un nuevo pedido a la lista de pedidos
  public void agregarPedido(ArrayList<Producto> productos, Cliente cliente) {
    Pedido nuevoPedido = new Pedido(productos, cliente); //Creo el nuevo pedido con la lista de productos y el cliente
    listaPedidos.add(nuevoPedido); //Agrego el nuevo pedido a la lista de pedidos
    cliente.agregarPedido(nuevoPedido); //Agrego el nuevo pedido al cliente correspondiente
  }

  //Metodo para cambiar el estado de un pedido de no realizado a realizado
  public void pedidoRealizado(UUID id) {
    for (Pedido pedido : listaPedidos) {
      if (pedido.getId() == id) {
        pedido.setRealizado(true);
        System.out.println("Pedido marcado como realizado");
      } else {
        System.out.println("El pedido ya se encuentra completado");
      }
    }
  }

  //Metodo para eliminar un pedido a travez de su ID
  public void eliminarPedido(UUID id) {
    for (Pedido pedido : listaPedidos) {
      if (pedido.getId().equals(id)) {
        listaPedidos.remove(pedido);
        System.out.println("Pedido eliminado");
        break;
      }
    }
  }

  //Metodo para mostrar en consola la lista de productos y su informacion
  public void getListaProductos() {
    int i = 0;

        for (Producto producto : listaProductos) {
            i++;

            System.out.println(i + ")" + "\n" +
            "Nombre: " + producto.getNombre() + "\n" +
            "Precio: " + producto.getPrecio() + "\n");
        };
  }

  //Metodo para obtener buscar un producto especifico
  public Producto getProducto(int i){
    return listaProductos.get(i-1);
  }

  //Metodo para agregar un nuevo producto a la lista de productos
  public void agregarProducto(Producto producto) {
    listaProductos.add(producto);
  }

  //metodo para eliminar un producto de la lista de productos
  public void eliminarProducto(int i) {
    listaProductos.remove(i-1);
  }

  //Metodo para agregar un nuevo producto a la lista de productos en el pedido
  public void agregarProductoPedido(Producto producto) {
    listaProductosPedido.add(producto);
  }

  //Metodo para obtener la lista de productos en el Pedido
  public ArrayList<Producto> getListaProductosPedido() {
    return listaProductosPedido;
  }

  //Metodo para eliminar un producto del Pedido
  public void eliminarProductoPedido(int i) {
    listaProductosPedido.remove(i - 1);
  }

  //Metodo para volver a iniciar la lista de productos en un pedido
  public void resetListaPedido() {
    listaProductosPedido = new ArrayList<Producto>();
  }
}
