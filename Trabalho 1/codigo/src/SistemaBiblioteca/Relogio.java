package SistemaBiblioteca;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Relogio {
    public static Date lerData(){
        System.out.println("Entre com a data(dd/MM/yyyy)");
        Scanner sc = new Scanner(System.in);
        System.out.print("Dia: ");
        int dia = Integer.parseInt(sc.nextLine());
        System.out.print("Mes: ");
        int mes = Integer.parseInt(sc.nextLine());
        System.out.print("Ano: ");
        int ano = Integer.parseInt(sc.nextLine());
        if(dia == 0 || mes == 0 || ano < 1970)
            return null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String str = dia + "/" + mes + "/" + ano;
        try {
            Date rdata = sdf.parse(str);
            if (Relogio.getIdade(rdata) < 0)
                return null;
            else
                return rdata;
        } catch (ParseException ex) {
            Logger.getLogger(Relogio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static Date getTime(){
        return Calendar.getInstance().getTime();
    }
    public static int getIdade(Date nascimento){
        Calendar calAtual = Calendar.getInstance();
        calAtual.setTime(calAtual.getTime());
        int diaAnoAtual = calAtual.get(Calendar.DAY_OF_YEAR);
        int anoAtual = calAtual.get(Calendar.YEAR);
        
        Calendar calPessoua = Calendar.getInstance();
        calPessoua.setTime(nascimento);
        int diaAnoPessoua = calPessoua.get(Calendar.DAY_OF_YEAR);
        int anoPessoua = calPessoua.get(Calendar.YEAR);
        
        int idade = anoAtual - anoPessoua;
        return diaAnoAtual >= diaAnoPessoua ? idade : idade - 1;
    }
}
