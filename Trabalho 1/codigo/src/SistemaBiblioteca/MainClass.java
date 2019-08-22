package SistemaBiblioteca;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class MainClass {
    
    private static Biblioteca biblioteca;
    
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Carregando...");
        carregarDados();
        if (biblioteca == null){
            System.out.print("Digite um nome para sua biblioteca: ");
            String nome = sc.nextLine();
            biblioteca = new Biblioteca(nome);
        }
        biblioteca.showMenu();
        
        System.out.println("Salvando...");
        salvarDados();
    }   
    
    private static void carregarDados(){
        Biblioteca newBiblioteca = null;
        try {
            FileInputStream fin = new FileInputStream("biblioteca.bin");
            ObjectInputStream in = new ObjectInputStream(fin);
            while((newBiblioteca = (Biblioteca) in.readObject()) != null) {
                biblioteca = newBiblioteca;
            }   
            in.close();
            fin.close();
        } catch (FileNotFoundException ex) {
            
        } catch (Exception ex){
            
        }
        biblioteca = newBiblioteca;
    }
    
    private static void salvarDados(){
        try {
            FileOutputStream fout = new FileOutputStream("biblioteca.bin");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(biblioteca);
            out.close();
            fout.close();   
        }
        catch(Exception e) {
            System.out.println("Erro ao salvar dados");
            e.printStackTrace();
        }
    }
}
