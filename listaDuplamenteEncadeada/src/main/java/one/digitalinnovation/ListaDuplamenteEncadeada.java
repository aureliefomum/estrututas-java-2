package one.digitalinnovation;

public class ListaDuplamenteEncadeada <T> {

    private NoDuplo <T> primeiroNo;
    private NoDuplo <T> ultimoNo;

    private int tamanhoLista = 0;

    //constructor method for double linked list,
    //each time a new Doble linked list is initialized, this constructor function runs
    public ListaDuplamenteEncadeada(){
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanhoLista = 0;
    }


    public int size(){
        return tamanhoLista;
    }
}
