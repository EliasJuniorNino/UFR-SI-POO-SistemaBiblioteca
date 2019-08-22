package trabalhopoo2.servidor;

import java.io.Serializable;

public class Livro implements Serializable{
    private String nome;
    private String area;
    private String editora;
    private long id;
    
    public static class Builder {
        private String nome;
        private String area;
        private String editora;
        private long id;
        
        public Builder() {}

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder area(String area) {
            this.area = area;
            return this;
        }

        public Builder editora(String editora) {
            this.editora = editora;
            return this;
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }
        
        public Livro build(){
            return new Livro(this);
        }
    }

    private Livro(Builder builder) {
        this.nome = builder.nome;
        this.area = builder.area;
        this.editora = builder.editora;
        this.id = builder.id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return toJson();
        //return "Lovro(" + "nome=" + nome + ", area=" + area + ", editora=" + editora + ", id=" + id + ")";
    }

    public String toJson() {
        return new JsonCabecalho()
                .set("id", this.id)
                .set("nome", this.nome)
                .set("area", this.area)
                .set("editora", this.editora)
                .toString();
    }
}
