import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import Models.Bussines.Bussines;
import Models.HashTables.HashTable;

import Models.ListaEnlazada.ListaEnlazada;


public class Main {
    public static void main (String[] args){
        Scanner entrada = new Scanner(System.in);
        int options;
        do{
            System.out.println("opciones");
            System.out.println("1.lista enlazada    2.Salir");
            options = entrada.nextInt();
            if(options == 1)
                myLinkedList();
           
                
        }while(options == 1 || options == 2);
    }
    public static void optionsHashD(HashTable tablaHash){
        Scanner entrada = new Scanner (System.in);
        Scanner scanner = new Scanner (System.in);
        System.out.println("1. Imprimir toda la tabla   2. Buscar valor");
        int option = entrada.nextInt();
        if(option == 1){
            long inicio = System.currentTimeMillis();
            for(int i = 0; i < tablaHash.tablaHash.length; i++){
                System.out.println("Index: " + i);
                tablaHash.recorrido(i);
            }
            long fin = System.currentTimeMillis();
            double tiempo = (double) (fin - inicio) / 1000f;
            System.out.println("Tiempo de ejecución: " + tiempo + " segundos");
        }
        if(option == 2){
            System.out.println("Ingrese clave");
            String search = scanner.nextLine();
            long inicio = System.currentTimeMillis();
            tablaHash.shearchHashD(search);
            long fin = System.currentTimeMillis();
            double tiempo = (double) (fin - inicio) / 1000f;
            System.out.println("Tiempo de ejecución: " + tiempo + " segundos");
        }
    }
    public static void optionHashM(HashTable tabla){
        Scanner entrada = new Scanner (System.in);
        Scanner scanner = new Scanner (System.in);
        System.out.println("1. Imprimir toda la tabla   2. Buscar valor");
        int option = entrada.nextInt();
        if(option == 1){
            long inicio = System.currentTimeMillis();
            for(int i = 0; i < tabla.tablaHash.length; i++){
                System.out.println("Index: " + i);
                tabla.recorrido(i);
            }
            long fin = System.currentTimeMillis();
            double tiempo = (double) (fin - inicio) / 1000f;
            System.out.println("Tiempo de ejecución: " + tiempo + " segundos");
        }
        if(option == 2){
            System.out.println("Ingrese clave");
            String search = scanner.nextLine();
            long inicio = System.currentTimeMillis();
            tabla.shearchHashM(search);
            long fin = System.currentTimeMillis();
            double tiempo = (double) (fin - inicio) / 1000f;
            System.out.println("Tiempo de ejecución: " + tiempo + " segundos");
        }
    }

    public static void myLinkedList (){
        Scanner entrada = new Scanner (System.in);
        HashTable hashTableD = new HashTable();
        HashTable hashTableM = new HashTable();
        String line = "";
        String splitBy = ",";

        try
        {
            BufferedReader br = new BufferedReader(new FileReader("bussines.csv"));
            while ((line = br.readLine()) != null)   
            {
                String[] bussines = line.split(splitBy);
                Bussines objBuss = new Bussines(bussines[0], bussines[1]);
                hashTableD.setValueDivition(bussines[0], objBuss);
                hashTableM.setValueMultiplication(bussines[0], objBuss);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        int opcion;
        do{
            System.out.println("Hashing  division: 1");
            System.out.println("Hashing  multiplicacion: 2");
            System.out.println("Salr: 3");
            opcion = entrada.nextInt();
            if(opcion == 1){
                System.out.println("Hashing  division");
                optionsHashD(hashTableD);
            }
            if(opcion == 2){
                System.out.println("Hashing multiplicacion");
                optionHashM(hashTableM);

            }
        }while (opcion == 1 || opcion == 2);
    }

}