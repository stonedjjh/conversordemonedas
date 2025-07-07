package conversor.monedas.modelos;

import java.io.*;
import java.util.Scanner;

public class Archivo {
    String nombreArchivo  = "log.txt";
    FileWriter fileWriter;
    FileReader fileReader;
    Scanner teclado = new Scanner(System.in);
    public void reiniciarArchivo() throws IOException {
        System.out.println("Seguro quiere reiniciar el log (S/N)");
        String opcion = teclado.next();
        try {
            if (opcion.equalsIgnoreCase("s")){
                this.fileWriter = new FileWriter(this.nombreArchivo);
                this.fileWriter.close();
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo");
        }
    }

    public void agregarEntrada(String log){
        try {
            this.fileWriter = new FileWriter(this.nombreArchivo,true);
            fileWriter.write(log);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error al crear el archivo");
        }
    }

    public FileReader leerRegistros(){
        try{
            this.fileReader = new FileReader(this.nombreArchivo);
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        }
        return this.fileReader;
    }
}
