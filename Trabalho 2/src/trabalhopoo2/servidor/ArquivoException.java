package trabalhopoo2.servidor;

public class ArquivoException extends Exception{
    private String message;
    
    public ArquivoException() { }
    
    public ArquivoException(String message) { 
        super(message);
        this.message = message;
    }
}
