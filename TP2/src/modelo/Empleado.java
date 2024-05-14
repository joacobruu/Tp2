/* Clase Empleado que hereda metodos y atributos de la clase Persona */

package modelo;

public class Empleado extends Persona {

  private int salario;

  public Empleado(String nombre, String direccion, int contacto, int salario) {
    super(nombre, direccion, contacto);
    this.salario = salario;
  }

  public int getSalario() {
    return salario;
  }

  @Override
  public String toString() {
    return "Nombre: " + getNombre() + "\n" +
        "Direccion: " + getDireccion() + "\n" +
        "Contacto: " + getContacto() + "\n" +
        "Salario: " + getSalario();
  }

}
