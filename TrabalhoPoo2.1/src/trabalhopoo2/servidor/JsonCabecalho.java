package trabalhopoo2.servidor;

import java.util.ArrayList;

public class JsonCabecalho<T> {
    
    private ArrayList<String> indices = new ArrayList<>();
    private ArrayList<T> valores = new ArrayList<>();
    
    public JsonCabecalho() { }
    
    public JsonCabecalho<T> set(String indice, T valor){
        for (int i = 0; i < this.indices.size(); i++){
            if ( this.indices.get(i).equals(indice) ){
                this.valores.set(i, valor);
                return this;
            }
        }
        this.indices.add(indice);
        this.valores.add(valor);
        return this;
    }
    
    public T get(String indice){
        for (int i = 0; i < this.indices.size(); i++){
            if ( this.indices.get(i).equals(indice) ){
                return this.valores.get(i);
            }
        }
        return null;
    }
    
    public String toJson(){
        String str = "";
        for(int i = 0; i < this.indices.size(); i++){
            str += "\"" + this.indices.get(i) + "\": ";
            
            if ( this.valores.get(i) instanceof String)
                str += "\"" + this.valores.get(i) + "\"";
            else
                str += this.valores.get(i);
            
            if(i < this.indices.size() - 1)
                str += ", ";
        }
        return "{ " + str + " }";
    }
}
