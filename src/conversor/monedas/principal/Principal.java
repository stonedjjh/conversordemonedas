package conversor.monedas.principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import conversor.monedas.conexion.ConexionApi;
import conversor.monedas.monedas.Monedas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Monedas monedas = new Monedas();
        ConexionApi conexion = new ConexionApi();

        monedas.listarMonedas();
        System.out.println(monedas.buscar("USD"));
        System.out.println(monedas.buscar("VEF"));
        System.out.println(monedas.buscar("VES"));
        String resultado = conexion.convertir("USD", "EUR", 15);
        System.out.println(resultado);


    }
}

