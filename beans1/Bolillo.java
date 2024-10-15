/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.beans1;

public class Bolillo{
    private String color;
    private String simbolo;
    private int numero;
    public Bolillo(String color, String simbolo){
        this.color = color;
        this.simbolo = simbolo;
    }
    public Bolillo(int numero){
        this.numero = numero;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public String getSimbolo(){
        return simbolo;
    }
    public void setSimbolo(String simbolo){
        this.simbolo = simbolo;
    }
    public int getNumero(){
        return numero;
    }
    public void setNumero(int numero){
        this.numero = numero;
    }
}


