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

        for (Empleado empleado : this.listaEmpleados) {
            i++;

            System.out.println(i + ")" + "\n" +
            "Nombre: " + empleado.getNombre() + "\n" +
            "Direccion: " + empleado.getDireccion() + "\n" +
            "Contacto: " + empleado.getContacto() + "\n" + 
            "Salario: " + empleado.getSalario() + "\n");
        };
  }
  
  public void agregarEmpleado(Empleado empleado) {
    listaEmpleados.add(empleado);
  }

  public void eliminarEmpleado(UUID id){
    for (Empleado empleadoID : this.listaEmpleados) {
      if (empleadoID.getId().equals(id)) {
        listaEmpleados.remove(empleadoID);
        System.out.println("Empleado: " + empleadoID.getNombre() + ", ha sido borrado.");
        break;
      }
    }
  }

  public void getListaClientes() {
    int i = 0;

        for (Cliente cliente : this.listaClientes) {
            i++;

            System.out.println(i + ")" + "\n" +
            "Nombre: " + cliente.getNombre() + "\n" +
            "Direccion: " + cliente.getDireccion() + "\n" +
            "Contacto: " + cliente.getContacto() + "\n");
        };
  }

  public void agregarCliente(Cliente cliente) {
    listaClientes.add(cliente);
  }

  public void eliminarCliente(UUID id){
    for (Cliente clienteID : this.listaClientes) {
      if (clienteID.getId().equals(id)) {
        listaClientes.remove(clienteID);
        System.out.println("Cliente: " + clienteID.getNombre() + ", ha sido borrado.");
        break;
      }
    }
  }

  public ArrayList<Pedido> getListaPedidos() {
    return listaPedidos;
  }

  public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
    this.listaPedidos = listaPedidos;
  }

  public ArrayList<Producto> getListaProductos() {
    return listaProductos;
  }

  public void setListaProductos(ArrayList<Producto> listaProductos) {
    this.listaProductos = listaProductos;
  }
}
