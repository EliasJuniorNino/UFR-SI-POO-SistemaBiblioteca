package trabalhopoo2.servidor;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {
    
    private static Controller instance = null;
    private Scanner scanner;
    
    private Controller() {
        this.scanner = new Scanner(System.in);
    }

    private int readOption() {
        return Integer.parseInt(this.scanner.nextLine());
    }
    
    public void readMenu(){
        Model md = Model.getInstance();
        View vw = View.getInstance();
        vw.printMenu();
        int op;
        do{
            System.out.print(": ");
            op = readOption();
            switch(op){
                case 1:
                    System.out.print("CPF: ");
                    String cpf = this.scanner.nextLine();
                    System.out.print("Nome: ");
                    String nome = this.scanner.nextLine();
                    Aluno aluno = new Aluno.Builder()
                            .cpf(cpf)
                            .nome(nome)
                            .build();
                    md.getAlunos().inserir(aluno);
                    break;
                case 2:
                    md.getAlunos().listar();
                    break;
                case 3:
                    System.out.print("Digite um id: ");
                    int id = readOption();
                    md.getAlunos().excuir(id);
                    break;
                case 4:
                    System.out.print("area: ");
                    String area = this.scanner.nextLine();
                    System.out.print("editora: ");
                    String editora = this.scanner.nextLine();
                    Livro livro = new Livro.Builder()
                            .area(area)
                            .editora(editora)
                            .build();
                    md.getLivros().inserir(livro);
                    break;
                case 5:
                    md.getLivros().listar();
                    break;
                case 6:
                    System.out.print("Digite um id: ");
                    int idlivro = readOption();
                    md.getLivros().excuir(idlivro);
                    break;
                case 7:
                    MyArrayList<Livro> livros = Model.getInstance().getLivros();
                    String json = "[ {  } ]";
                    try {
                        DAO.getInstance().gravarArquivo(json, "saida.json");
                    } catch (ArquivoException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }
        }while(op != 0);
    }

    public static Controller getInstance() {
        if ( Controller.instance != null)
            return Controller.instance;
        Controller.instance = new Controller();
        return Controller.instance;
    }
    
}
