package trabalhopoo2.servidor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DAO {
    
    public static class Carregar {
        
        public static ArrayList<Aluno> alunos(ArrayList<Aluno> dado, 
                String url)
        {
            ArrayList<Aluno> alunos = new ArrayList<>();
            Aluno aluno;
            try {
                FileInputStream fin = new FileInputStream(url);
                ObjectInputStream in = new ObjectInputStream(fin);
                while((aluno = (Aluno)in.readObject()) != null) {
                    alunos.add(aluno);
                }   
                in.close();
                fin.close();
            } catch (IOException ex) {
                System.out.println("Arquivo não encontrado");
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
            return alunos;
        }

        public static ArrayList<Livro> livros(ArrayList<Livro> dado, 
                String url)
        {
            ArrayList<Livro> livros = new ArrayList<>();
            Livro livro;
            try {
                FileInputStream fin = new FileInputStream(url);
                ObjectInputStream in = new ObjectInputStream(fin);
                while((livro = (Livro)in.readObject()) != null) {
                    livros.add(livro);
                }   
                in.close();
                fin.close();
            } catch (IOException ex) {
                System.out.println("Arquivo não encontrado");
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
            return livros;
        }
    } 
    
    public static class Gravar {
        
    }
}
