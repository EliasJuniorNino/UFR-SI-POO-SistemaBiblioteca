
package trabalhopoo2;

import java.util.ArrayList;
import java.util.Scanner;
import static trabalhopoo2.CadastroAluno.verificaCpf;

public class CadastroLivro implements InserirListarDeletar{
    Scanner scan = new Scanner(System.in);
    
    //-----------------------------INSERIR--------------------------------------
    public void inserir(ArrayList livros){
        System.out.println("Cadastrar novo livro");
        System.out.print("Nome: ");
        String nome = scan.next();
        System.out.println("Area: ");
        String data = scan.next();
        System.out.print("Editora: ");
        String editora = scan.next();
        System.out.print("ID: ");
        long id = scan.nextLong();
        Livro l1 = new Livro(nome, data, editora, id);
        livros.add(l1);
    }

    //-----------------------------LISTAR--------------------------------------
    public void listar(ArrayList livros){
        System.out.println("Lista de livro");
        for (int i = 0; i<livros.size(); i++){
            System.out.println(livros.get(i));
        }
    }

    //-----------------------------DELETAR--------------------------------------
    public void deletar(ArrayList livros){
        System.out.println("Deletar livro");
        
        boolean veri = false;
        do{
            System.out.println("Digite o numero de id do livro para deletar");
            long id = scan.nextLong();
            try{
                String cpf = scan.next();
                veri = verificaID(id, livros);

            }
            catch(LivroNExistente e){
                System.out.println(e.getMessage());
            }
        }while(veri == false);
        
    }
        
        
    public static boolean verificaID(long id, ArrayList livros)throws LivroNExistente{
        throw (new LivroNExistente("Cpf invalido"));
        
        
    }

    
    //TERIA QUE FAZER UNS BANG PRA PASSAR QUALQUER TIPO
    @Override
    public void inserir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
