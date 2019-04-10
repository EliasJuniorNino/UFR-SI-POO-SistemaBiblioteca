
package trabalhopoo2;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CadastroAluno implements InserirListarDeletar{
    
    Scanner scan = new Scanner(System.in);

    
    //-----------------------------INSERIR--------------------------------------
    public void inserir(ArrayList alunos){
        System.out.println("Cadastrar novo aluno");
        System.out.print("Nome: ");
        String nome = scan.next();
        System.out.println("Nascimento: ");
        String data = scan.next();
        boolean veri = false;
        do{
            System.out.print("CPF: ");
            try{
                String cpf = scan.next();
                veri = verificaCpf(cpf);
                Aluno a1 = new Aluno(nome, data, cpf);
                alunos.add(a1);
            }
            catch(CpfValido e){
                System.out.println(e.getMessage());
            }
            
        }while(veri == false);
    }
    
    //-----------------------------LISTAR--------------------------------------

    public void listar(ArrayList alunos){
        System.out.println("Listar alunos");
        for (int i = 0; i<alunos.size(); i++){
            System.out.println(alunos.get(i));
        }
    }
    
    //-----------------------------DELETAR--------------------------------------

    public void deletar(ArrayList alunos){
        System.out.println("Deletar aluno");
        
        
    }
    
    //Exceção para verificar se o cpf é valido----------------------------------
    public static boolean verificaCpf(String cpf) throws CpfValido{
        if(cpf.length()!=14){
            throw (new CpfValido("Cpf invalido"));
        }
        char[] c = cpf.toCharArray();
        String ver = ".-";
        char[] ver2 = ver.toCharArray();
        for(int i =0; i<c.length;i++){
            if(Character.isAlphabetic(c[i])){
                throw (new CpfValido("Cpf invalido"));
            }
            if((c[3] != ver2[0]) || (c[7] != ver2[0])|| (c[11] != ver2[1]))  {
                throw (new CpfValido("Cpf invalido"));
            }
        }
        return true;
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
