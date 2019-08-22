package trabalhopoo2.servidor;

import java.io.Serializable;

public class Aluno implements Serializable{
    private String nome;
    private String dataNascimento;
    private String cpf;
    private long id;

    Aluno() { }
    
    public static class Builder{
        private String nome;
        private String dataNascimento;
        private String cpf;
        private long id;
        
        public Builder() { }
        
        public Builder nome(String nome){
            this.nome = nome;
            return this;
        }
        
        public Builder dataNascimento(String dataNascimento){
            this.dataNascimento = dataNascimento;
            return this;
        }
        
        public Builder cpf(String cpf){
            this.cpf = cpf;
            return this;
        }
        
        public Builder id(long id){
            this.id = id;
            return this;
        }
        
        public Aluno build(){
            return new Aluno(this);
        }
    }
    
    private Aluno(Builder builder) {
        this.nome = builder.nome;
        this.dataNascimento = builder.dataNascimento;
        this.cpf = builder.cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDatanasc() {
        return dataNascimento;
    }

    public void setDatanasc(String datanasc) {
        this.dataNascimento = datanasc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    @Override
    public String toString(){
        return toJson();
        /*return "Aluno( " 
                + " nome: " + nome
                + " datanascimento: " + dataNascimento 
                + " cpf: " + cpf
                + " )";
        */
    }

    public String toJson() {
        return new JsonCabecalho()
                .set("id", this.id)
                .set("nome", this.nome)
                .set("datanascimento", this.dataNascimento)
                .set("cpf", this.cpf)
                .toString();
    }
}
