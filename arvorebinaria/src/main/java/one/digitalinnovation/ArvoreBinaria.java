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
        System.out.print("\n Exibir InOrdem: ");
        exibirInOrdem(this.raiz);
    }
 private void exibirInOrdem(BinNo<T> atual){
        if(atual != null){
            exibirInOrdem(atual.getNoEsq());
            System.out.print(atual.getConteudo() + ", ");
            exibirInOrdem(atual.getNoDir());
        }
 }
 public void exibirPosOrdem(){
        System.out.print("\n Exibir PosOrdem: ");
        exibirPosOrdem(this.raiz);
    }
 private void exibirPosOrdem(BinNo<T> atual){
        if(atual != null){
            exibirPosOrdem(atual.getNoEsq());
            exibirPosOrdem(atual.getNoDir());
            System.out.print(atual.getConteudo() + ", ");

        }
 }
    public void exibirPreOrdem(){
        System.out.print("\n Exibir PreOrdem: ");
        exibirPreOrdem(this.raiz);
    }
    private void exibirPreOrdem(BinNo<T> atual){
        if(atual != null){

            System.out.print(atual.getConteudo() + ", ");
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
//while current node is not null and not equal to 'conteudo' passed in as an argument,
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

            if(pai ==null){
               if(atual.getNoDir()==null){
                   this.raiz = atual.getNoEsq();
               }else if(atual.getNoEsq()==null){
                   this.raiz = atual.getNoDir();
               }else{
                   for(temp = atual, filho = atual.getNoEsq();
                       filho.getNoDir() != null;
                       temp = filho, filho = filho.getNoEsq()

                   ){
                     if(filho != atual.getNoEsq()){
                        temp.setNoDir(filho.getNoEsq());
                        filho.setNoEsq(raiz.getNoEsq());
                    }
                   }
                    filho.setNoDir(raiz.getNoDir());
                    raiz=filho;
               }
            }else if(atual.getNoDir()==null){
                if(pai.getNoEsq()==atual){
                    pai.setNoEsq(atual.getNoEsq());
                }else{
                    pai.setNoDir(atual.getNoEsq());
                }
            }else if(atual.getNoEsq()==null){
              if(pai.getNoEsq()==atual){
                  pai.setNoEsq(atual.getNoDir());
              }else{
                  pai.setNoDir(atual.getNoDir());
              }
            }else{
                for(
                        temp = atual, filho =atual.getNoEsq();
                        filho.getNoDir() != null;
                        temp = filho, filho = filho.getNoDir()
                ){
                    if(filho != atual.getNoEsq()){
                        temp.setNoDir(filho.getNoEsq());
                        filho.setNoEsq(atual.getNoEsq());
                    }

                    filho.setNoDir(atual.getNoDir());
                    if(pai.getNoEsq() == atual){
                        pai.setNoEsq(filho);
                    }else{
                        pai.setNoDir(filho);
                    }
                }

            }

            //.... raiz != null

        }catch (NullPointerException erro){
            System.out.println("Conteudo nao encontrado. Bloco Catch");
        }

    }


}
