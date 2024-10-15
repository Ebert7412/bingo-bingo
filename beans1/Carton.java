/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.beans1;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Carton   
{
    private ArrayList<Casilla> fila1;
    private ArrayList<Casilla> fila2;
    private ArrayList<Casilla> fila3; 
    private int col;
    public ArrayList<Casilla> casillas;
    public Carton(){
        casillas = new ArrayList<Casilla>();
        fila1 = new ArrayList<>();
        fila2 = new ArrayList<>();
        fila3 = new ArrayList<>();
        col = 9;
    }

    private void generarCarton(int fichAzul, int fichRojo,int fichVerde){
        int i = 0 + fichAzul;
        int j = 9 + fichAzul;
        int num = (int)(Math.random()*(j-i+1)+i);
        Casilla casilla = new Casilla();
        casilla.setNum(num);
        if(fila1.size() == col){
            this.fila1 = fila1;

        }else{
            fichAzul += 10;
            fila1.add(casilla);
            generarCarton(fichAzul,fichRojo,fichVerde);
        }
        if(fichAzul != 1){
            fichAzul = fichAzul/fichAzul;
            generarCarton(fichAzul,fichRojo,fichVerde);
        }else{
            if(fila2.size() == col){
                this.fila2 = fila2;
            }else{
                i = 0 + fichRojo;
                j = 9 + fichRojo;
                num = (int)(Math.random()*(j-i+1)+i);
                casilla.setNum(num);
                fichRojo += 10;
                fila2.add(casilla);
                generarCarton(fichAzul, fichRojo,fichVerde);
            }
        }
        if(fichRojo != 1){
            fichRojo = fichRojo/ fichRojo;
            generarCarton(fichAzul,fichRojo,fichVerde);

        }else{
            if(fila3.size() == col){
                this.fila3 = fila3;
            }else{
                i = 0 + fichVerde;
                j = 9 + fichVerde;
                num = (int)(Math.random()*(j-i+1)+i);
                casilla.setNum(num);
                fichVerde += 10;
                fila3.add(casilla);
                generarCarton(fichAzul,fichRojo,fichVerde);
            }

        }
    }

    private void elimTabRep(int mov,boolean marcado){
        Casilla aux = new Casilla();
        if(marcado) {
            fila1.clear();
            fila2.clear();
            fila3.clear();
            generarTab();
        }else{if(mov >= col){;
                this.fila1 = fila1;
                this.fila2 = fila2;
                this.fila3 = fila3;
            }else{
                marcado = aux.compCasilla(fila1.get(mov), fila2.get(mov), fila3.get(mov));
                elimTabRep(mov + 1,marcado);
            }

        }
    }

    public void generarTab(){
        generarCarton(1,1,1);
        elimTabRep(0,false);

    }

    public void eliminarTablero( int contFila1, int contFila2, int contFila3){
        int fila = fila1.size();
        int elim = (int)(Math.random()*(col));
        if(contFila1 < 4){
            if(fila1.get(elim).getNum() == 0){
                eliminarTablero(contFila1,contFila2,contFila3);
            }else{
                fila1.get(elim).setEstado("Marcado");
                fila1.get(elim).setNum(0);
                eliminarTablero(contFila1 +1, contFila2, contFila3);}
        }else{
            if(contFila2 < 4){
            if(fila1.get(elim).getNum() == 0){
                eliminarTablero(contFila1,contFila2,contFila3);
            }else{
                fila2.get(elim).setEstado("Marcado");
                fila2.get(elim).setNum(0);
                eliminarTablero(contFila1 +1, contFila2 +1, contFila3);}
        }
            if(contFila3 < 4){
            if(fila1.get(elim).getNum() == 0){
                eliminarTablero(contFila1,contFila2,contFila3);
            }else{
                fila3.get(elim).setEstado("Marcado");
                fila3.get(elim).setNum(0);
                eliminarTablero(contFila1, contFila2, contFila3 + 1);}
        }
        }
    }

    public void marcarCarton(int num){
        marcarCarton(num, 0);
    }

    private void marcarCarton(int num,int mov){
        if(mov <= 8){
            if(fila1.get(mov).getNum() == num){
                fila1.get(mov).setEstado("Marcado");
            }else{
                if(fila2.get(mov).getNum() == num){
                    fila2.get(mov).setEstado("Marcado");
                }
                else{
                    if(fila3.get(mov).getNum() == num){
                        fila3.get(mov).setEstado("Marcado");
                    }
                    else{
                        marcarCarton(num,mov+1);
                    }}
            }
        }else{
        }
    }

    public boolean bingo(){
        return bingo(0);
    }

    private boolean bingo(int mov){
        boolean res= false;
        String aux = "Marcado";
        if(mov <= 8){
            if( (fila1.get(mov).getEstado() == aux && fila2.get(mov).getEstado() == aux) && fila3.get(mov).getEstado() == aux ){
                res = bingo(mov +1);
            }else{
                res = false;
            }}else{
            res=true;
        }
        return res;
    }
    public String mostrarCart(){
        String aux;
        aux = fila1 + "\n" + fila2 + "\n" + fila3;
        return aux;

    }
}