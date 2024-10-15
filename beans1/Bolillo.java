/*
 * Este es un archivo de plantilla de licencia.
 */

package modelo.beans1; // Aquí se define el paquete donde está la clase.

public class Bolillo { // Se define la clase llamada Bolillo.
    private String color; // Se declara una variable para almacenar el color.
    private String simbolo; // Se declara una variable para almacenar el símbolo.
    private int numero; // Se declara una variable para almacenar un número.

    // Constructor que recibe color y símbolo.
    public Bolillo(String color, String simbolo) {
        this.color = color; // Asigna el color pasado como argumento a la variable.
        this.simbolo = simbolo; // Asigna el símbolo pasado como argumento a la variable.
    }

    // Constructor que recibe solo un número.
    public Bolillo(int numero) {
        this.numero = numero; // Asigna el número pasado como argumento a la variable.
    }

    // Método para obtener el color.
    public String getColor() {
        return color; // Devuelve el color.
    }

    // Método para establecer un nuevo color.
    public void setColor(String color) {
        this.color = color; // Asigna el nuevo color a la variable.
    }

    // Método para obtener el símbolo.
    public String getSimbolo() {
        return simbolo; // Devuelve el símbolo.
    }

    // Método para establecer un nuevo símbolo.
    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo; // Asigna el nuevo símbolo a la variable.
    }

    // Método para obtener el número.
    public int getNumero() {
        return numero; // Devuelve el número.
    }

    // Método para establecer un nuevo número.
    public void setNumero(int numero) {
        this.numero = numero; // Asigna el nuevo número a la variable.
    }
}
