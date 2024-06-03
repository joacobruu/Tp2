package Gestor;

import java.util.ArrayList;
import java.util.UUID;

import modelo.Empleado;

public class GestorEmpleado {
  private ArrayList<Empleado> listaEmpleados;

  public GestorEmpleado(){
    this.listaEmpleados = new ArrayList<Empleado>();
  }

  // Metodo que devuelve la lista de empleados
  public void getLista() {
    int i = 0;

    // ForEach que recorre la lista de empleados y muestra en pantalla los datos de
    // cada uno de ellos
    for (Empleado empleado : listaEmpleados) {
      i++;

      System.out.println(i + ")" + empleado.toString());
    }
    ;
  }
   // Metodo para obtener buscar un empleado especifico
  public Empleado getEmpleado(int i) {
    return listaEmpleados.get(i - 1);
  }

  // Metodo para agregar un nuevo empleado a la lista de empleados
  public void agregarEmpleado(Empleado empleado) {
    listaEmpleados.add(empleado);
  }

  // Metodo para eliminar un empleado a travez de su ID
  public void eliminarEmpleado(UUID id) {
    // ForEach para recorrer la lista de empleados
    for (Empleado empleadoID : listaEmpleados) {
      // If que compara el id de cada empleado en la lista hasta encontrar el empleado
      // correcto y quitarlo de la lista
      if (empleadoID.getId().equals(id)) {
        listaEmpleados.remove(empleadoID);
        System.out.println("Empleado: " + empleadoID.getNombre() + ", ha sido borrado.");
        break;
      }
    }
  }

}
