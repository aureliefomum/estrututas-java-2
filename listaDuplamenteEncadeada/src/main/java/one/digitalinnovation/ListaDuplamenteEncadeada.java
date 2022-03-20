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

    public T get(int index){
        return this.getNo(index).getConteudo();
    }

    public void add(T elemento){
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        //set newly added node's next node reference to null because you're adding it to the end of the list'
        novoNo.setNoProximo(null);
        //set newly added node's previous node reference to the previous last node that it was appended to(Your new node is the new last node)
        novoNo.setNoPrevio(ultimoNo);
        if(primeiroNo == null){
            primeiroNo = novoNo;
        }

        if(ultimoNo!=null){
            ultimoNo.setNoProximo(novoNo);
        }
        //but if last node is empty or null set the new Node to last node
        ultimoNo = novoNo;
        //the add method also keeps track of list's size
        tamanhoLista++;
    }
//overloading the 'add' method
    public void add(int index, T elemento){
        NoDuplo<T> noAuxiliar = getNo(index);
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        novoNo.setNoProximo(noAuxiliar);

        if(novoNo.getNoProximo() != null){
            novoNo.setNoPrevio(noAuxiliar.getNoPrevio());
            novoNo.getNoProximo().setNoPrevio(novoNo)
        }else{
            novoNo.setNoPrevio(ultimoNo);
            ultimoNo = novoNo;
        }

        if (index == 0){
            primeiroNo = novoNo;
        } else {
            novoNo.getNoPrevio().setNoProximo(novoNo);
        }
        tamanhoLista++;


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
        return this.tamanhoLista;
    }
}
