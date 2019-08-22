
package trabalhopoo2;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuECadastro {
    
    private ArrayList<Livro> livros = new ArrayList<>();
    private ArrayList<Aluno> alunos = new ArrayList<>();
    
    public void showmenu(){
        int op;
        do{
        System.out.println("----- Menu -----\n1 - Cadastro aluno\n2 - Cadastro livro\n0 - Sair");
        Scanner scan = new Scanner(System.in);
        op = scan.nextInt();
        if (op == 1){
            System.out.println("Cadastro aluno");
        }
        if (op == 2){
            System.out.println("Cadastro livro");
        }
        if((op == 1) || (op == 2))
            System.out.println("1 - Inserir\n2 - Listar\n3 - Deletar\n0 - Voltar");
        
        switch(op){
            case 1:
                cadastrarAluno();
                break;
                
            case 2:
                cadastrarLivro();
                break;
        }
        
        }while(op != 0);
    }
    
    private void cadastrarAluno(){
        int op;
        Scanner scan = new Scanner(System.in);
        CadastroAluno novoAluno = new CadastroAluno();
        op = scan.nextInt();
        switch(op){
            case 1:
                novoAluno.inserir(alunos);

                break;

            case 2:
                novoAluno.listar(alunos);
                break;

            case 3:
                novoAluno.deletar(alunos);
                break;
        }
    }
    
    private void cadastrarLivro(){
        ArrayList<String> areasLivro = new ArrayList<>();
        int op;
        Scanner scan = new Scanner(System.in);
        CadastroLivro novoLivro = new CadastroLivro();
        op = scan.nextInt();
        switch(op){
            case 1:
                novoLivro.inserir(livros);
                break;
                
            case 2:
                novoLivro.listar(livros);
                break;
                
            case 3:
                novoLivro.deletar(livros);
                break;
        }
    }
}
