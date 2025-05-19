/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miespe.p1proyecto1cevallosacosta;

/**
 *
 * @author espe
 */
import java.util.Scanner;

public class Validador {
    public static String leerTextoNoVacio(Scanner sc, String mensaje) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = sc.nextLine().trim();
        } while (texto.isEmpty());
        return texto;
    }

    public static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" Ingresa un numero valido.");
            }
        }
    }
}
