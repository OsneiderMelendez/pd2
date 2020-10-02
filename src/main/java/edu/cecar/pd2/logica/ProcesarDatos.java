/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cecar.pd2.logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ProcesarDatos {

    int contadorCantidadDatos = 0;
    int numeroPRocesadores = Runtime.getRuntime().availableProcessors();
    int cantidaMaximaDeProceso = 50000 * numeroPRocesadores;
    int archivoProcesado = 0;

    Map<LocalDate, BigDecimal> resultadosSumados = new TreeMap<LocalDate, BigDecimal>();

    public ProcesarDatos() {
        JOptionPane.showMessageDialog(null, "espera a que se procesen los datos");
        try {
            for (int i = 0; i < numeroPRocesadores; i++) {
                resultadosSumados = new TreeMap<LocalDate, BigDecimal>();
            }
            
            repartirDatos();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProcesarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "datos procesados");
    }

    private void repartirDatos() throws FileNotFoundException {
        Stack<LocalDate> anios = new Stack<LocalDate>();
        Stack<BigDecimal> importe = new Stack<BigDecimal>();

        for (File archivo : obtenerArchivos()) {

            if (archivo.isDirectory()) {
                continue;
            }

            try {
                BufferedReader br = new BufferedReader(new FileReader(archivo));

                String linea;
                br.readLine();

                while ((linea = br.readLine()) != null) {

                    String[] datos = linea.split(",");
                    LocalDate fechaAux = LocalDate.parse(datos[2], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    BigDecimal decimal = new BigDecimal(datos[3]);

                    if (contadorCantidadDatos >= cantidaMaximaDeProceso) {

                        contadorCantidadDatos = 0;

                        iniciarCalculos(anios, importe);

                        //anios.clear();
                        //importe.clear();
                    }
                    contadorCantidadDatos++;
                    anios.add(fechaAux);
                    importe.add(decimal);

                }

            } catch (IOException ex) {
                Logger.getLogger(ProcesarDatos.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        

        while (!anios.isEmpty()) {
            //System.out.println("tam: "+anios.size()+"core: "+numeroCore);
            LocalDate key = anios.pop();
            BigDecimal impor = importe.pop();
            if (resultadosSumados.containsKey(key)) {
                BigDecimal aux = resultadosSumados.get(key);
                aux = aux.add(impor);
                resultadosSumados.put(key, aux);
            } else {
                resultadosSumados.put(key, impor);
            }

        }
        

        for (LocalDate localDate : resultadosSumados.keySet()) {
            System.out.println("anio: " + localDate + " - " + resultadosSumados.get(localDate));
        }
        

    }

    public void iniciarCalculos(Stack<LocalDate> fecha, Stack<BigDecimal> decimal) {

        Hilo[] hilos = new Hilo[numeroPRocesadores];
        Thread[] ejecutorHilo = new Thread[numeroPRocesadores];
        int tamPaque = cantidaMaximaDeProceso / numeroPRocesadores;

        for (int i = 0; i < numeroPRocesadores; i++) {

            Stack fechaAux = new Stack<LocalDate>();
            Stack importeAux = new Stack<BigDecimal>();

            for (int j = 0; j < tamPaque; j++) {
                fechaAux.add(fecha.pop());
                importeAux.add(decimal.pop());
            }

            hilos[i] = new Hilo(numeroPRocesadores, fechaAux, importeAux);
            ejecutorHilo[i] = new Thread(hilos[i]);
            ejecutorHilo[i].start();

        }
        for (int i = 0; i < numeroPRocesadores; i++) {
            try {
                ejecutorHilo[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(ProcesarDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        for (Hilo hilo : hilos) {

            for (LocalDate key : hilo.getResultado().keySet()) {
                if (resultadosSumados.containsKey(key)) {
                    BigDecimal aux = resultadosSumados.get(key);
                    aux = aux.add(hilo.getResultado().get(key));

                    resultadosSumados.put(key, aux);

                } else {
                    resultadosSumados.put(key, hilo.getResultado().get(key));
                }
            }

        }
       
    }

    private File[] obtenerArchivos() {

        File carpetaContenedora = new File("src\\main\\java\\edu\\cecar\\pd2\\documentos");

        /*for (File archivo : carpetaContenedora.listFiles()) {
            System.out.println(archivo.getName());
            
        }*/
        return carpetaContenedora.listFiles();
    }

    public Map<LocalDate, BigDecimal> getResultadosSumados() {
        return resultadosSumados;
    }
    
    

    

}
