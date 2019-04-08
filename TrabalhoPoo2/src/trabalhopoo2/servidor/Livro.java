package trabalhopoo2.servidor;

public class Livro {
    private String nome;
    private String area;
    private String editora;
    private long id;
    
    public static class Builder {
        private String nome;
        private String area;
        private String editora;
        private long id;

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public void setEditora(String editora) {
            this.editora = editora;
        }

        public void setId(long id) {
            this.id = id;
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
        return "Lovro(" + "nome=" + nome + ", area=" + area + ", editora=" + editora + ", id=" + id + ")";
    }
    
    public String toJson() {
        return "{" 
                + "  \"nome\"=\"" + nome + "\""
                + ", \"area\"=\"" + area + "\""
                + ", \"editora\"=" + editora + "\""
                + ", \"id\"=\"" + id + "\"" 
                + "}";
    }
}
