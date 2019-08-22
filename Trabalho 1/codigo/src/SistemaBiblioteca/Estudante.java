package SistemaBiblioteca;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Estudante extends Pessoua{
    private long numeroMatricula;
    private int totalEmprestimo;
    
    public Estudante(Pessoua pessoua, int numeroMatricula){
        super(pessoua);
        this.numeroMatricula = numeroMatricula;
        this.totalEmprestimo = 0;
    }
    
    public Estudante(String nome, Date data, long cpf, long numeroMatricula){
        super(nome, data, cpf);
        this.numeroMatricula = numeroMatricula;
        this.totalEmprestimo = 0;
    }
    
    @Override
    public String toString(){
        String stdout = "------------ Aluno ------------";
            stdout += "\nNome: " + this.getNome();
            stdout += "\nNumero de matricula: " + this.numeroMatricula;
            stdout += "\n";
        return stdout;
    }
    
    public long getNumeroMatricula(){
        return this.numeroMatricula;
    }
    
    public void setNumeroMatricula(int newNumeroMatricula){
        this.numeroMatricula = newNumeroMatricula;
    }
    public void addEmprestimo(){
        this.totalEmprestimo++;
    }
    public int getEmprestimos(){
        return this.totalEmprestimo;
    }
}
