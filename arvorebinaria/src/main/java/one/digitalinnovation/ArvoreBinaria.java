package one.digitalinnovation;

public class ArvoreBinaria<T extends Comparable<T>> {
    private BinNo<T> raiz;

    public ArvoreBinaria(){
        this.raiz = null;
    }

    public void inserir(T conteudo){
        BinNo<T> novoNo = new BinNo<>(conteudo);
        //call the insert method below
        raiz = inserir(raiz, novoNo);
    }

    private BinNo<T> inserir(BinNo<T> atual, BinNo<T> novoNo){
        if(atual == null){
            return novoNo;
        }else if(novoNo.getConteudo().compareTo(atual.getConteudo()) < 0){
            //compareTo returns -1 if novoNo is less than atual and 1 if it is more than atual
            atual.setNoEsq(inserir(atual.getNoEsq(), novoNo));
        }else{
            atual.setNoDir(inserir(atual.getNoDir(), novoNo));
        }
        return atual;
    }
    public void exibirInOrdem(){
        System.out.println("\n Exibir InOrdem");
        exibirInOrdem(this.raiz);
    }
 private void exibirInOrdem(BinNo<T> atual){
        if(atual != null){
            exibirInOrdem(atual.getNoEsq());
            System.out.println(atual.getConteudo() + ", ");
            exibirInOrdem(atual.getNoDir());
        }
 }
 public void exibirPosOrdem(){
        System.out.println("\n Exibir PosOrdem");
        exibirPosOrdem(this.raiz);
    }
 private void exibirPosOrdem(BinNo<T> atual){
        if(atual != null){
            exibirPosOrdem(atual.getNoEsq());
            exibirPosOrdem(atual.getNoDir());
            System.out.println(atual.getConteudo() + ", ");

        }
 }
    public void exibirPreOrdem(){
        System.out.println("\n Exibir PreOrdem");
        exibirPreOrdem(this.raiz);
    }
    private void exibirPreOrdem(BinNo<T> atual){
        if(atual != null){

            System.out.println(atual.getConteudo() + ", ");
            exibirPreOrdem(atual.getNoEsq());
            exibirPreOrdem(atual.getNoDir());

        }
    }

    public void remover(T conteudo){
        try{
            BinNo<T> atual = this.raiz;
            BinNo<T> pai = null;
            BinNo<T> filho = null;
            BinNo<T> temp = null;
//while current node is not nill and not equal to 'conteudo' passed in as an argument,
            //keep running the while loop
            while (atual != null && !atual.getConteudo().equals(conteudo)){
             pai = atual;
             if(conteudo.compareTo(atual.getConteudo()) < 0){
              atual = atual.getNoEsq();
             }else{
                 atual = atual.getNoDir();
             }
            }
            if(atual == null){
                System.out.println("Conteudo nao encontrado. Bloco Try");
            }

            //.... raiz != null

        }catch (NullPointerException erro){
            System.out.println("Conteudo nao encontrado. Bloco Catch");
        }

    }


}
