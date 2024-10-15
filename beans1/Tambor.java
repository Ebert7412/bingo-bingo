/*
 * Clase que representa un tambor que saca números para el juego.
 */
package modelo.beans1; // Paquete donde se encuentra la clase.

import java.util.ArrayList; // Importa la clase ArrayList.

public class Tambor { // Definición de la clase Tambor.
    private int cantBol; // Cantidad total de bolillos (90).
    private ArrayList<Bolillo> listBolSac; // Lista de bolillos ya sacados.
    private int ultBolSac; // Último bolillo sacado.

    // Constructor para inicializar el tambor.
    public Tambor() {
        cantBol = 90; // Establece la cantidad de bolillos.
        listBolSac = new ArrayList<Bolillo>(); // Inicializa la lista de bolillos sacados.
        ultBolSac = 0; // Inicializa el último bolillo sacado.
    }

    // Método para sacar un bolillo.
    public int sacarBol() {
        // Genera un número aleatorio entre 0 y 90.
        int numBol = (int)(Math.random() * (91));
        ultBolSac = numBol; // Actualiza el último bolillo sacado.
        ArrayList<Bolillo> listAux = new ArrayList<Bolillo>(); // Lista auxiliar vacía.

        // Comprueba si la lista de bolillos sacados está vacía.
        if (listBolSac.equals(listAux)) {
            // Si está vacía, agrega el bolillo a la lista.
            Bolillo bolillo = new Bolillo(numBol);
            listBolSac.add(bolillo);
        } else {
            // Verifica si el bolillo ya ha sido sacado.
            if (bolRep()) {
                // Si ya fue sacado, llama al método de nuevo para sacar otro.
                numBol = sacarBol();
            } else {
                // Si el bolillo es 0, también vuelve a sacar.
                if (numBol == 0) {
                    numBol = sacarBol();
                } else {
                    // Agrega el bolillo a la lista de bolillos sacados.
                    Bolillo bolillo = new Bolillo(numBol);
                    listBolSac.add(bolillo);
                }
            }
        }
        return numBol; // Devuelve el número del bolillo sacado.
    }

    // Método para verificar si el bolillo ya ha sido sacado.
    public boolean bolRep() {
        boolean res = false; // Inicializa el resultado.
        res = bolRep(0, false); // Llama al método privado para verificar.
        return res; // Devuelve el resultado.
    }

    // Método privado recursivo para verificar si el bolillo es repetido.
    private boolean bolRep(int pos, boolean res) {
        if (res) {
            res = true; // Si ya hay un resultado, se mantiene verdadero.
        } else {
            // Verifica si se ha llegado al final de la lista.
            if (pos >= listBolSac.size()) {
                res = false; // No se encontró un repetido.
            } else {
                // Compara el número actual con el último sacado.
                res = listBolSac.get(pos).getNumero() == ultBolSac;
                res = bolRep(pos + 1, res); // Llama recursivamente.
            }
        }
        return res; // Devuelve si hay repetidos o no.
    }

    // Método para obtener el último bolillo sacado.
    public int getUltBolSac() {
        return ultBolSac; // Devuelve el último bolillo.
    }

    // Método para mostrar los bolillos sacados.
    public void verifBol() {
        System.out.print(listBolSac); // Imprime la lista de bolillos.
    }
}
