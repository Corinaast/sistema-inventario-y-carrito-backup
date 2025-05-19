/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miespe.p1proyecto1cevallosacosta;

/**
 *
 * @author espe
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
public class ArchivoFactura {
     public static void guardarFactura(List<Producto> productos, double total) {
        try (FileWriter writer = new FileWriter("factura.txt")) {
            writer.write("==== FACTURA ====\n");
            for (Producto p : productos) {
                writer.write(p.toString() + "\n");
            }
            writer.write("---------------------\n");
            writer.write("TOTAL: $" + total + "\n");
            System.out.println(" Factura generada correctamente: factura.txt");
        } catch (IOException e) {
            System.out.println(" Error al generar la factura: " + e.getMessage());
        }
    }
}
