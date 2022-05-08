package one.digitalinnovation.upcastDowncast;

public class RodarAplicacao {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
            //Fazendo upcasts
        Funcionario gerente = new Gerente();
        Funcionario vendedor = new Vendedor();
        Funcionario faxineiro = new Faxineiro();
          //Fazendo downcast    (evitar)
        Vendedor vendedor = (Vendedor)new Funcionario();
        
    }
}
