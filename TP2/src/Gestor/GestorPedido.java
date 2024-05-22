package Gestor;

import java.util.ArrayList;
import java.util.UUID;

import modelo.Cliente;
import modelo.Pedido;
import modelo.Producto;

public class GestorPedido {
  
  private ArrayList<Pedido> listaPedidos;
  private ArrayList<Producto> listaProductosPedido;

  public GestorPedido(){
    this.listaPedidos = new ArrayList<Pedido>();
    this.listaProductosPedido = new ArrayList<Producto>();
  }

   // Metodo para mostrar en pantalla cada uno de los pedidos en la lista con su
  // informacion
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

  // Metodo para obtener buscar un pedido especifico
  public Pedido getPedido(int i) {
    return listaPedidos.get(i - 1);
  }

  // Metodo para agregar un nuevo pedido a la lista de pedidos
  public void agregarPedido(ArrayList<Producto> productos, Cliente cliente) {
    Pedido nuevoPedido = new Pedido(productos, cliente); // Creo el nuevo pedido con la lista de productos y el cliente
    listaPedidos.add(nuevoPedido); // Agrego el nuevo pedido a la lista de pedidos
    cliente.agregarPedido(nuevoPedido); // Agrego el nuevo pedido al cliente correspondiente
  }

  // Metodo para cambiar el estado de un pedido de no realizado a realizado
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

  // Metodo para eliminar un pedido a travez de su ID
  public void eliminarPedido(UUID id) {
    for (Pedido pedido : listaPedidos) {
      if (pedido.getId().equals(id)) {
        listaPedidos.remove(pedido);
        System.out.println("Pedido eliminado");
        break;
      }
    }
  }

  // Metodo para agregar un nuevo producto a la lista de productos en el pedido
  public void agregarProductoPedido(Producto producto) {
    listaProductosPedido.add(producto);
  }

  // Metodo para obtener la lista de productos en el Pedido
  public ArrayList<Producto> getListaProductosPedido() {
    return listaProductosPedido;
  }

  // Metodo para eliminar un producto del Pedido
  public void eliminarProductoPedido(int i) {
    listaProductosPedido.remove(i - 1);
  }

  // Metodo para volver a iniciar la lista de productos en un pedido
  public void resetListaPedido() {
    listaProductosPedido = new ArrayList<Producto>();
  }
}
