package one.digitalinnovation;

public class ListaDuplamenteEncadeada <T> {

    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;

    private int tamanhoLista = 0;

    //constructor method for double linked list,
    //each time a new Doble linked list is initialized, this constructor function runs
    public ListaDuplamenteEncadeada() {
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanhoLista = 0;
    }

    public int size() {
        return this.tamanhoLista;
    }

    //create getNo method which you will later use in other methods like remove, add, etc
    private NoDuplo<T> getNo(int index) {
        //save first node in noAuxiliar
        NoDuplo<T> noAuxiliar = primeiroNo;

        //create a for loop with two stop conditions: if i is less than given index and if noAuxiliar is not null

        for (int i = 0; (i < index) && (noAuxiliar != null); i++) {
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        //Once loop finishes running, return NoAuxiliar
        return noAuxiliar;
    }

    public T get(int index) {
        return this.getNo(index).getConteudo();
    }

    public void add(T elemento) {
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        //set newly added node's next node reference to null because you're adding it to the end of the list'
        novoNo.setNoProximo(null);
        //set newly added node's previous node reference to the previous last node that it was appended to(Your new node is the new last node)
        novoNo.setNoPrevio(ultimoNo);
        if (primeiroNo == null) {
            primeiroNo = novoNo;
        }

        if (ultimoNo != null) {
            ultimoNo.setNoProximo(novoNo);
        }
        //but if last node is empty or null set the new Node to last node
        ultimoNo = novoNo;
        //the add method also keeps track of list's size
        tamanhoLista++;
    }

    //overloading the 'add' method
    public void add(int index, T elemento) {
        NoDuplo<T> noAuxiliar = getNo(index);
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        novoNo.setNoProximo(noAuxiliar);

        if (novoNo.getNoProximo() != null) {
            novoNo.setNoPrevio(noAuxiliar.getNoPrevio());
            novoNo.getNoProximo().setNoPrevio(novoNo);
        } else {
            novoNo.setNoPrevio(ultimoNo);
            ultimoNo = novoNo;
        }

        if (index == 0) {
            primeiroNo = novoNo;
        } else {
            novoNo.getNoPrevio().setNoProximo(novoNo);
        }
        tamanhoLista++;

    }

    public void remove(int index) {
        //check if you are on first node of the list
        if (index == 0) {
            // point first node to second node
            primeiroNo = primeiroNo.getNoProximo();
            //check if there is a second node
            if (primeiroNo != null) {
                //if yes, remove reference to previous node
                primeiroNo.setNoPrevio(null);
            }
        } else {
            //if we're not dealing with first node
            //grab the node at the given index and keep it in noAuxiliar
            NoDuplo<T> noAuxiliar = getNo(index);
            //link up the 2 nodes that were flanking the noAuxiliar

            noAuxiliar.getNoPrevio().setNoProximo(noAuxiliar.getNoProximo());

            //check whether node removed(noAuxiliar) is not last node

            if (noAuxiliar != ultimoNo) {
                noAuxiliar.getNoProximo().setNoPrevio(noAuxiliar.getNoPrevio());
            } else {
                ultimoNo = noAuxiliar;
            }


            this.tamanhoLista--;
            //private NoDuplo<T> getNo;
        }

    }
    @Override
    public String toString () {
        String strRetorno = "";

        NoDuplo<T> noAuxiliar = primeiroNo;
        for (int i = 0; i < size(); i++) {
            strRetorno += "[No{conteudo=" + noAuxiliar.getConteudo() + "}]--->";
            noAuxiliar = noAuxiliar.getNoProximo();
        }

        strRetorno += "null";
        return strRetorno;
    }

}
