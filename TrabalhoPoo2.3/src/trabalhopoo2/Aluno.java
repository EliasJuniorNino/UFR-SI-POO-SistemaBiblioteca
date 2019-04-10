
package trabalhopoo2;

import java.util.Date;

public class Aluno {
    private String nome;
    private String datanasc;
    private String cpf;

    public Aluno(String nome, String datanasc, String cpf) {
        this.nome = nome;
        this.datanasc = datanasc;
        this.cpf = cpf;
    }

    public Aluno() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(String datanasc) {
        this.datanasc = datanasc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
}
