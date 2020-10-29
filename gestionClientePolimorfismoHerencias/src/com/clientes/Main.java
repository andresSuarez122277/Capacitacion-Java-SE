package com.clientes;

import com.clases.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String menu =
                        "         * 1 Agregar cliente\n" +
                        "         * 2 Editar cliente\n" +
                        "         * 3 Eliminar cliente\n" +
                        "         * 4 Agregar productos\n" +
                        "         * 5 Consultar clientes con documento y tipo de documento \n" +
                        "         * 0 salir de la aplicacion";
        Scanner in = new Scanner(System.in);

        List<Clientes> clientes = new ArrayList<>();
        List<Producto> productos = new ArrayList<>();

        //Uso clico do while() para iniciar menu
        @Deprecated(since = "1.2", forRemoval = true)
        String opMenu = "0";
        Clientes cli;

        do {

            System.out.println(menu);
            opMenu = in.nextLine();
            switch (opMenu.toString()) {
                case "1":
//Agregar cliente
                    System.out.print("Ingrese el nombre:  ");
                    String nombre = in.nextLine();
                    String tipDoc = "";
                    // Ciclo para confirmar el tipo de documento ingresado
                    do {
                        System.out.print("Ingrese el tipo de documento: CC / NIT.  ");
                        tipDoc = in.nextLine().toUpperCase();
                        if(!tipDoc.equals("CC") && !tipDoc.equals("NIT"))
                            System.out.println("Tipo de documento inválido !");
                        else
                            break;
                    }while(!tipDoc.equals("CC") && !tipDoc.equals("NIT"));
                    System.out.print("Ingrese el número de documento:  ");
                    String documento = in.nextLine();
                    System.out.print("Ingrese el número de teléfono:  ");
                    String telefono = in.nextLine();
                    System.out.print("Ingrese la dirección:  ");
                    String direccion = in.nextLine();

                    cli = new Clientes();
                    // Se evalúa el tipo de documento para determinar si crear una instancia de Persona o Empresa
                    if (tipDoc.equals("CC")){
                        System.out.print("Ingrese el número de celular:  ");
                        String celular = in.nextLine();
                        cli = new Personas(tipDoc,documento,nombre,telefono,direccion,celular);
                    }else if (tipDoc.equals("NIT")){
                        System.out.print("Ingrese el nombre del representante:  ");
                        String representante = in.nextLine();
                        cli = new Empresas(tipDoc,documento,nombre,telefono,direccion,representante);
                    }

                    System.out.println("\nDesea agregar productos a su lista ? 1.Si");
                    String comprar = in.nextLine();
                    if(comprar.equals("1"))
                        comprarProducto(productos, cli);

                    clientes.add(cli);
                    System.out.println("Cliente registrado !\n");
                    break;
                case "2":
//Modificar Cliente
                    cli = buscarCliente(clientes);

                    if (cli != null) {
                        System.out.print("Nombre actual " + cli.getNombre() + ", Ingrese el nuevo nombre:  ");
                        cli.setNombre(in.nextLine());
                        System.out.print("Tipo de documento actual " + cli.getTipoDoc() + ", Ingrese el nuevo tipo de documento: CC / NIT  ");
                        cli.setTipoDoc(in.nextLine().toUpperCase());
                        System.out.print("Número de documento actual " + cli.getDocumento() + ", Ingrese el número de documento:  ");
                        cli.setDocumento(in.nextLine());
                        System.out.print("Número de teléfono actual " + cli.getTelefono() + ", Ingrese el nuevo número de teléfono:  ");
                        cli.setTelefono(in.nextLine());
                        System.out.print("Dirección actual " + cli.getDireccion() + ", Ingrese la nueva dirección:  ");
                        cli.setDireccion(in.nextLine());
                        int index = clientes.indexOf(cli);

                        if (cli instanceof Personas) {
                            Personas per = (Personas) cli;
                            System.out.print("Número de celular actual " + per.getCelular() + ", Ingrese el número de celular:  ");
                            per.setCelular(in.nextLine());
                            clientes.set(index, per);
                        } else if (cli instanceof Empresas) {
                            Empresas emp = (Empresas) cli;
                            System.out.print("Nombre del representante actual " + emp.getRepresentante() + ", Ingrese el nombre del representante:  ");
                            emp.setRepresentante(in.nextLine());
                            clientes.set(index, emp);
                        }
                        System.out.println("\nDesea agregar productos a su lista ? 1.Si");
                        comprar = in.nextLine();
                        if(comprar.equals("1"))
                            comprarProducto(productos, cli);
                        System.out.println("Cliente modificado !");
                    }else{
                        System.out.println("Cliente no encontrado !");
                    }

                    break;
                case "3":
//Eliminar Cliente
                    cli = buscarCliente(clientes);
                    if (clientes.remove(cli))
                        System.out.println("\nCliente eliminado exitosamente !");
                    else
                        System.out.println("\nCliente no encontrado");
                    break;
                case "4":
//Crear Producto
                    String opcionProd = "1";
                    do {
                        System.out.println("--Nuevo producto--");
                        Producto producto = new Producto();

                        producto.generateId();
                        System.out.print("Ingrese el nombre:  ");
                        producto.setNombre(in.nextLine());
                        System.out.print("Ingrese las características:  ");
                        producto.setCarateristicas(in.nextLine());
                        System.out.print("Ingrese las condiciones:  ");
                        producto.setCondiciones(in.nextLine());

                        productos.add(producto);

                        System.out.println("\nIngresar otro producto ? 1=Si");
                        opcionProd = in.nextLine();
                    }while(opcionProd.equals("1"));
                    break;
                case "5":
// Buscar Cliente
                    cli = buscarCliente(clientes);
                    if(cli != null) {

                        System.out.println("\n\tDatos del cliente");
                        System.out.println(cli.toString());
                        System.out.println(cli.getProductos());
                    }else
                        System.out.println("Cliente no encontrado !");
                    break;
                case "0":
                    System.out.println("Muchas gracias por usar nuestra app, hasta luego");
                    break;
                default:
                    System.out.println("El valor ingresado no es una opcion de menu");
                    break;
            }
        } while (!opMenu.equals("0"));
        in.close();

    }

    public static void comprarProducto(List<Producto> productos, Clientes cli) {
        Scanner in = new Scanner(System.in);
        if (productos.size() != 0){
            System.out.println("\nTenemos existencias para los siguientes:");
            int i=1;
            //Lista todos los productos almacenados
            for (Producto pro : productos){
                System.out.println("Producto Nro."+i);
                System.out.println(pro.toString());
                i++;
            }

            int opcionProd = -1;
            //Asigna al cliente el producto elegido, uno a la vez hasta que desee salir
            do{
                System.out.println("Ingrese el Número del producto que desea añadir a su lista ó '0' para salir");
                try{
                    opcionProd = Integer.valueOf(in.nextLine())-1;
                    if(opcionProd == -1)break;
                    // valida si el numero ingresado está en el rango de los productos enumerados
                    if(opcionProd >= 0 && opcionProd < productos.size()){
                        cli.addProductos(productos.get(opcionProd));
                        System.out.println("Producto añadido a la lista !");
                        opcionProd = -2;
                    }else{
                        System.out.println("Opción inválida");
                    }
                }catch(Exception e){ // en caso de que el valor ingresado no se numérico
                    System.out.println("Opción inválida");
                }
            }while(opcionProd != -1);
        }else
            System.out.println("\tNo hay Productos disponibles !");
    }

    public static Clientes buscarCliente(List<Clientes> clientes) {

        Scanner in = new Scanner(System.in);
        System.out.print("Ingrese el tipo de documento:  ");
        String tipDoc = in.nextLine().toUpperCase();
        System.out.print("Ingrese el número de documento:  ");
        String documento = in.nextLine();

        for (Clientes aux : clientes) {

            if(aux.getTipoDoc().equals(tipDoc) && aux.getDocumento().equals(documento)) {
                return aux;
            }
        }
        return null;
    }
}
