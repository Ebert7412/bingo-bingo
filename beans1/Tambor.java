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
public class Tambor{
    private int cantBol;
    private ArrayList<Bolillo> listBolSac;
    private int ultBolSac;
    public Tambor(){
        cantBol = 90;
        listBolSac = new ArrayList<Bolillo>();
        ultBolSac = 0;
    }

    public int sacarBol(){
        int numBol = (int)(Math.random()*(91));
        ultBolSac = numBol;
        ArrayList<Bolillo> listAux = new ArrayList<Bolillo>();
         if(listBolSac.equals(listAux)){
            Bolillo bolillo = new Bolillo(numBol);
            listBolSac.add(bolillo);
        }else{
            if(bolRep()){
                numBol = sacarBol();
            }else{
                if(numBol == 0){
                    numBol = sacarBol();
                }else{
                    Bolillo bolillo = new Bolillo(numBol);
                    listBolSac.add(bolillo);
                }
            }
        }
        return numBol;
    }
    //elimina nro repetivos
    public boolean bolRep(){
        boolean res = false;
        res = bolRep(0,false);
        return res;
    }

    private boolean bolRep(int pos,boolean res){
        if(res){
            res = true;
        }
        else{
            if(pos>= listBolSac.size()){
                res = false;
            }else{
                res = listBolSac.get(pos).getNumero() == ultBolSac;
                res = bolRep(pos+1,res);
            }
        }
        return res;
    }

    public int getUltBolSac(){
        return ultBolSac;
    }

    public void verifBol(){
        System.out.print(listBolSac);

    }
}