package com.company;

import clases.CapacidadEndedudamiento;
import clases.Mensajes;
import javafx.scene.input.KeyCode;

import java.util.Scanner;

public class Main {
    //Recuerda que aca empieza todo
    public static void main(String[] args) {
        //Con este objeto de la clase Scanner puedes capturar informacion por consola cada ves que lo uses
        // recuerda cerrar el flujo de consulta cada ves lo uses sobre para que los uses in.close()
        Scanner in = new Scanner(System.in);

        int ingMesuales = -1, gastosFijos = -1, gastosVbles = -1, bandera = 0;
        String valorIn;

        String entrada = "SI";
        while (entrada.equals("SI")) {

            if(entrada.equals("SI") && (ingMesuales != -1 | gastosFijos != -1 | gastosVbles != -1 | bandera != 0)) {
                System.out.println(Mensajes.continuar());
                if(!in.next().toUpperCase().equals("SI"))break;
            }

            if(ingMesuales == -1) {
                System.out.println(Mensajes.ingMensuales());
                valorIn = in.next();
                if (isNumeric(valorIn)) {
                    ingMesuales = Integer.parseInt(valorIn);
                    entrada = "NO";
                    bandera = 0;
                } else {
                    System.out.println(Mensajes.noNumerico());
                    entrada = "SI";
                    bandera = 1;
                    continue;
                }
            }

            if(gastosFijos == -1) {
                System.out.println(Mensajes.gastosFijos());
                valorIn = in.next();
                if (isNumeric(valorIn)) {
                    gastosFijos = Integer.parseInt(valorIn);
                    entrada = "NO";
                } else {
                    System.out.println(Mensajes.noNumerico());
                    entrada = "SI";
                    continue;
                }
            }

            if(gastosVbles == -1) {
                System.out.println(Mensajes.gastosVbles());
                valorIn = in.next();
                if (isNumeric(valorIn)) {
                    gastosVbles = Integer.parseInt(valorIn);
                    entrada = "NO";
                } else {
                    System.out.println(Mensajes.noNumerico());
                    entrada = "SI";
                    continue;
                }
            }

            //Esto te dara la primera entrada al proceso de solicitar los datos para instancir nuestro objeto
            // CapacidadEndedudamiento()
            //Valida las entradas de los usuarios que no vayas a convertir una "A" numero y el calculo no te funcione
            //Utiliza el metodo is numeric para vada entrada de ser necesarios
        }
        in.close();

        if(entrada.equals("NO")) {
            CapacidadEndedudamiento capEnd = new CapacidadEndedudamiento();
            capEnd.setIngresosTotales(ingMesuales);
            capEnd.setGastosFijos(gastosFijos);
            capEnd.setGastoVaribales(gastosVbles);

            System.out.println(Mensajes.resultado() + capEnd.getCapacidadEndeudamiento());
        }else
            System.out.println("Adios !");

    }

    public static boolean isNumeric(String value) {
        // implementa un bloque try catch aca
        try {
            Double.parseDouble(value);
            return true;
        }catch(Exception e){
            return false;
        }

    }
}
