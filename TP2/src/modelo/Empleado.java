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

  public void setSalario(int salario) {
    this.salario = salario;
  }
}
