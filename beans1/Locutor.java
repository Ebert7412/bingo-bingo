/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.beans1;

/**
 *
 * @author ASUS
 */
import java.util.ArrayList;
import modelo.beans1.Jugador;
public class Locutor{
    private Tambor tambor;
    private ArrayList<Jugador> listaJugadores;
    String cartonGan;
    String ganador;
    public Locutor(){
        tambor = new Tambor();
        listaJugadores = new ArrayList<>();

    }

    public int anunciarBol(){
        int res = tambor.sacarBol();
        return res;
    }

    public void registrar(Jugador inscrito){
        listaJugadores.add(inscrito);
    }

    public boolean hayGan(){
        return hayGan(0);
    }

    private boolean hayGan(int pos){
        int numJug = listaJugadores.size();
        boolean res = false;
        if(numJug > pos){
            if(listaJugadores.get(pos).cantarBingo()){
                res = true;
            }
            else{
                res = hayGan(pos + 1);
            }
        }else{}
        return res;
    }

    public void iniciarJuego(){
        iniciarJuego(0,0);
    }

    private void iniciarJuego(int pos,int ultBol){
        int numJug = listaJugadores.size();
        if(numJug -1 < pos){
            iniciarJuego(0,tambor.sacarBol());
        }else{
            listaJugadores.get(pos).marcarCasilla(ultBol);
            if(hayGan()){
                ganador = listaJugadores.get(pos).getNombre() + " ganó el juego.";
                cartonGan = listaJugadores.get(pos).cartonGan(pos);
                System.out.println(listaJugadores.get(pos).getNombre() +" ganó el juego");
            }else{
                iniciarJuego(pos + 1, ultBol);
            }
        }
    }
    public String getCartonGan(){
        return cartonGan;
    }
    public String getGanador(){
        return ganador;
    }
}