package modelo;

import java.util.UUID;

public class Producto {
  private UUID id;
  private int precio;
  private String nombre;
  public Producto(UUID id, int precio, String nombre) {
    this.id = id;
    this.precio = precio;
    this.nombre = nombre;
  }
  public UUID getId() {
    return id;
  }
  public int getPrecio() {
    return precio;
  }
  public void setPrecio(int precio) {
    this.precio = precio;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  @Override
  public String toString() {
    return "Producto [id=" + id + ", precio=" + precio + ", nombre=" + nombre + "]";
  }
}
