/*
 * Clase que representa a un jugador en el juego.
 */
package modelo.beans1; // Paquete donde se encuentra la clase.

import java.util.ArrayList; // Importa la clase ArrayList.
import modelo.beans1.Carton; // Importa la clase Carton.

import javax.swing.JOptionPane; // Importa JOptionPane para mostrar mensajes.

public class Jugador { // Definición de la clase Jugador.
    private int montDin; // Monto de dinero del jugador.
    private String nombre; // Nombre del jugador.
    private ArrayList<Carton> listaCart; // Lista de cartones del jugador.
    private String jugador; // Nombre de usuario del jugador.
    private String contraseña; // Contraseña del jugador.

    // Constructor para inicializar un jugador.
    public Jugador(int montDin, String nombre, String jugador, String contraseña) {
        this.montDin = montDin; // Asigna el monto inicial.
        this.nombre = nombre; // Asigna el nombre.
        this.contraseña = contraseña; // Asigna la contraseña.
        this.jugador = jugador; // Asigna el nombre de usuario.
        listaCart = new ArrayList<Carton>(); // Inicializa la lista de cartones.
    }

    // Métodos para establecer y obtener el nombre de usuario y la contraseña.
    public void setJugador(String jugador) {
        this.jugador = jugador; // Asigna un nuevo nombre de usuario.
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña; // Asigna una nueva contraseña.
    }

    public String getJugador() {
        return jugador; // Devuelve el nombre de usuario.
    }

    public String getContraseña() {
        return contraseña; // Devuelve la contraseña.
    }

    public int getMontDin() {
        return montDin; // Devuelve el monto de dinero.
    }

    public void setMontDin(int dinero) {
        montDin = dinero; // Asigna un nuevo monto de dinero.
    }

    public String getNombre() {
        return nombre; // Devuelve el nombre del jugador.
    }

    public void setNombre(String nombre) {
        this.nombre = nombre; // Asigna un nuevo nombre.
    }

    // Método para eliminar todos los cartones del jugador.
    public void eliminarCart() {
        listaCart = new ArrayList<Carton>(); // Reinicializa la lista de cartones.
    }

    // Método para comprar un cartón.
    public String comprarCarton() {
        String res; // Mensaje de resultado.
        Carton carton; // Variable para el nuevo cartón.
        if (montDin > 10) { // Comprueba si tiene suficiente dinero.
            this.montDin -= 10; // Resta 10 del monto.
            carton = new Carton(); // Crea un nuevo cartón.
            carton.generarTab(); // Genera el tablero del cartón.
            res = "Carton comprado exitosamente"; // Mensaje de éxito.
            listaCart.add(carton); // Agrega el cartón a la lista.
        } else {
            res = "No tienes suficiente dinero, vuelva mas tarde"; // Mensaje de error.
        }
        return res; // Devuelve el mensaje.
    }

    // Método para obtener la lista de cartones.
    public ArrayList<Carton> getLista() {
        return listaCart; // Devuelve la lista de cartones.
    }

    // Método para mostrar el cartón ganador.
    public String cartonGan(int num) {
        return "Ganó con el carton: \n " + listaCart.get(num).mostrarCart(); // Muestra el cartón.
    }

    // Método para marcar una casilla en todos los cartones.
    public void marcarCasilla(int num) {
        marcarCasilla(num, 0); // Llama al método privado con el índice inicial.
    }

    // Método privado recursivo para marcar casillas.
    private void marcarCasilla(int num, int mov) {
        int numCart = listaCart.size(); // Obtiene el número de cartones.
        if (numCart - 1 > mov) { // Verifica si hay más cartones.
            listaCart.get(mov).marcarCarton(num); // Marca la casilla en el cartón actual.
            marcarCasilla(num, mov + 1); // Llama recursivamente para el siguiente cartón.
        } else {
            // Termina la recursión si no hay más cartones.
        }
    }

    // Método para verificar si el jugador canta bingo.
    public boolean cantarBingo() {
        return cantarBingo(0); // Llama al método privado con el índice inicial.
    }

    // Método privado recursivo para verificar el bingo.
    private boolean cantarBingo(int mov) {
        int numCart = listaCart.size(); // Obtiene el número de cartones.
        boolean res = false; // Inicializa el resultado.
        if (numCart - 1 > mov) { // Verifica si hay más cartones.
            if (listaCart.get(mov).bingo()) { // Comprueba si hay bingo en el cartón actual.
                res = true; // Hay bingo.
            } else {
                res = cantarBingo(mov + 1); // Llama recursivamente para el siguiente cartón.
            }
        } else {
            res = false; // Termina la recursión.
        }
        return res; // Devuelve el resultado.
    }
}
