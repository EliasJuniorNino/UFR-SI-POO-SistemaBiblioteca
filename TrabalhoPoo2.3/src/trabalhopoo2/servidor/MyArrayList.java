package trabalhopoo2.servidor;

import java.io.Serializable;
import java.util.ArrayList;

public class MyArrayList<T> implements InserirListarExcuir<T>, Serializable {
    private ArrayList<T> elementos = new ArrayList<>();
    
    public MyArrayList(){ }
    
    @Override
    public void inserir(T elemento) {
        this.elementos.add(elemento);
    }

    @Override
    public void listar() {
        this.elementos.forEach( (e) -> {
            System.out.println(e);
        });
    }

    @Override
    public void excuir(T el) {
        this.elementos.remove(el);
    }
    
    public void excuir(int id) {
        this.elementos.remove(id);
    }
    
}
