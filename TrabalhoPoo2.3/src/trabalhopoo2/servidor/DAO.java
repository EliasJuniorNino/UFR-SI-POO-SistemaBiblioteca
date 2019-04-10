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
    
    public void gravarArquivo(String data, String url)
            throws ArquivoException 
    {
        try {
            FileOutputStream fout = new FileOutputStream(url);
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.write(data.getBytes());
            out.close();
            fout.close();   
        }
        catch(Exception e) {
            throw new ArquivoException(
                "Erro ao salvar dados: " + e.getMessage()
            );
        }
    }
}