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
  
  public Gestor() {
    this.listaEmpleados = new ArrayList<Empleado>();
    this.listaClientes = new ArrayList<Cliente>();
    this.listaPedidos = new ArrayList<Pedido>();
    this.listaProductos = new ArrayList<Producto>();
  }

  public void getListaEmpleados() {
    int i = 0;

        for (Empleado empleado : listaEmpleados) {
            i++;

            System.out.println(i + ")" + "\n" +
            "Nombre: " + empleado.getNombre() + "\n" +
            "Direccion: " + empleado.getDireccion() + "\n" +
            "Contacto: " + empleado.getContacto() + "\n" + 
            "Salario: " + empleado.getSalario() + "\n");
        };
  }

  public Empleado getEmpleado(int i) {
    return listaEmpleados.get(i-1);
  }
  
  public void agregarEmpleado(Empleado empleado) {
    listaEmpleados.add(empleado);
  }

  public void eliminarEmpleado(UUID id){
    for (Empleado empleadoID : listaEmpleados) {
      if (empleadoID.getId().equals(id)) {
        listaEmpleados.remove(empleadoID);
        System.out.println("Empleado: " + empleadoID.getNombre() + ", ha sido borrado.");
        break;
      }
    }
  }

  public void getListaClientes() {
    int i = 0;

        for (Cliente cliente : listaClientes) {
            i++;

            System.out.println(i + ")" + "\n" +
            "Nombre: " + cliente.getNombre() + "\n" +
            "Direccion: " + cliente.getDireccion() + "\n" +
            "Contacto: " + cliente.getContacto() + "\n");
        };
  }

  public Cliente getCliente(int i) {
    return listaClientes.get(i-1);
  }

  public void agregarCliente(Cliente cliente) {
    listaClientes.add(cliente);
  }

  public void eliminarCliente(UUID id){
    for (Cliente clienteID : listaClientes) {
      if (clienteID.getId().equals(id)) {
        listaClientes.remove(clienteID);
        System.out.println("Cliente: " + clienteID.getNombre() + ", ha sido borrado.");
        break;
      }
    }
  }

  public void getListaPedidos() {
    int i = 0;
    for (Pedido pedido : listaPedidos) {
      i++;
      System.out.println(i + ")" + "\n" +
            "ID: " + pedido.getId() + "\n" +
            "Cliente: " + pedido.getCliente() + "\n" +
            "Fecha: " + pedido.getFecha() + "\n" +
            "Productos: " + pedido.getProductos() + "\n" +
            "Total: $" + pedido.getTotal() + "\n");
    }
  }

  public Pedido getPedido(int i) {
    return listaPedidos.get(i-1);
  }

  public void agregarPedido(Pedido pedido, Cliente cliente) {
    listaPedidos.add(pedido);
    cliente.agregarPedido(pedido);
  }

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

  public void eliminarPedido(UUID id) {
    for (Pedido pedido : listaPedidos) {
      if (pedido.getId().equals(id)) {
        listaPedidos.remove(pedido);
        System.out.println("Pedido eliminado");
        break;
      }
    }
  }

  public void getListaProductos() {
    int i = 0;

        for (Producto producto : listaProductos) {
            i++;

            System.out.println(i + ")" + "\n" +
            "Nombre: " + producto.getNombre() + "\n" +
            "Precio: " + producto.getPrecio() + "\n");
        };
  }

  public Producto getProducto(int i){
    return listaProductos.get(i-1);
  }

  public void agregarProducto(Producto producto) {
    listaProductos.add(producto);
  }

  public void eliminarProducto(int i) {
    listaProductos.remove(i-1);
  }
}
