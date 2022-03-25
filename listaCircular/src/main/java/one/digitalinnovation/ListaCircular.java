package one.digitalinnovation;

public class ListaCircular<T> {

    private No<T> cabeca;
    private No<T> cauda;
    private No<T> tamanhoLista;

    public void remove(int index){
        if(index >= this.tamanhoLista)
            throw new IndexOutOfBoundsException("O indice é maior que o tamanho da lista!");
        No<T> noAuxiliar = this.cauda;
        //check if node to be removed is tail of list
        if(index ==0){
            //if yes, mke the next node, the tail node
            this.cauda = this.cauda.getNoProximo();
            //link the head to the new tail
            this.cabeca.setNoProximo(this.cauda);
        }else if(index==1){
            this.cauda.setNoProximo(this.cauda.getNoProximo().getNoProximo());
        }else{
            //if index is neither 0 nor 1, loop through list up till node at given index
            for(int=0; i < index -1;i++){
                noAuxiliar = noAuxiliar.getNoProximo();
            }
            noAuxiliar.setNoProximo(noAuxiliar.getNoProximo().noAuxiliar.getNoProximo());
        }
        this.tamanhoLista--;
    }

    public T get(int index){
        return this.getNo(index).getConteudo();
    }

    private No<T> getNo(int index){
        if(this.isEmpty())
            throw new IndexOutOfBoundsException("A lista está vazia!");
        if(index == 0){
            return this.cauda;
        }
        No<T> noAuxiliar = this.cauda;
        for(int i = 0; (i < index) && (noAuxiliar != null); i++){
            noAuxiliar = noAuxiliar.getNoProximo();
        }

        return noAuxiliar;
    }

    public boolean isEmpty(){
        return this.tamanhoLista == 0 ? true: false;
    }

    public int size(){
        return this.tamanhoLista;
    }

}
