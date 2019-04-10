package trabalhopoo2.servidor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DAO<T> {
    
    private static DAO dao = null;
    
    private DAO(){ }
    
    public static DAO getInstance(){
        if ( DAO.dao != null )
            return DAO.dao;
        DAO.dao = new DAO();
        return DAO.dao;
    }
    
    public MyArrayList<T> lerArquivo (String url) 
            throws ArquivoException 
    {
        MyArrayList<T> arr = new MyArrayList<>();
        try {
            FileInputStream fin = new FileInputStream(url); 
            ObjectInputStream in = new ObjectInputStream(fin);
            while((arr = (MyArrayList<T>)in.readObject()) != null) {
                return arr;
            }
        } catch (IOException ex) {
            throw new ArquivoException("Arquivo não encontrado: " + ex.getMessage()); 
        } catch (ClassNotFoundException ex) {
            throw new ArquivoException(ex.getMessage());
        }
        
        return arr;
    }
    
    public void gravarArquivo(MyArrayList<T> arr, String url)
            throws ArquivoException 
    {
        try {
            FileOutputStream fout = new FileOutputStream(url);
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(arr);
            out.close();
            fout.close();   
        }
        catch(Exception e) {
            throw new ArquivoException(
                "Erro ao salvar dados: " + e.getMessage()
            );
        }
    }
    
    /*
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
    }*/
}
