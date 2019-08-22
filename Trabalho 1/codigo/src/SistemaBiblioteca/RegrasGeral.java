package SistemaBiblioteca;

public class RegrasGeral {
    public static boolean validNumeroMatricula(long numero){
        return numero > 2000; // Supondo que a faculdade foi inalgurada em 2000, (Não sei a data)
    }
    public static boolean validNome(String nome){
        return !nome.equals("");
    }
    public static boolean validCpf(long cpf){
        return cpf > 0;
    }
}
