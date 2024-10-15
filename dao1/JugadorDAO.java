/*
 * Clase para manejar la persistencia de los jugadores en una lista.
 */
package modelo.dao1; // Paquete donde se encuentra la clase.

import java.util.ArrayList; // Importa la clase ArrayList.
import java.util.List; // Importa la interfaz List.
import modelo.beans1.Jugador; // Importa la clase Jugador.

public class JugadorDAO { // Definición de la clase JugadorDAO.
    
    private List<Jugador> jugadores; // Lista para almacenar jugadores.

    // Constructor para inicializar la lista de jugadores.
    public JugadorDAO() {
        jugadores = new ArrayList<>(); // Inicializa la lista.
    } 

    // Método para buscar un jugador por su nombre de usuario.
    public int buscar(String usuario) {
        int n = -1; // Inicializa el índice como -1 (no encontrado).
        // Itera sobre la lista de jugadores.
        for (int i = 0; i < jugadores.size(); i++) {
            // Comprueba si el jugador coincide con el usuario buscado.
            if (jugadores.get(i).getJugador().equals(usuario)) {
                n = i; // Guarda el índice del jugador encontrado.
                break; // Sale del bucle.
            }
        }
        return n; // Devuelve el índice o -1 si no se encontró.
    }

    // Método para insertar un nuevo jugador en la lista.
    public boolean insertar(Jugador jugador) {
        // Solo inserta si el jugador no existe ya en la lista.
        if (buscar(jugador.getJugador()) == -1) {
            jugadores.add(jugador); // Agrega el jugador.
            return true; // Retorna verdadero si se agregó.
        } else {
            return false; // Retorna falso si el jugador ya existe.
        }
    }

    // Método para modificar un jugador existente.
    public boolean modificar(Jugador jugador) {
        // Solo modifica si el jugador existe.
        if (buscar(jugador.getJugador()) != -1) {
            Jugador jugadoraux = obtener(jugador.getJugador()); // Obtiene el jugador.
            // Actualiza la contraseña y el nombre del jugador.
            jugadoraux.setContraseña(jugador.getContraseña());
            jugadoraux.setNombre(jugador.getNombre());
            return true; // Retorna verdadero si se modificó.
        } else {
            return false; // Retorna falso si el jugador no existe.
        }
    }

    // Método para eliminar un jugador por su nombre de usuario.
    public boolean eliminar(String jugador) {
        // Solo elimina si el jugador existe.
        if (buscar(jugador) != -1) {
            jugadores.remove(buscar(jugador)); // Elimina el jugador.
            return true; // Retorna verdadero si se eliminó.
        } else {
            return false; // Retorna falso si el jugador no existe.
        }
    }
    
    // Método para obtener un jugador por su nombre de usuario.
    public Jugador obtener(String jugador) {
        // Solo obtiene si el jugador existe.
        if (buscar(jugador) != -1) {
            return jugadores.get(buscar(jugador)); // Devuelve el jugador encontrado.
        } else {
            return null; // Devuelve null si el jugador no existe.
        }
    }
}
