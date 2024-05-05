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
  
  public Pedido(ArrayList<Producto> productos, String fecha, UUID id, Cliente cliente) {
    this.productos = new ArrayList<Producto>();
    this.fecha = DateFormat.getInstance().format(new Date());
    this.id = id;
    this.cliente = cliente;
  }
  public String getProductos() {
    int i = 0;
    String lista = "";
        for (Producto producto : productos) {
            i++;
            lista += i + ")" +
            "Producto: " + producto.getNombre() + "\n" +
            "Precio: $" + producto.getPrecio() + "\n";
        };
    return lista;
  }
  public void agregarProducto(Producto producto) {
    this.productos.add(producto);
  }
  public String getFecha() {
    return fecha;
  }
  public UUID getId() {
    return id;
  }
  public int getTotal() {
    int total = 0;
    for (Producto producto : productos) {
      total += producto.getPrecio();
    }
    return total;
  }
  public Cliente getCliente() {
    return cliente;
  }
}
