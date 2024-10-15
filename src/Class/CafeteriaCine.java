package Class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CafeteriaCine {
    List<Pedido> ventas;
    Map<String, Double> recaudacionPorProducto;
    double totalDescuentos;

    public CafeteriaCine(){
        this.ventas = new ArrayList<>();
        this.recaudacionPorProducto = new HashMap<>();
        this.totalDescuentos = 0.0;
    }

    public void agregarVenta(Pedido pedido){
        ventas.add(pedido);
        for (Map.Entry<Producto, Integer> entry : pedido.getProductos().entrySet()){
            String nombreProducto = entry.getKey().getProducts();
            double totalProducto = entry.getKey().getPrice() * entry.getValue();
            recaudacionPorProducto.put(nombreProducto, recaudacionPorProducto.getOrDefault(nombreProducto, 0.0));
        }
        totalDescuentos += pedido.getDescuento();
    }

    public void generarConsultaRecaudacion(){
        System.out.println("Total recaudado: $" + obtenerTotalRecaudado());
        System.out.println("Total descuentos aplicados a jubilados: " + totalDescuentos);
    }
    public void generarConsultaPorcentajeVentas(){
        double totalRecaudado = obtenerTotalRecaudado();
        for (Map.Entry<String, Double> entry : recaudacionPorProducto.entrySet()){
            String producto = entry.getKey();
            double recaudacion = entry.getValue();
            double porcentaje = (recaudacion / totalRecaudado) * 100;
            System.out.println(producto + porcentaje);
        }
    }
    public double obtenerTotalRecaudado(){
        return recaudacionPorProducto.values().stream().mapToDouble(Double :: doubleValue).sum();
    }
}
