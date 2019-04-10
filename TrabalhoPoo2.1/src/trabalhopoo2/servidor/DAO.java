package trabalhopoo2.servidor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DAO {
    
    public static ArrayList<Aluno> carregarAlunos(String url){
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
        } catch (ClassNotFoundException cnfex) {
            System.out.println(cnfex.getMessage());
        }
        return alunos;
    }

    public static ArrayList<Livro> carregarlivros(String url){
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
        } catch (ClassNotFoundException cnfex) {
            System.out.println(cnfex.getMessage());
        }
        return livros;
    }
    
    public static void graverAlunos(ArrayList<Livro> alunos, String url){
        try {
            FileOutputStream fout = new FileOutputStream(url);
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(alunos);
            out.close();
            fout.close();   
        }
        catch(Exception e) {
            System.out.println("Erro ao salvar dados");
        }
    }

    public static void gravarLivros(ArrayList<Livro> livros, String url){
        try {
            FileOutputStream fout = new FileOutputStream(url);
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(livros);
            out.close();
            fout.close();   
        }
        catch(Exception e) {
            System.out.println("Erro ao salvar dados");
        }
    }
}
