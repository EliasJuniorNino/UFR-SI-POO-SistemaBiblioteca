package SistemaBiblioteca;

import java.io.Serializable;
import java.util.Date;

public class Pessoua implements Serializable {
    private String nome;
    private long cpf;
    private Date nascimento;
    
    public Pessoua(Pessoua pessoua){
        this.nome = pessoua.nome;
        this.cpf = pessoua.cpf;
        this.nascimento = pessoua.nascimento;
    }
    
    public Pessoua(String nome, Date date, long cpf){
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = date;
    }
    
    @Override
    public String toString(){
        String stdout = "------- Pessoua -------";
            stdout += "\nnome: " + this.getNome();
            stdout += "\nidade: " + this.getIdade();
            stdout += "\ncpf: " + this.getCpf();
            stdout += "\n";
        return stdout;
    }
    
    public void setNome(String novoNome){
        this.nome = novoNome;
    }
    
    public void setCpf(int novoCpf){
        this.cpf = novoCpf;
    }
    
    public void setNascimento(Date novaData){
        this.nascimento = novaData;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public long getCpf(){
        return this.cpf;
    }
    
    public Date getNascimento(){
        return this.nascimento;
    }
    
    public int getIdade(){
        return Relogio.getIdade(this.nascimento);
    }
}
