/* Clase Producto */

package modelo;
import java.util.UUID;

public class Producto {
  private UUID id;
  private int precio;
  private String nombre;

  public Producto(int precio, String nombre) {
    this.id = UUID.randomUUID();
    this.precio = precio;
    this.nombre = nombre;
  }
  public UUID getId() {
    return id;
  }
  public int getPrecio() {
    return precio;
  }
  public String getNombre() {
    return nombre;
  }
  @Override
  public String toString() {
    return "Id: " + getId() + "\n" +
           "Nombre: " + getNombre() + "\n" +
           "precio: $" + getPrecio();
  }
}
