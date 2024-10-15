/*
 * Clase que representa una casilla en el juego.
 */
package modelo.beans1; // Paquete donde se encuentra la clase.

public class Casilla { // Definición de la clase Casilla.
    private String estado; // Estado de la casilla (marcada o no).
    private int num; // Número de la casilla.

    // Constructor por defecto.
    public Casilla() {
        num = 0; // Inicializa el número en 0.
        estado = "No marcado"; // Estado inicial.
    }

    // Constructor con un número específico.
    public Casilla(int num) {
        this.num = num; // Asigna el número.
        estado = "No marcado"; // Estado inicial.
    }

    // Constructor con número y estado específicos.
    public Casilla(int num, String estado) {
        this.num = num; // Asigna el número.
        this.estado = estado; // Asigna el estado.
    }

    // Método para comparar tres casillas.
    public boolean compCasilla(Casilla a, Casilla b, Casilla c) {
        boolean res = false; // Inicializa el resultado como falso.
        // Comprueba si los números de las casillas son iguales.
        res = (a.getNum() == b.getNum() || b.getNum() == c.getNum() || a.getNum() == c.getNum());
        return res; // Devuelve el resultado.
    }

    // Método para obtener el número de la casilla.
    public int getNum() {
        return num; // Devuelve el número.
    }

    // Método para establecer el número de la casilla.
    public void setNum(int num) {
        this.num = num; // Asigna un nuevo número.
    }

    // Método para obtener el estado de la casilla.
    public String getEstado() {
        return estado; // Devuelve el estado.
    }

    // Método para establecer el estado de la casilla.
    public void setEstado(String estado) {
        this.estado = estado; // Asigna un nuevo estado.
    }

    // Método para representar la casilla como cadena.
    @Override
    public String toString() {
        return "" + getNum(); // Devuelve el número como cadena.
    }
}
