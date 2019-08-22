
package trabalhopoo2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class TrabalhoPoo2 {
    
    private static MenuECadastro menuECadastro;
    
    
    /*public static void main(String[] args) {
        System.out.println("Carregando...");
        carregarDados();
        
        MenuECadastro m = new MenuECadastro();
        m.showmenu();
        
        System.out.println("Salvando...");
        salvarDados();
        
    }*/
    
    private static void carregarDados(){
        
        MenuECadastro newMenuECadastro = null;
        
        try {
            FileInputStream fin = new FileInputStream("menuECadastro.bin");
            ObjectInputStream in = new ObjectInputStream(fin);
            while((newMenuECadastro = (MenuECadastro) in.readObject()) != null) {
                menuECadastro = newMenuECadastro;
            }   
            in.close();
            fin.close();
        } catch (FileNotFoundException ex) {
            
        } catch (Exception ex){
            
        }
        menuECadastro = newMenuECadastro;
    }
    
    private static void salvarDados(){
        try {
            FileOutputStream fout = new FileOutputStream("menuECadastro.bin");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(menuECadastro);
            out.close();
            fout.close();   
        }
        catch(Exception e) {
            System.out.println("Erro ao salvar dados");
            e.printStackTrace();
        }
    }
    
}
