package one.digitalinnovation;

public class ListaCircular<T> {

    private No<T> cabeca;
    private No<T> cauda;
    private int tamanhoLista;

    public ListaCircular() {
        this.cauda = null;
        this.cabeca = null;
        this.tamanhoLista = 0;
    }

    public void add(T conteudo){
        No <T> novoNo = new No<>(conteudo);
        if(this.tamanhoLista == 0){
            this.cabeca = novoNo;
            this.cauda = this.cabeca;
            this.cabeca.setNoProximo(cauda);
        }else{
            //if list is not empty, attach new node to tail
            novoNo.setNoProximo(this.cauda);
            //set head node's next node to new node
            this.cabeca.setNoProximo(novoNo);
            //set tail node to new node
            this.cauda = novoNo;
        }

        this.tamanhoLista++;
    }

    public void remove(int index){
        if(index >= this.tamanhoLista)
            throw new IndexOutOfBoundsException("O indice é maior que o tamanho da lista!");
        No<T> noAuxiliar = this.cauda;
        //check if node to be removed is tail of list
        if(index ==0){
            //if yes, make the next node, the tail node
            this.cauda = this.cauda.getNoProximo();
            //link the head to the new tail
            this.cabeca.setNoProximo(this.cauda);
        }else if(index==1){
            this.cauda.setNoProximo(this.cauda.getNoProximo().getNoProximo());
        }else{
            //if index is neither 0 nor 1, loop through list up till node at given index
            for(int i=0; i < index -1;i++){
                noAuxiliar = noAuxiliar.getNoProximo();
            }
            noAuxiliar.setNoProximo(noAuxiliar.getNoProximo().getNoProximo());
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
        return this.tamanhoLista == 0;
    }

    public int size(){
        return this.tamanhoLista;
    }


    @Override
    public String toString() {
        String strRetorno = "";

        No<T> noAuxiliar = this.cauda;
        for(int i = 0;i < this.size(); i++){
            strRetorno += "[No{conteudo=" + noAuxiliar.getConteudo() + "}]--->";
            noAuxiliar = noAuxiliar.getNoProximo();
        }

        strRetorno += this.size() != 0 ? "(Retorna ao inicio)" :"[]";
        return strRetorno;
    }
}
