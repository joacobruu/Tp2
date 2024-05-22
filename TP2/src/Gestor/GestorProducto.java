package Gestor;

import java.util.ArrayList;

import modelo.Producto;

public class GestorProducto {
  private ArrayList<Producto> listaProductos;

  public GestorProducto(){
    this.listaProductos = new ArrayList<Producto>();
  }

  // Metodo para mostrar en consola la lista de productos y su informacion
  public void getListaProductos() {
    int i = 0;

    for (Producto producto : listaProductos) {
      i++;

      System.out.println(i + ")" + "\n" +
          "Nombre: " + producto.getNombre() + "\n" +
          "Precio: " + producto.getPrecio() + "\n");
    }
    ;
  }

  // Metodo para obtener buscar un producto especifico
  public Producto getProducto(int i) {
    return listaProductos.get(i - 1);
  }

  // Metodo para agregar un nuevo producto a la lista de productos
  public void agregarProducto(Producto producto) {
    listaProductos.add(producto);
  }

  // metodo para eliminar un producto de la lista de productos
  public void eliminarProducto(int i) {
    listaProductos.remove(i - 1);
  }
}
