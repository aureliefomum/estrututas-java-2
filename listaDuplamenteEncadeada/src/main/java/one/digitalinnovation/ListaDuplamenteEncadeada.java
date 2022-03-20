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

    //create getNo method which you will later use in other methods like remove, add, etc
    private NoDuplo<T> getNo(int index){
        //save first node in noAuxiliar
        NoDuplo<T> noAuxiliar = primeiroNo;

        //create a for loop with two stop conditions: if i is less than given index and if noAuxiliar is not null

        for(int i =0; (i < index) && (noAuxiliar !=null);i++){
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        //Once loop finishes running, return NoAuxiliar
        return noAuxiliar;
    }


    public int size(){
        return tamanhoLista;
    }
}
