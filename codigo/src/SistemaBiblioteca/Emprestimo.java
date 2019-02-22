package SistemaBiblioteca;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

class Emprestimo implements Serializable {
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private Estudante estudante;
    
    public Emprestimo(Estudante estudante){
        this.dataEmprestimo = Calendar.getInstance().getTime();
        this.estudante =  estudante;
        this.dataDevolucao = null;
    }
    
    public Emprestimo(Date date, Estudante estudante){
        this.dataEmprestimo = date;
        this.estudante =  estudante;
        this.dataDevolucao = null;
    }
    
    public void finalizar(){
        this.dataDevolucao = Relogio.getTime();
    }
    
    public Date getDataEmprestimo(){
        return this.dataEmprestimo;
    }
    
    public Date getDataDevolucao(){
        return this.dataDevolucao;
    }
    
    public Estudante getEstudante(){
        return this.estudante;
    }
    
    public void setEstudante(Estudante estudante){
        this.estudante = estudante;
    }
}
