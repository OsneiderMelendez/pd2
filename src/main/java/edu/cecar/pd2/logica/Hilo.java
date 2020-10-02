/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cecar.pd2.logica;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Hilo implements Runnable {

    int numeroCore;

    Stack<LocalDate> anios ;
    Stack<BigDecimal> importe;
    Map<LocalDate, BigDecimal> resultado = new TreeMap<LocalDate, BigDecimal>();

    public Hilo(int numeroCore, Stack<LocalDate> anios, Stack<BigDecimal> importe) {
        this.numeroCore = numeroCore;
        this.anios = anios;
        this.importe = importe;
    }
    

    @Override
    public void run() {
               
        while (!anios.isEmpty()) {
            //System.out.println("tam: "+anios.size()+"core: "+numeroCore);
            LocalDate key = anios.pop();
            BigDecimal importe = this.importe.pop();
            if (resultado.containsKey(key)) {
                BigDecimal aux = resultado.get(key);
                aux = aux.add(importe);
                resultado.put(key, aux);
            } else {
                resultado.put(key, importe);
            }

        }
        
    }

    public Map<LocalDate, BigDecimal> getResultado() {
        return resultado;
    }
    
    

}
