package SistemaBiblioteca;

import java.util.Scanner;

public class UI {
    private static Scanner scanner = new Scanner(System.in);
    
    public static Scanner getScanner(){
        return scanner;
    }
    
    public static UI print(String str){
        System.out.print(str);
        return new UI();
    }
    
    public static UI print(String titulo, String str){
        System.out.println("\n----- " + titulo + " -----");
        System.out.print(str);
        return new UI();
    }
    
    public static UI print(boolean comEntrada, String str){
        System.out.print(str + ": ");
        return new UI();
    }
    
    public static UI print(String[] itens){
        for(String i : itens){
            System.out.println(i);
        }
        System.out.print(": ");
        return new UI();
    }
    
    public static UI print(String titulo, String[] itens){
        System.out.println("\n----- " + titulo + " -----");
        for(String i : itens){
            System.out.println(i);
        }
        System.out.print(": ");
        return new UI();
    }
    
    public static UI print(String titulo, String[] itens, boolean comIndice){
            
        System.out.println("\n----- " + titulo + " -----");
        for(int i = 0; i < itens.length; i++){
            System.out.println(i + " - " + itens[i]);
        }
        System.out.print(": ");
        return new UI();
    }
    public static UI print(String[] itens, boolean comIndice){
        for(int i = 0; i < itens.length; i++){
            System.out.println(i + " - " + itens[i]);
        }
        System.out.print(": ");
        return new UI();
    }
}
