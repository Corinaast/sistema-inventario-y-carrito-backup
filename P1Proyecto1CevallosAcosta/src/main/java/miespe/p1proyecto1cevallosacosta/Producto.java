/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miespe.p1proyecto1cevallosacosta;

/**
 *
 * @author espe
 */
public class Producto {
    private String codigo;
    private String modelo;
    private String marca;
    private double precio;

    public Producto(String codigo, String modelo, String marca, double precio) {
        this.codigo = codigo;
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "[" + codigo + "] " + marca + " " + modelo + " - $" + precio;
    }
}
