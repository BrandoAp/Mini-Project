package Class;

import java.util.HashMap;
import java.util.Map;

public class Pedido {
    Map<Producto, Integer> productos;
    boolean esJubilado;
    double total;
    double descuento;

    public Pedido(boolean esJubilado){
        this.productos = new HashMap<>();
        this.esJubilado = esJubilado;
        this.total = 0.0;
        this.descuento = 0.0;
    }
    public void agregarProducto (Producto producto, int cantidad){
        productos.put(producto, productos.getOrDefault(producto, 0) + cantidad);
        total += producto.getPrice()*cantidad;
    }

    public void calcularDescuento (){
        if(esJubilado){
            descuento = total * 0.20;
            total = total - descuento;
        }
    }

   public double getTotal(){
        return total;
   }
   public double getDescuento(){
        return descuento;
   }
   public Map<Producto, Integer> getProductos(){
        return productos;
   }
}
