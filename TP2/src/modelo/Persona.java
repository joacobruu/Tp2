package modelo;

import java.util.UUID;

public class Persona {
  private UUID id;
  private String nombre;
  private String direccion;
  private int contacto;
  
  public Persona(String nombre, String direccion, int contacto) {
    this.id = UUID.randomUUID();
    this.nombre = nombre;
    this.direccion = direccion;
    this.contacto = contacto;
  }
  public UUID getId() {
    return id;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public String getDireccion() {
    return direccion;
  }
  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }
  public int getContacto() {
    return contacto;
  }
  public void setContacto(int contacto) {
    this.contacto = contacto;
  }
  @Override
  public String toString() {
    return "Persona [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", contacto="
        + contacto + "]";
  }  
}
