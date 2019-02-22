package SistemaBiblioteca;

import java.io.Serializable;

class Area implements Serializable {
    private String nome;
    
    public Area(String nome){
        this.nome = nome;
    }
    
    @Override
    public String toString(){
        return this.nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
}
