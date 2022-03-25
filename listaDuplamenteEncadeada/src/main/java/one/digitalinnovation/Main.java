package one.digitalinnovation;

public class Main {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada <String> novaListaDupla = new ListaDuplamenteEncadeada();

        novaListaDupla.add("c1");
        novaListaDupla.add("c2");
        novaListaDupla.add("c3");
        novaListaDupla.add("c4");
        novaListaDupla.add("c5");
        novaListaDupla.add("c6");
        novaListaDupla.add("c7");

        System.out.println(novaListaDupla);

        novaListaDupla.remove(3);
        System.out.println("depois de remover o No 3: " + novaListaDupla);

        novaListaDupla.add(3,"99");
        System.out.println("depois de adicionar " + "99" + " No Indice 3: " + novaListaDupla);
        System.out.println("get No no indice 3: " + novaListaDupla.get(3));


    }
}
