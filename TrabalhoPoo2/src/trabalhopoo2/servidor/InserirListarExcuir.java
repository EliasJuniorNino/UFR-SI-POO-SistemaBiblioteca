package trabalhopoo2.servidor;

public interface InserirListarExcuir<T> {
    public void inserir(T elemento);
    public void listar();
    public void excuir(long id);
}
