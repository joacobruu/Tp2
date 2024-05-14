/* Clase Pedido  */

package modelo;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Pedido {
  private ArrayList<Producto> productos;
  private String fecha;
  private UUID id;
  private Cliente cliente;
  private boolean realizado;

  public Pedido(ArrayList<Producto> productos, Cliente cliente) {
    this.productos = productos;
    this.fecha = DateFormat.getInstance().format(new Date());
    this.id = UUID.randomUUID();
    this.cliente = cliente;
    this.realizado = false;
  }

  // Metodo para obtener los productos y sus respectivos precios
  public String getProductos() {
    int i = 0; // inicializo una variable de control
    String lista = ""; // inicializo el String lista para poder ir concatenando el contenido de los
                       // distintos productos en el pedido a travez de un ForEach

    // Utilizo ForEach para poder recorrer el Array de productos
    for (Producto producto : productos) {
      i++; // Aumento en 1 el valor de la variable de control

      // Por cada producto en el Array, agrego al String lista el id, nombre y su
      // precio utilizando el metodo toString de la clase Producto
      lista += i + ")" + producto.toString();
    }
    ;

    // Devuelvo el String lista con todos los datos del Array productos
    return lista;
  }

  public String getFecha() {
    return fecha;
  }

  public UUID getId() {
    return id;
  }

  // Metodo para poder obtener el precio total del pedido (sumando el precio de
  // cada producto en el)
  public int getTotal() {
    int total = 0; // Inicio la variable total en 0 para sumar el valor de cada producto

    // ForEach que recorre la lista de productos en el pedido
    for (Producto producto : productos) {
      total += producto.getPrecio(); // Sumo a la variable total el precio de cada uno de los productos
    }

    // Devuelvo el total
    return total;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public String isRealizado() {
    if (realizado == true) {
      return "Si";
    } else {
      return "No";
    }
  }

  public void setRealizado(boolean realizado) {
    this.realizado = realizado;
  }
}
