package one.digitalinnovation;

public class Main {
    public static void main(String[] args) {
        ListaCircular <String> minhaListaCircular = new ListaCircular<>();

        minhaListaCircular.add("c0");
        System.out.println(minhaListaCircular);

        minhaListaCircular.remove(0);
        System.out.println(minhaListaCircular);

        minhaListaCircular.add("c1");
        System.out.println("depois de adicionar c1: " + minhaListaCircular);

        minhaListaCircular.add("c2");


        minhaListaCircular.add("c3");
        System.out.println("depois de adicionar c2 e c3: " + minhaListaCircular);

        System.out.println("Elemento de indice 0: " + minhaListaCircular.get(0));
        System.out.println("Elemento de indice 1: " + minhaListaCircular.get(1));

        for(int i=0; i<=20; i++){
            System.out.println("Elemento de indice " + i + ": " + minhaListaCircular.get(i));
        }
    }



    }

