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
    }
}
