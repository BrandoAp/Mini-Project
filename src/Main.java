
import java.util.Map;
import java.util.Scanner;
import Class.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CafeteriaCine cafeteria = new CafeteriaCine();
        boolean continuar = true;

        Producto popcornChico = new Producto("Popcorn Chico", 1.25);
        Producto popcornMediano = new Producto("Popcorn Mediano", 2.00);
        Producto popcornGrande = new Producto("Popcorn Grande", 3.00);
        Producto hotdog = new Producto("Hotdog", 2.50);
        Producto refrescoPequeno = new Producto("Refresco Pequeño", 1.30);
        Producto refrescoMediano = new Producto("Refresco Mediano", 2.00);
        Producto refrescoGrande = new Producto("Refresco Grande", 2.75);
        Producto agua = new Producto("Agua", 1.50);
        Producto chocolate = new Producto("Chocolate", 1.75);
        Producto combo1 = new Producto("Combo1 (Popcorn Mediano + Refresco Grande)", 4.50);
        Producto combo2 = new Producto("Combo2 (Hotdog + Refresco Grande)", 5.00);
        Producto combo3 = new Producto("Combo3 (Popcorn Grande + 2 Refrescos Medianos)", 6.80);

        while (continuar){
            System.out.println("El cliente es jubilado? (s/n): ");
            boolean esJubilado = scanner.nextLine().equalsIgnoreCase("s");

            Pedido pedido = new Pedido(esJubilado);

            boolean pedirMas = true;
            while (pedirMas) {
                System.out.println("\nMenú de productos:");
                System.out.println("1. Popcorn Chico $1.25");
                System.out.println("2. Popcorn Mediano $2.00");
                System.out.println("3. Popcorn Grande $3.00");
                System.out.println("4. Hotdog $2.50");
                System.out.println("5. Refresco Pequeño $1.30");
                System.out.println("6. Refresco Mediano $2.00");
                System.out.println("7. Refresco Grande $2.75");
                System.out.println("8. Agua $1.50");
                System.out.println("9. Chocolate $1.75");
                System.out.println("10. Combo1 (Popcorn Mediano + Refresco Grande) $4.50");
                System.out.println("11. Combo2 (Hotdog + Refresco Grande) $5.00");
                System.out.println("12. Combo3 (Popcorn Grande + 2 Refrescos Medianos) $6.80");
                System.out.println("Seleccione un producto (1-12): ");
                int opcion = scanner.nextInt();
                System.out.println("Ingrese la cantidad: ");
                int cantidad = scanner.nextInt();
                scanner.nextLine();

                switch (opcion){
                    case 1: pedido.agregarProducto(popcornChico, cantidad); break;
                    case 2: pedido.agregarProducto(popcornMediano, cantidad); break;
                    case 3: pedido.agregarProducto(popcornGrande, cantidad); break;
                    case 4: pedido.agregarProducto(hotdog, cantidad); break;
                    case 5: pedido.agregarProducto(refrescoPequeno, cantidad); break;
                    case 6: pedido.agregarProducto(refrescoMediano, cantidad); break;
                    case 7: pedido.agregarProducto(refrescoGrande, cantidad); break;
                    case 8: pedido.agregarProducto(agua, cantidad); break;
                    case 9: pedido.agregarProducto(chocolate, cantidad); break;
                    case 10: pedido.agregarProducto(combo1, cantidad); break;
                    case 11: pedido.agregarProducto(combo2, cantidad); break;
                    case 12: pedido.agregarProducto(combo3, cantidad); break;
                    default: System.out.println("Opción inválida"); break;
                }
                System.out.println("¿Desea agregar otro producto? (s/n): ");
                pedirMas = scanner.nextLine().equalsIgnoreCase("s");
            }
            pedido.calcularDescuento();

            cafeteria.agregarVenta(pedido);

            System.out.println("\nFactura");
            for (Map.Entry<Producto, Integer> entry : pedido.getProductos().entrySet()){
                System.out.println(entry.getValue() + "x " + entry.getKey().getProducts() + entry.getKey().getPrice());
            }
            System.out.println("Descuento aplicado: $" + pedido.getDescuento());
            System.out.println("Total a pagar: $" + pedido.getTotal());

            System.out.println("\n¿Desea realizar otra venta? (s/n)");
            continuar = scanner.nextLine().equalsIgnoreCase("s");
        }
        System.out.println("\nGenerar reportes");
        cafeteria.generarConsultaRecaudacion();
        cafeteria.generarConsultaPorcentajeVentas();

        scanner.close();
    }
}