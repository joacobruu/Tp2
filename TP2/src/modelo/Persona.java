/* Clase Persona que se utilizara como modelo para poder crear las distintas subclases de Cliente y Empleado  */

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

  public String getDireccion() {
    return direccion;
  }

  public int getContacto() {
    return contacto;
  }
}
