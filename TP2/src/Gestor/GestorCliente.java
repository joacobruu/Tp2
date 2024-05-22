package Gestor;

import java.util.ArrayList;
import java.util.UUID;

import modelo.Cliente;

public class GestorCliente {
  private ArrayList<Cliente> listaClientes;

  public GestorCliente(){
    this.listaClientes = new ArrayList<Cliente>();
  }

   // Metodo que devuelve la lista de clientes
  public void getListaClientes() {
    int i = 0;

    // ForEach que recorre la lista de clientes y muestra en pantalla los datos de
    // cada uno de ellos
    for (Cliente cliente : listaClientes) {
      i++;

      System.out.println(i + ")" + "\n" + cliente.toString());
    }
    ;
  }

  // Metodo para obtener buscar un cliente especifico
  public Cliente getCliente(int i) {
    return listaClientes.get(i - 1);
  }

  // Metodo para agregar un nuevo cliente a la lista de clientes
  public void agregarCliente(Cliente cliente) {
    listaClientes.add(cliente);
  }

  // Metodo para eliminar un cliente a travez de su ID
  public void eliminarCliente(UUID id) {
    // ForEach para recorrer la lista de clientes
    for (Cliente clienteID : listaClientes) {
      // If que compara el id de cada cliente en la lista hasta encontrar el cliente
      // correcto y quitarlo de la lista
      if (clienteID.getId().equals(id)) {
        listaClientes.remove(clienteID);
        System.out.println("Cliente: " + clienteID.getNombre() + ", ha sido borrado.");
        break;
      }
    }
  }
}
