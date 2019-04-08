package trabalhopoo2.servidor;

public class Aluno {
    private String nome;
    private String dataNascimento;
    private String cpf;
    private long id;
    
    public static class Builder{
        private String nome;
        private String dataNascimento;
        private String cpf;
        private long id;
        
        public Builder setNome(String nome){
            this.nome = nome;
            return this;
        }
        
        public Builder setDataNascimento(String dataNascimento){
            this.dataNascimento = dataNascimento;
            return this;
        }
        
        public Builder setCpf(String cpf){
            this.cpf = cpf;
            return this;
        }
        
        public Builder setId(long id){
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
        return "Aluno( " 
                + " nome: " + nome
                + " datanascimento: " + dataNascimento 
                + " cpf: " + cpf
                + " )";
    }
    
    public String toJson() {
        return "{" 
                + "  \"nome\"=\"" + nome + "\""
                + ", \"datanascimento\"=\"" + dataNascimento + "\""
                + ", \"cpf\"=" + cpf + "\""
                + "}";
    }
}
