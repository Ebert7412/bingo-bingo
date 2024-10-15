/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic1;
import modelo.beans1.Jugador;
import modelo.dao1.JugadorDAO;
/**
 *
 * @author ASUS
 */
public class JugadorLogic {
    
    private static JugadorDAO jugadordao = new JugadorDAO();
    public static boolean autentificar(String jugador, String contraseña){
        if(obtener(jugador)!= null){
            Jugador jugadorConsulta = obtener(jugador);
            if(obtener(jugador).getJugador().equals(jugador)&& jugadorConsulta.getContraseña().equals(contraseña)){
            return true;
            }else{
            return false;
            }
        }else{
        return false;
        }
    }
    public static boolean insertar(Jugador jugador){
        return jugadordao.insertar(jugador) ;
    }
    public static boolean modificar(Jugador jugador){
        return jugadordao.modificar(jugador) ;
    }
    public static boolean eliminar(String jugador){
        return jugadordao.eliminar(jugador);
    }
    public static Jugador obtener(String jugador){
        return jugadordao.obtener(jugador);
    }
}
