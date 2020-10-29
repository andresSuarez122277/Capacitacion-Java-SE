package com.clientes;

import com.clases.BeneficiosCovid19;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<BeneficiosCovid19> lista1 = new ArrayList();
        List<BeneficiosCovid19> lista2 = new ArrayList();

        Scanner in = new Scanner(System.in);

        String opcion = "SI";
        boolean bandera = true;

        do {
            //Permanece en el ciclo mientras el usuario acepte ingresar beneficios
            System.out.print("Desea ingresar un Beneficio ? Si / No  ");
            opcion = in.nextLine().toUpperCase();
            if(!opcion.equals("SI"))
                break;

            System.out.print("Ingrese el valor del subsidio: ");
            String valor = in.nextLine();
            Float num;
            // Se evalúa si el valor ingresado es numérico con el método 'esNumerico'
            if(esNumérico(valor)){
                num = Float.valueOf(valor);
            }else{
            // Si el valor del subsidio no es numérico salta al bloque de control del ciclo volviendo al inicio.
                continue;
            }
            System.out.print("Ingrese el nombre del beneficio: ");
            String nombre = in.nextLine();

            // Se crea una instancia de la clase y se modifican sus atributos con los valores ingresados.
            BeneficiosCovid19 nuevo = new BeneficiosCovid19();
            nuevo.setId(getIdBeneficio());
            nuevo.setNombre(nombre);
            nuevo.setValorSubsidio(num);

            // Se ingresa alternadamente los objetos creados a una de las dos listas.
            if(bandera == true) {
                lista1.add(nuevo);
                bandera = false;
            }else{
                lista2.add(nuevo);
                bandera = true;
            }
            System.out.println("\tBeneficio almacenado !!\n");
        }while(opcion.equals("SI"));

        // Se envían las listas al método para encontrar el mejor beneficio y presentarlo en pantalla
        informeMejorBeneficios(lista1, lista2);
    }

    // Método para obtener un valor numérico aleatorio para cada beneficio almacenado
    private static String getIdBeneficio(){
        // Se obtiene un aleatorio entre 100000 y 999999, se toma su parte entera y se entrega de tipo cadena
        String aleatorio = String.valueOf(Double.valueOf(Math.random() * (999999 - 100000 + 1) + 100000).intValue());
        return aleatorio;
    }

    // método que recorre una lista para hallar el objeto con el subsidio mas grande.
    public static BeneficiosCovid19 getMejorbeneficios(List<BeneficiosCovid19> lista){
        BeneficiosCovid19 aux = lista.get(0);

        if(lista.size() > 1) {
            float subsidio = 0f;
            for (BeneficiosCovid19 beneficio : lista) {
                float valor = (float) beneficio.getValorSubsidio();

                if (valor > subsidio) {
                        subsidio = valor;
                        aux = beneficio;
                }
            }
        }
        return aux;
    }

    public static boolean esNumérico(String dato){
        try{
            Float.parseFloat(dato);
            return true;
        }catch (Exception e){
            System.out.println("El valor ingresado no es numérico");
            return false;
        }
    }

    public static void informeMejorBeneficios(List<BeneficiosCovid19> lista1, List<BeneficiosCovid19> lista2){
        // Verifica que las listas tengan objetos para comparar sus atributos
        if(lista1.size() == 0 && lista2.size() == 0)
            System.out.println("No hay beneficios almacenados. Por favor ingrese alguno.");
        else if (lista1.size() != 0 || lista2.size() != 0){
            //si la lista tiene objetos hace la búsqueda del mejor beneficio, de lo contrario asigna null
            BeneficiosCovid19 mejor1 = (lista1.size() != 0) ? getMejorbeneficios(lista1) : null;
            BeneficiosCovid19 mejor2 = (lista2.size() != 0) ? getMejorbeneficios(lista2) : null;

            // Si uno de los dos objetos es null, muestra los atributos del otro como el Mejor beneficio
            if(mejor1 == null){
                System.out.println("Mejor beneficio Covid19 es..."
                        +"\nCódigo:  "+mejor2.getId()
                        +"\nNombre:  "+mejor2.getNombre()
                        +"\nValor del subsidio: "+mejor2.getValorSubsidio());
            }else if (mejor2 == null){
                System.out.println("Mejor beneficio Covid19 es..."
                        +"\nCódigo:  "+mejor1.getId()
                        +"\nNombre:  "+mejor1.getNombre()
                        +"\nValor del subsidio: "+mejor1.getValorSubsidio());
                // compara entre los mejores beneficios de las dos listas
            }else if(mejor1.getValorSubsidio().floatValue() > mejor2.getValorSubsidio().floatValue()){
                System.out.println("Mejor beneficio Covid19 es..."
                        +"\nCódigo:  "+mejor1.getId()
                        +"\nNombre:  "+mejor1.getNombre()
                        +"\nValor del subsidio: "+mejor1.getValorSubsidio());
            }else{
                System.out.println("Mejor beneficio Covid19 es..."
                        +"\nCódigo:  "+mejor2.getId()
                        +"\nNombre:  "+mejor2.getNombre()
                        +"\nValor del subsidio: "+mejor2.getValorSubsidio());
            }
        }
    }
}
