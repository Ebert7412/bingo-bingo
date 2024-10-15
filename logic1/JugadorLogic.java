/*
 * Clase para manejar la lógica de los jugadores, interactuando con la capa de datos.
 */
package modelo.logic1; // Paquete donde se encuentra la clase.

import modelo.beans1.Jugador; // Importa la clase Jugador.
import modelo.dao1.JugadorDAO; // Importa la clase JugadorDAO.

public class JugadorLogic { // Definición de la clase JugadorLogic.
    
    private static JugadorDAO jugadordao = new JugadorDAO(); // Instancia de JugadorDAO.

    // Método para autenticar a un jugador con su usuario y contraseña.
    public static boolean autentificar(String jugador, String contraseña) {
        // Comprueba si el jugador existe en la base de datos.
        if (obtener(jugador) != null) {
            Jugador jugadorConsulta = obtener(jugador); // Obtiene el jugador.
            // Verifica si el usuario y la contraseña coinciden.
            if (jugadorConsulta.getJugador().equals(jugador) && jugadorConsulta.getContraseña().equals(contraseña)) {
                return true; // Retorna verdadero si la autenticación es exitosa.
            } else {
                return false; // Retorna falso si la contraseña no coincide.
            }
        } else {
            return false; // Retorna falso si el jugador no existe.
        }
    }

    // Método para insertar un nuevo jugador.
    public static boolean insertar(Jugador jugador) {
        return jugadordao.insertar(jugador); // Llama al método de insertar en JugadorDAO.
    }

    // Método para modificar un jugador existente.
    public static boolean modificar(Jugador jugador) {
        return jugadordao.modificar(jugador); // Llama al método de modificar en JugadorDAO.
    }

    // Método para eliminar un jugador por su nombre de usuario.
    public static boolean eliminar(String jugador) {
        return jugadordao.eliminar(jugador); // Llama al método de eliminar en JugadorDAO.
    }

    // Método para obtener un jugador por su nombre de usuario.
    public static Jugador obtener(String jugador) {
        return jugadordao.obtener(jugador); // Llama al método de obtener en JugadorDAO.
    }
}
