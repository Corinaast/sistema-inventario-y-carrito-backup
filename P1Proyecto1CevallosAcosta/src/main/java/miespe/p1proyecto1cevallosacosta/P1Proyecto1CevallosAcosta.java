/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package miespe.p1proyecto1cevallosacosta;
import java.util.*;
/**
 *
 * @author espe
 */
public class P1Proyecto1CevallosAcosta {
    private static final List<Producto> catalogo = new ArrayList<>();
    private static final List<Producto> stock = new ArrayList<>();
    private static final Carrito carrito = new Carrito();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        inicializarCatalogoYStock();

        int opcion;
        do {
            System.out.println("\n === SISTEMA DE VENTAS ===");
            System.out.println("1. Ver catalogo");
            System.out.println("2. Ver stock disponible");
            System.out.println("3. Agregar producto al carrito");
            System.out.println("4. Ver carrito");
            System.out.println("5. Finalizar compra");
            System.out.println("6. Salir");

            opcion = Validador.leerEntero(scanner, "Opcion: ");

            switch (opcion) {
                case 1 -> mostrarLista(catalogo, " Catalogo de Telefonos");
                case 2 -> mostrarLista(stock, " Productos en Stock");
                case 3 -> agregarAlCarrito(scanner);
                case 4 -> mostrarCarrito();
                case 5 -> finalizarCompra();
                case 6 -> System.out.println(" Saliendo...");
                default -> System.out.println("❌ Opción invalida.");
            }
        } while (opcion != 6);
    }

    private static void inicializarCatalogoYStock() {
        Producto p1 = new Producto("T100", "Galaxy A54", "Samsung", 399.99);
        Producto p2 = new Producto("T101", "iPhone 13", "Apple", 799.00);
        Producto p3 = new Producto("T102", "Redmi Note 12", "Xiaomi", 249.50);
        Producto p4 = new Producto("T103", "Moto G72", "Motorola", 299.90);

        catalogo.addAll(List.of(p1, p2, p3, p4));

        stock.addAll(List.of(p1, p2, p4)); // Xiaomi no está en stock
    }

    private static void mostrarLista(List<Producto> lista, String titulo) {
        System.out.println("\n" + titulo);
        if (lista.isEmpty()) {
            System.out.println("️ No hay productos disponibles.");
            return;
        }
        for (Producto p : lista) {
            System.out.println(p);
        }
    }

    private static void agregarAlCarrito(Scanner scanner) {
        String codigo = Validador.leerTextoNoVacio(scanner, " Ingrese el codigo del producto: ");
        Optional<Producto> productoOpt = stock.stream()
                .filter(p -> p.getCodigo().equalsIgnoreCase(codigo))
                .findFirst();

        if (productoOpt.isPresent()) {
            Producto prod = productoOpt.get();
            System.out.println("3 Producto encontrado: " + prod);
            String confirmacion = Validador.leerTextoNoVacio(scanner, "¿Deseas agregarlo al carrito? (s/n): ");
            if (confirmacion.equalsIgnoreCase("s")) {
                carrito.agregar(prod);
            } else {
                System.out.println("❗ Producto no agregado.");
            }
        } else {
            System.out.println(" El producto no esta en stock.");
            String continuar = Validador.leerTextoNoVacio(scanner, "¿Deseas intentar con otro producto? (s/n): ");
            if (continuar.equalsIgnoreCase("n")) {
                System.out.println("Cancelando seleccion.");
            }
        }
    }

    private static void mostrarCarrito() {
        System.out.println("\n CARRITO DE COMPRAS:");
        if (carrito.estaVacio()) {
            System.out.println(" El carrito esta vacio.");
            return;
        }

        for (Producto p : carrito.getProductos()) {
            System.out.println(p);
        }
        System.out.println("💰 Total: $" + carrito.calcularTotal());
    }

    private static void finalizarCompra() {
        if (carrito.estaVacio()) {
            System.out.println("🛑 No hay productos en el carrito para generar factura.");
            return;
        }
        ArchivoFactura.guardarFactura(carrito.getProductos(), carrito.calcularTotal());
    }
}