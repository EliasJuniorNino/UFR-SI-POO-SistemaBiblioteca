package trabalhopoo2.servidor;

public class Model {
    
    private static Model instance = null;
    
    private MyArrayList<Aluno> alunos = new MyArrayList<>();
    private MyArrayList<Livro> livros = new MyArrayList<>();
    
    private Model( ){ }
    
    public static Model getInstance(){
        if ( Model.instance != null )
            return Model.instance;
        
        Model.instance = new Model();
        return Model.instance;
    }
    
    // só a instancia pode destruir
    public void destroy(){ Model.instance = null; }
    
    public void carregar(){
        DAO d = DAO.getInstance();
        try {
            this.alunos = d.lerArquivo("_alunos.json");
            this.livros = d.lerArquivo("_livros.json");
        } catch (ArquivoException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void salvar(){
        DAO d = DAO.getInstance();
        try {
            d.gravarArquivo(this.alunos, "_alunos.json");
            d.gravarArquivo(this.alunos, "_livros.json");
        } catch (ArquivoException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public MyArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(MyArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public MyArrayList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(MyArrayList<Livro> livros) {
        this.livros = livros;
    }
}
