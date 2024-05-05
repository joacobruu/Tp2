package modelo;

import java.util.ArrayList;

public class Cliente extends Persona {

  private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

  public Cliente(String nombre, String direccion, int contacto, ArrayList<Pedido> pedidos) {
    super(nombre, direccion, contacto);
    this.pedidos = pedidos;
  }

  public ArrayList<Pedido> getPedidos() {
    return pedidos;
  }

  public void setPedidos(ArrayList<Pedido> pedidos) {
    this.pedidos = pedidos;
  }
}
