
package trabalhopoo2;

public class Livro {
    private String nome;
    private String area;
    private String editora;
    private long id;

    public Livro() {
    }

    public Livro(String nome, String area, String editora, long id) {
        this.nome = nome;
        this.area = area;
        this.editora = editora;
        this.id = id;
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
        return "Livro{" + "nome=" + nome + ", area=" + area + ", editora=" + editora + ", id=" + id + '}';
    }
    
    
    
}
