/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cecar.pd2.logica;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Consulta {

ProcesarDatos  procesarDatos = new ProcesarDatos();


public  String importeTotal(){
    
BigDecimal aux = BigDecimal.ZERO;

    for (LocalDate localDate : procesarDatos.getResultadosSumados().keySet()) {
        
       aux= aux.add(procesarDatos.getResultadosSumados().get(localDate));
    }
    
    return aux.toString();
}


public String importeAnioMes(int anio, int mes){
    
    
    BigDecimal aux = BigDecimal.ZERO;

    for (LocalDate localDate : procesarDatos.getResultadosSumados().keySet()) {
        if(localDate.getYear()==anio && localDate.getMonthValue()==mes){
             aux= aux.add(procesarDatos.getResultadosSumados().get(localDate));
        }
    }
    
    return aux.toString();
    
}

public String importeAni(int anio){
    
    
    BigDecimal aux = BigDecimal.ZERO;

    for (LocalDate localDate : procesarDatos.getResultadosSumados().keySet()) {
        if(localDate.getYear()==anio){
             aux= aux.add(procesarDatos.getResultadosSumados().get(localDate));
        }
    }
    
    return aux.toString();
    
}


public String importeTrimestre(int anio, int trimestre){
    
    
    BigDecimal aux = BigDecimal.ZERO;

    for (LocalDate localDate : procesarDatos.getResultadosSumados().keySet()) {
        if(localDate.getYear()==anio && (localDate.getMonthValue()>trimestre*3-3 && localDate.getMonthValue()<=trimestre*3 )){
             aux= aux.add(procesarDatos.getResultadosSumados().get(localDate));
        }
    }
    
    return aux.toString();
    
}
    
}
