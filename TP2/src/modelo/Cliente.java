package modelo;

import java.util.ArrayList;

public class Cliente extends Persona {

  private ArrayList<Pedido> pedidos;

  public Cliente(String nombre, String direccion, int contacto, ArrayList<Pedido> pedidos) {
    super(nombre, direccion, contacto);
    this.pedidos = new ArrayList<Pedido>();
  }

  public Cliente(String nombre, String direccion, int contacto) {
    super(nombre, direccion, contacto);
    this.pedidos = new ArrayList<Pedido>();
  }
  public void getPedidos() {
    int i = 0;
    for (Pedido pedido : pedidos) {
      i++;
      System.out.println(i + ")" + "\n" +
            "ID: " + pedido.getId() + "\n" +
            "Fecha: " + pedido.getFecha() + "\n" +
            "Total: " + pedido.getTotal() + "\n");
    }
  }
}
