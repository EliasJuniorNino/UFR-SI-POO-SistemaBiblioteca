package trabalhopoo2.servidor;

public class Servidor {
    
    public static void main(String[] args){
        Controller c = Controller.getInstance();
        Model m = Model.getInstance();
        m.carregar();
        c.readMenu();
        m.salvar();
    }
}
