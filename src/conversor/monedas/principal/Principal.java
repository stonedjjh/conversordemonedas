package conversor.monedas.principal;


import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import conversor.monedas.conexion.ConexionApi;
import conversor.monedas.modelos.Archivo;
import conversor.monedas.modelos.Momento;
import conversor.monedas.modelos.Monedas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Principal {
    public static void main(String[] args) {
        Monedas monedas = new Monedas();
        ConexionApi conexion = new ConexionApi();
        Scanner teclado = new Scanner(System.in);
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        Archivo miArchivo = new Archivo();
        Momento tiempoActual = new Momento();
        System.out.println("Bienvenidos a Stone Exchange es un placer servirle");
        while (true){
            System.out.println("Presione 1 para obtener una lista de monedas\n" +
                    "Presione 2 para obtener informacion sobre una moneda\n" +
                    "Presione 3 para realizar una conversion entre monedas\n" +
                    "Presione 4 para mostrar historial de transacciones\n" +
                    "Presione 5 para eliminar historico\n" +
                    "Presione 6 para salir");
            try
            {
                int opcion = teclado.nextInt();
                if(opcion==6)
                    break;
                switch (opcion) {
                    case 1: {
                        monedas.listarMonedas();
                        break;
                    }
                    case 2: {
                        System.out.println("Ingrese el codigo de la moneda a buscar");
                        String codigoMoneda = teclado.next();
                        String resultado = monedas.buscar(codigoMoneda);
                        if (resultado!=null){
                            System.out.println(resultado);
                            miArchivo.agregarEntrada(tiempoActual.getFechayHora()+" - "+
                            "Se consulto la moneda: "+codigoMoneda + "\n");
                        }
                        else
                            System.out.println("Moneda no encontrada");
                        break;
                    }
                    case 3: {
                        System.out.println("Ingrese el codigo de la moneda base");
                        String codigoBase = teclado.next();
                        System.out.println("Ingrese el codigo de la moneda a convertir");
                        String codigoMoneda = teclado.next();
                        System.out.println("Ingrese el monto a convertir");
                        double cantidad = teclado.nextDouble();
                        String mensaje = conexion.convertir(codigoBase, codigoMoneda, cantidad, gson);
                        System.out.println(mensaje);
                        miArchivo.agregarEntrada(tiempoActual.getFechayHora()+" - "+
                                "Se hizo la conversion de: " + mensaje + "\n");
                        break;
                    }
                    case 4: {
                        try (FileReader lector = miArchivo.leerRegistros();
                            BufferedReader buffer = new BufferedReader(lector)) {
                                String linea;
                                while ((linea = buffer.readLine()) != null) {
                                    System.out.println(linea);
                                }
                        } catch (IOException e) {
                            System.out.println("Ocurrió un error al leer el archivo.");
                        }
                        break;
                    }
                    case 5: {
                        miArchivo.reiniciarArchivo();
                        System.out.println("Registro reiniciado");
                        break;
                    }
                    default: {
                        System.out.println("Opcion invalida intente de nuevo");
                    }
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    /*    monedas.listarMonedas();
        System.out.println(monedas.buscar("USD"));
        System.out.println(monedas.buscar("VEF"));
        System.out.println(monedas.buscar("VES"));
        String resultado = conexion.convertir("USD", "EUR", 15, gson);
        System.out.println(resultado);*/


    }
}

