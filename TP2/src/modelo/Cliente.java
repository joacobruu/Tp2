/* Clase Cliente que hereda metodos y atributos de la clase Persona */

package modelo;

import java.util.ArrayList;

public class Cliente extends Persona {

  private ArrayList<Pedido> pedidos;

  public Cliente(String nombre, String direccion, int contacto) {
    super(nombre, direccion, contacto);
    this.pedidos = new ArrayList<Pedido>();
  }

  public void agregarPedido(Pedido pedido) {
    pedidos.add(pedido);
  }

  @Override
  public String toString() {
    return "Cliente: " + getNombre() + "\n" +
        "Direccion: " + getDireccion() + "\n" +
        "Contacto:" + getContacto();
  }

}
