/*
 * Clase que representa a un locutor en el juego.
 */
package modelo.beans1; // Paquete donde se encuentra la clase.

import java.util.ArrayList; // Importa la clase ArrayList.
import modelo.beans1.Jugador; // Importa la clase Jugador.

public class Locutor { // Definición de la clase Locutor.
    private Tambor tambor; // Objeto de la clase Tambor que saca los números.
    private ArrayList<Jugador> listaJugadores; // Lista de jugadores inscritos en el juego.
    String cartonGan; // Cartón que ganó.
    String ganador; // Nombre del jugador que ganó.

    // Constructor para inicializar el locutor.
    public Locutor() {
        tambor = new Tambor(); // Crea un nuevo tambor.
        listaJugadores = new ArrayList<>(); // Inicializa la lista de jugadores.
    }

    // Método para anunciar un número sacado del tambor.
    public int anunciarBol() {
        int res = tambor.sacarBol(); // Saca un número del tambor.
        return res; // Devuelve el número.
    }

    // Método para registrar un jugador en la lista.
    public void registrar(Jugador inscrito) {
        listaJugadores.add(inscrito); // Agrega el jugador a la lista.
    }

    // Método para verificar si hay un ganador.
    public boolean hayGan() {
        return hayGan(0); // Llama al método privado con el índice inicial.
    }

    // Método privado recursivo para verificar si algún jugador ganó.
    private boolean hayGan(int pos) {
        int numJug = listaJugadores.size(); // Obtiene el número de jugadores.
        boolean res = false; // Inicializa el resultado.
        if (numJug > pos) { // Verifica si hay más jugadores.
            if (listaJugadores.get(pos).cantarBingo()) { // Comprueba si el jugador actual tiene bingo.
                res = true; // Hay un ganador.
            } else {
                res = hayGan(pos + 1); // Llama recursivamente para el siguiente jugador.
            }
        } else {
            // Termina la recursión si no hay más jugadores.
        }
        return res; // Devuelve el resultado.
    }

    // Método para iniciar el juego.
    public void iniciarJuego() {
        iniciarJuego(0, 0); // Llama al método privado con los índices iniciales.
    }

    // Método privado recursivo para llevar a cabo el juego.
    private void iniciarJuego(int pos, int ultBol) {
        int numJug = listaJugadores.size(); // Obtiene el número de jugadores.
        if (numJug - 1 < pos) { // Verifica si se ha pasado por todos los jugadores.
            iniciarJuego(0, tambor.sacarBol()); // Reinicia el ciclo con un nuevo número.
        } else {
            listaJugadores.get(pos).marcarCasilla(ultBol); // Marca la casilla correspondiente en el cartón del jugador actual.
            if (hayGan()) { // Verifica si hay un ganador.
                ganador = listaJugadores.get(
