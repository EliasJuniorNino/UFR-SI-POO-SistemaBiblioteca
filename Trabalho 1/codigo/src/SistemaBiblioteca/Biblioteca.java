package SistemaBiblioteca;

import java.util.ArrayList;

import java.io.Serializable;
import java.util.Date;

public class Biblioteca implements Serializable {
    private String nome;
    private ArrayList<Livro> livros = new ArrayList<>();
    private ArrayList<Estudante> estudantes = new ArrayList<>();
    private ArrayList<Area> areas = new ArrayList<>();

    public Biblioteca(String nome){
        this.nome = nome;
    }
    
    public void showMenu(){
        int opcao;
        do{
            String[] menu = {
                "Sair", "Cadastrar livro", "Cadastrar aluno", "Emprestar livro",
                "Devolver livro", "Relatório de Empréstimos", 
                "Relatório de Livros por Área", "Listar livros", "Listar alunos",
                "Listar areas"
            };
            UI.print("Menu", menu, true);
            opcao = Integer.parseInt(UI.getScanner().nextLine());
            switch(opcao){
                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    cadastrarAluno();
                    break;
                case 3:
                    emprestarLivro();
                    break;
                case 4:
                    devolverLivro();
                    break;
                case 5:
                    relatorioEmprestimos();
                    break;
                case 6:
                    relatorioLivroPorArea();
                    break;
                case 7:
                    listarLivros();
                    break;
                case 8:
                    listarAlunos();
                    break;
                case 9:
                    listarAreas();
                    break;
            }
        }while(opcao != 0);
    }
    
    private boolean areaExist(ArrayList<Area> array, Area area){
        for(Area i : array){
            if ( i.getNome().equals(area.getNome()) )
                return true;
        }
        return false;
    }

    private void cadastrarLivro() {
        ArrayList<Area> areasLivro = new ArrayList<>();
        int op;
        UI.print("Cadastro de livro", "Nome: ");
        String nomeLivro = UI.getScanner().nextLine();
        do{
            String[] menu = { 
                "Finalizar", "Adicionar area", "Escolher existente"};
            UI.print("Areas",menu, true);
            op = Integer.parseInt(UI.getScanner().nextLine());
            switch(op){
                case 1:
                    System.out.print("Nome da area: ");
                    String nomeArea = UI.getScanner().nextLine();
                    Area novaArea = new Area(nomeArea);
                    if ( !areaExist(this.areas, novaArea) )
                        this.areas.add(novaArea); 
                    if ( !areaExist(areasLivro, novaArea) ) 
                        areasLivro.add(novaArea);
                    break;
                case 2:
                    if(this.areas.size() == 0){
                        System.out.println("\nNao existe areas cadastrada");
                        break;
                    }
                    System.out.println("\n------ Areas ------");
                    for(int i = 1; i <= this.areas.size(); i++){
                        System.out.println((i) + " - " + this.areas.get(i - 1).getNome());
                    }
                    System.out.print("Selecione uma area correspondente, ou 0 para continuar: ");
                    int idArea = Integer.parseInt(UI.getScanner().nextLine());
                    if (idArea == 0)
                        break;
                    if ( !areaExist(areasLivro, this.areas.get(idArea - 1)) ) 
                        areasLivro.add(this.areas.get(idArea - 1));
                    else
                        System.out.println("\nEsta area ja esta adicionada");
                    break;
            }
        }while(op != 0);
        this.livros.add(new Livro(nomeLivro, areasLivro));
    }

    private void cadastrarAluno() {
        System.out.println("----- Cadastro Aluno -----");
        System.out.print("Nome: ");
        String nome = UI.getScanner().nextLine();
        if(!RegrasGeral.validNome(nome)){
            System.out.println("\nNome invalido");
            return;
        }
        System.out.println("Nascimento: ");
        Date data = Relogio.lerData();
        if(data == null){
            System.out.println("Data de nascimento invalida");
            return;
        }
        System.out.print("CPF: ");
        long cpf = Integer.parseInt(UI.getScanner().nextLine());
        if(!RegrasGeral.validCpf(cpf)){
            System.out.println("\nCpf invalido");
            return;
        }
        System.out.print("Numero de Matricula: ");
        long numeroMatricula = Integer.parseInt(UI.getScanner().nextLine());
        if(!RegrasGeral.validNumeroMatricula(numeroMatricula)){
            System.out.println("\nNumero de matricula invalido");
            return;
        }
        for(Estudante i : this.estudantes){
            if (i.getNumeroMatricula() == numeroMatricula){
                System.out.println(
                        "Esse numero de matricula já está cadastrado!");
                return;
            }
        }
        this.estudantes.add(new Estudante(nome, data, cpf, numeroMatricula));
    }

    private void emprestarLivro() {
        if(this.livros.size() == 0){
            System.out.println("\nNao a livros cadastrado");
            return;
        }
        if(this.estudantes.size() == 0){
            System.out.println("\nNao a estudantes cadastrado");
            return;
        }
        System.out.println("\n----- Livros -----");
        int count = 0;
        for(int i = 0; i < this.livros.size(); i++){
            if (this.livros.get(i).isDisponivel()){
                System.out.println(
                    i + " - " + this.livros.get(i).getNome());
                count++;
            }
        }
        if(count > 0){
            System.out.print("Digite o id do livro para emptrestar: ");
            int escolhaLivro = Integer.parseInt(UI.getScanner().nextLine());
            if (this.livros.get(escolhaLivro).isDisponivel()){
                for(int i = 0; i < this.estudantes.size(); i++){
                    System.out.println(
                            i + " - Nº matricula: " +
                            this.estudantes.get(i).getNumeroMatricula() +
                            ", Nome: " + this.estudantes.get(i).getNome());
                }
                System.out.print("Escolha um estudante: ");
                int escolhaEstudante = Integer.parseInt(UI
                        .getScanner().nextLine());
                
                if(this.estudantes.get(escolhaEstudante).getEmprestimos() > 3){
                    System.out.println("\nEste aluno ja atingiu o limite de emprestimos");
                }
                else {
                    this.livros.get(escolhaLivro)
                        .emprestar(this.estudantes.get(escolhaEstudante));
                    this.estudantes.get(escolhaEstudante).addEmprestimo();
                }
            }
            else{
                System.out.println("Este livro não está disponivel");
            }
        }
        else{
            System.out.println("\nNão a livros disponiveis");
        }
    }

    private void devolverLivro() {
        int count = 0;
        for(int i = 0; i < this.livros.size(); i++){
            if(!this.livros.get(i).isDisponivel()){
                System.out.println(i + " - " + this.livros.get(i).getNome());
                count++;
            } 
        }
        if(count == 0){
            System.out.println("\nNão a livros para devolver");
            return;
        }
        System.out.print("Selecione um livro para devolver: ");
        int escolha = Integer.parseInt(UI.getScanner().nextLine());
        this.livros.get(escolha).devolver();
    }

    private void relatorioEmprestimos() {
        if(this.livros.size() == 0){
            System.out.println("\nNao existe livros cadastradas");
            return;
        }
        System.out.println("---- > Livros emprestados < ----");
        for(Livro i : this.livros){
            if(!i.isDisponivel())
                System.out.println(i.toString());
        }
        System.out.println("---- > Livros Disponiveis < ----");
        for(Livro i : this.livros){
            if(i.isDisponivel())
                System.out.println(i.toString());
        }
    }

    private void relatorioLivroPorArea() {
        if(this.areas.size() == 0){
            System.out.println("\nNao existe areas cadastradas");
            return;
        }
        for(Area i : this.areas){
            System.out.println("\n----- Area -----");
            System.out.println("Nome: " + i.getNome());
            System.out.print("Livros: ");
            for(Livro j : this.livros){
                for(Area k : j.getAreas()){
                    if(k.getNome().equals(i.getNome())){
                        System.out.print(j.getNome() + ", ");
                        break;
                    }
                }
            }
        }
    }

    private void listarLivros() {
        if(this.livros.size() == 0){
            System.out.println("\nNao a livro cadastrado");
            return;
        }
        System.out.println("\nLivros");
        for(Livro i : this.livros)
            System.out.println(i.toString());
    }

    private void listarAlunos() {
        if(this.estudantes.size() == 0){
            System.out.println("\nNao a aluno cadastrado");
            return;
        }
        System.out.println("\nAlunos");
        for(Estudante i : this.estudantes)
            System.out.println(i.toString());
    }

    private void listarAreas() {
        if(this.areas.size() == 0){
            System.out.println("\nNao a area cadastrada");
            return;
        }
        System.out.println("\nAreas");
        for(Area i : this.areas)
            System.out.println(i.toString());
    }
}
