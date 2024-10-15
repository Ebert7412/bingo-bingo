/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.beans1;

/**
 *
 * @author ASUS
 */
public class Casilla{
    private String estado;
    private int num;
    public Casilla(){
        num = 0;
        estado = "No marcado";
    }
    public Casilla(int num){
        this.num = num;
        estado = "No marcado";
    }
     public Casilla(int num, String estado){
        this.num = num;
        this.estado = estado;
    }
    public boolean compCasilla(Casilla a, Casilla b, Casilla c){
        boolean res = false;
        if(res){
        }else{
            res = (a.getNum() == b.getNum() || b.getNum() == c.getNum()) || a.getNum() == c.getNum();
        }
        return res;
    }
    
    public int getNum(){
        return num;
    }
    public void setNum(int num){
        this.num = num;
    }
    public String getEstado(){
    return estado;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
    @Override
    public String toString(){
        return "" + getNum();
    }
}