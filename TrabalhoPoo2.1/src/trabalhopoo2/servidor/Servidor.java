package trabalhopoo2.servidor;

public class Servidor {
    public static void main(String[] args){
        MyArrayList<Livro> livros = new MyArrayList<>();
        livros.inserir(new Livro.Builder()
                .nome("C++ ava")
                .id(0)
                .editora("Editora 1")
                .build());
        livros.inserir(new Livro.Builder()
                .nome("POO com Java")
                .id(0)
                .editora("Editora 1")
                .build());
        livros.listar();
        MyArrayList<Aluno> alunos = new MyArrayList<>();
        alunos.inserir(new Aluno.Builder()
                .nome("Elias Junior")
                .id(0)
                .dataNascimento("22/08/1995")
                .cpf("09989876534")
                .build());
        alunos.listar();
    }
}
