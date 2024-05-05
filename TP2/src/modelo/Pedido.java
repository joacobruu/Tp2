package modelo;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Pedido {
  private ArrayList<Producto> productos = new ArrayList<Producto>();
  private String fecha;
  private UUID id;
  private int total;
  private Cliente cliente;
  
  public Pedido(ArrayList<Producto> productos, String fecha, UUID id, int total, Cliente cliente) {
    this.productos = productos;
    this.fecha = DateFormat.getInstance().format(new Date());
    this.id = id;
    this.total = total;
    this.cliente = cliente;
  }
  public ArrayList<Producto> getProductos() {
    return productos;
  }
  public void agregarProducto(Producto producto) {
    this.productos.add(producto);
  }
  public String getFecha() {
    return fecha;
  }
  public void setFecha(String fecha) {
    this.fecha = fecha;
  }
  public UUID getId() {
    return id;
  }
  public void setId(UUID id) {
    this.id = id;
  }
  public int getTotal() {
    return total;
  }
  public void setTotal(int total) {
    this.total = total;
  }
  public Cliente getCliente() {
    return cliente;
  }
  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }
  

}
