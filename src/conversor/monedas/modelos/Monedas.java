package conversor.monedas.modelos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Monedas {
    private String rutaArchivo = "src/monedas.txt";
    private File archivo = new File(this.rutaArchivo);
    private Scanner scanner = null;
    private List<Moneda> monedas = new ArrayList<>();


    public Monedas(){
        try {
            scanner = new Scanner(archivo);
            while (scanner.hasNext()) {
                String linea = scanner.nextLine();
                String[] valores = linea.split("\t");
                monedas.add(new Moneda(valores[0],valores[1],valores[2]));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: El archivo no fue encontrado: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    public String buscar(String codigoMoneda) {
        for (Moneda moneda : this.monedas) {
            if (moneda.getCodigoMoneda().equalsIgnoreCase(codigoMoneda)) {
                return moneda.toString(); // Retorna el objeto Moneda si se encuentra una coincidencia
            }
        }
        return null; // Retorna null si no se encuentra ninguna moneda con el código dado
    }

    public void listarMonedas (){
        StringBuilder sb = new StringBuilder(); // Usamos StringBuilder para eficiencia
        int contador = 0;
        for (Moneda moneda : monedas) {
            sb.append(moneda.getCodigoMoneda());
            contador++;
            if (contador!=20)
                sb.append(" "); // Agregamos un espacio después de cada código
            else{
                contador=0;
                sb.append("\n");
            }

        }
        // Imprimimos la cadena resultante (eliminando el espacio extra al final si lo hay)
        if (sb.length() > 0) {
            System.out.println(sb.toString().trim());
        } else {
            System.out.println("La lista de monedas está vacía.");
        }
    }


}
