


package modelo.beans1; // Se define el paquete donde está la clase.

import java.util.ArrayList; // Se importa la clase ArrayList para usar listas dinámicas.

/**
 *
 * @author ASUS
 */
public class Carton { // Se define la clase llamada Carton.
    private ArrayList<Casilla> fila1; // Lista para la primera fila de casillas.
    private ArrayList<Casilla> fila2; // Lista para la segunda fila de casillas.
    private ArrayList<Casilla> fila3; // Lista para la tercera fila de casillas.
    private int col; // Número de columnas.
    public ArrayList<Casilla> casillas; // Lista de casillas.

    // Constructor de la clase Carton.
    public Carton() {
        casillas = new ArrayList<Casilla>(); // Inicializa la lista de casillas.
        fila1 = new ArrayList<>(); // Inicializa la primera fila.
        fila2 = new ArrayList<>(); // Inicializa la segunda fila.
        fila3 = new ArrayList<>(); // Inicializa la tercera fila.
        col = 9; // Define el número de columnas como 9.
    }

    // Método privado para generar el cartón.
    private void generarCarton(int fichAzul, int fichRojo, int fichVerde) {
        int i = 0 + fichAzul; // Define el inicio del rango para fichas azules.
        int j = 9 + fichAzul; // Define el final del rango para fichas azules.
        int num = (int)(Math.random() * (j - i + 1) + i); // Genera un número aleatorio en el rango.
        Casilla casilla = new Casilla(); // Crea una nueva casilla.
        casilla.setNum(num); // Asigna el número generado a la casilla.
        
        // Verifica si la primera fila ya tiene el número máximo de columnas.
        if (fila1.size() == col) {
            this.fila1 = fila1; // Asigna la fila 1 si está completa.
        } else {
            fichAzul += 10; // Aumenta el rango para la siguiente ficha azul.
            fila1.add(casilla); // Agrega la casilla a la fila 1.
            generarCarton(fichAzul, fichRojo, fichVerde); // Llama nuevamente para seguir generando.
        }
        
        // Verifica si todavía hay fichas azules para generar.
        if (fichAzul != 1) {
            fichAzul = fichAzul / fichAzul; // Resetea fichAzul.
            generarCarton(fichAzul, fichRojo, fichVerde); // Cont
