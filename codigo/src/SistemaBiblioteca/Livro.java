package SistemaBiblioteca;

import java.io.Serializable;
import java.util.ArrayList;

public class Livro implements Serializable {
    private String nome;
    private ArrayList<Area> areas = new ArrayList<>();
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    
    public Livro(String nome, ArrayList<Area> areas){
        this.nome = nome;
        this.areas = areas;
    }
    public boolean isDisponivel(){
        for(Emprestimo i : this.emprestimos)
            if (i.getDataDevolucao() == null)
                return false;
        return true;
    }
    public String toString(){
        String out = "-----------Livro-----------";
        out += "\nNome: " + this.nome;
        out += "\nCategorias: ";
        for(Area i : this.areas){
            out += i.getNome() + ", ";
        }
        if (!this.isDisponivel())
            out += "\nEmprestado para: " + 
                    this.emprestimos.get(this.emprestimos.size() - 1)
                    .getEstudante().getNome();
        out += "\n";
        return out;
    }
    public String getNome(){
        return this.nome;
    }
    public ArrayList<Area> getAreas(){
        return this.areas;
    }
    public void emprestar(Estudante aluno){
        this.emprestimos.add(new Emprestimo(aluno));
    }
    public void devolver(){
        int tamanho = this.emprestimos.size();
        if ( tamanho > 0){
            this.emprestimos.get(tamanho - 1).finalizar();
        }
    }
}
