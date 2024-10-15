/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.beans1;

import java.util.ArrayList;
import modelo.beans1.Carton;

import javax.swing.JOptionPane;
/**
 *
 * @author ASUS
 */
 public class Jugador{
    private int montDin;
    private String nombre;
    private ArrayList<Carton> listaCart;
    private String jugador;
    private String contraseña;
    public Jugador(int montDin, String nombre, String jugador, String contraseña){
        this.montDin = montDin;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.jugador = jugador;
        listaCart = new ArrayList<Carton>();
    }
    
  

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }


    public String getJugador() {
        return jugador;
    }

    public String getContraseña() {
        return contraseña;
    }
    public int getMontDin(){
        return montDin;
    }
    public void setMontDin(int dinero){
        montDin = dinero;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre= nombre;
    }

    
    public void eliminarCart(){
        listaCart = new ArrayList<Carton>();
    }
    public String comprarCarton(){
        String res;
        Carton carton;
        if(montDin>10){
            this.montDin -= 10;
            carton = new Carton();
            carton.generarTab() ;
            res = "Carton comprado exitosamente";
            listaCart.add(carton);
        }else{
            res = "No tienes suficiente dinero, vuelva mas tarde";
        }
        return res;
    }
    public ArrayList<Carton> getLista(){
        return listaCart;
    }
    public String cartonGan(int num){
        return  "Ganó con el carton: \n " + listaCart.get(num).mostrarCart();
    }
    public void marcarCasilla(int num){
        marcarCasilla(num,0);
    }
    private void marcarCasilla(int num,int mov){
        int numCart = listaCart.size();
        if(numCart - 1 >mov){
            listaCart.get(mov).marcarCarton(num);
            marcarCasilla(num,mov +1);
        }else{}
    }
    public boolean cantarBingo(){
        return cantarBingo(0);
    }
    private boolean cantarBingo(int mov){
        int numCart = listaCart.size();
        boolean res = false;
        if(numCart - 1>mov){
            if(listaCart.get(mov).bingo()){
                res = true;
            }else{
                res = cantarBingo(mov +1);
            }
        }else{
            res = false;
        }
        return res;
    }
    
}