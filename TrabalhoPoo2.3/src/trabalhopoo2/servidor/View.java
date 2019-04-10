package trabalhopoo2.servidor;

public class View {
    private static View instance = null;
    
    private View() { }

    static View getInstance() {
        if ( View.instance != null )
            return View.instance;
        View.instance = new View();
        return View.instance;
    }

    public void printMenu() {
        System.out.println("1 - Inserir Aluno");
        System.out.println("2 - Listar Aluno");
        System.out.println("3 - Remover Aluno");
        System.out.println("4 - Inserir Livro");
        System.out.println("5 - Listar Livro");
        System.out.println("6 - Remover Livro");
        System.out.println("0 - Sair");
    }
    
    
}
