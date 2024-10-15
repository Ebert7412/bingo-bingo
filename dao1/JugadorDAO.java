/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao1;

import java.util.ArrayList;
import java.util.List;
import modelo.beans1.Jugador;

/**
 *
 * @author ASUS
 */
public class JugadorDAO {
    
    private List<Jugador> jugadores;
    public JugadorDAO(){
        jugadores = new ArrayList<>();
    } 
    public int buscar(String usuario){
        int n = -1;
        for(int i = 0 ; i < jugadores.size();i++){
            if(jugadores.get(i).getJugador().equals(usuario)){
                n = i ;
                break;
            }
                }
        return n;
    }
    public boolean insertar(Jugador jugador){
        if(buscar(jugador.getJugador() )==-1){
            jugadores.add(jugador);
            return true;
        }else{
            return false;
        }
    }
    public boolean modificar(Jugador jugador){
         if(buscar(jugador.getJugador())!=-1){
            Jugador jugadoraux = obtener(jugador.getJugador());
            
            jugadoraux.setContraseña(jugador.getContraseña());
            jugadoraux.setNombre(jugador.getNombre());
            return true;
        }else{
            return false;
        }
    }
    public boolean eliminar(String jugador){
        if(buscar(jugador)!=-1){
           jugadores.remove(buscar(jugador));
            return true;
        }else{
            return false;
        }
    }
    
    public Jugador obtener(String jugador){
        if(buscar(jugador) != -1){
            return jugadores.get(buscar(jugador));
        }else{return null;}
    }
    
}
