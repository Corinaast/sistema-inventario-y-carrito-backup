/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miespe.p1proyecto1cevallosacosta;

/**
 *
 * @author espe
 */
import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Producto> productos = new ArrayList<>();

    public void agregar(Producto p) {
        productos.add(p);
        System.out.println("✔️ Producto agregado al carrito.");
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double calcularTotal() {
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }

    public boolean estaVacio() {
        return productos.isEmpty();
    }
}
