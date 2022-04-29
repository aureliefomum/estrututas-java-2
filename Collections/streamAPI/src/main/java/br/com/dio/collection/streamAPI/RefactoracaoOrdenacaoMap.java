package br.com.dio.collection.streamAPI;
/*Dadas as seguintes informações  de id e contato, crie um dicionário e
ordene este dicionário exibindo (Nome id - Nome contato);
id = 1 - Contato = nome: Simba, numero: 2222;
id = 4 - Contato = nome: Cami, numero: 5555;
id = 3 - Contato = nome: Jon, numero: 1111;  */

import java.util.*;
import java.util.function.Function;

public class RefactoracaoOrdenacaoMap {
    public static void main(String[] args) {
        System.out.println("--\tOrdem aleatória\t--");
        Map<Integer, Contato> agenda = new HashMap<>() {{
            put(1, new Contato("Simba", 2222));
            put(4, new Contato("Cami", 5555));
            put(3, new Contato("Jon", 1111));
        }};

        for (Map.Entry<Integer, Contato> contato : agenda.entrySet())
            System.out.println(contato.getKey() + " - " + contato.getValue().getNome());


        System.out.println("--\tOrdem Inserção\t--");

        Map<Integer, Contato> agendaOrdemInsercao = new LinkedHashMap<>() {{
            put(1, new Contato("Simba", 2222));
            put(4, new Contato("Cami", 5555));
            put(3, new Contato("Jon", 1111));
        }};

        for (Map.Entry<Integer, Contato> contato : agendaOrdemInsercao.entrySet())
            System.out.println(contato.getKey() + " - " + contato.getValue().getNome());

        System.out.println("--\tOrdem id\t--");

        Map<Integer, Contato> agendaOrdemId = new TreeMap<>() {{
            put(1, new Contato("Simba", 2222));
            put(4, new Contato("Cami", 5555));
            put(3, new Contato("Jon", 1111));
        }};

        for (Map.Entry<Integer, Contato> contato : agendaOrdemId.entrySet())
            System.out.println(contato.getKey() + " - " + contato.getValue().getNome());

        System.out.println("--\tOrdem número telefone\t--");
          //utilizando uma Anonymous Class
        /*Set<Map.Entry<Integer, Contato>> agendaOrdemTelefones = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {
            @Override
            public int compare(Map.Entry<Integer, Contato> c1, Map.Entry<Integer, Contato> c2) {*/
                /*return c1.getValue().getNumero().compareTo(c2.getValue().getNumero());*/
                /*return Integer.compare(c1.getValue().getNumero(), c2.getValue().getNumero());
            }
        });*/

        //Utilizando uma functional interface passado dentro do metodo 'Comparing' do 'Comparator'
        /*Set<Map.Entry<Integer, Contato>> agendaOrdemTelefones =
                new TreeSet<> (Comparator.comparing(new Function<Map.Entry<Integer, Contato>, Integer>() {
                    @Override
                    public Integer apply(Map.Entry<Integer, Contato> cont) {
                        return cont.getValue().getNumero();
                    }
                })) ;*/

        //Utilizando um 'Lambda' suntax:(argumento -> corpo do código)
        Set<Map.Entry<Integer, Contato>> agendaOrdemTelefones =
                new TreeSet<> (Comparator.comparing( cont -> cont.getValue().getNumero()));
                            agendaOrdemTelefones.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> contato : agendaOrdemTelefones)
            System.out.println(contato.getKey() + " - " + contato.getValue().getNumero() + ": " +
                    "" + contato.getValue().getNome()) ;

        System.out.println("--\tOrdem nome contato\t--");
        Set<Map.Entry<Integer, Contato>> agendaOrdemNomesContato =
                new TreeSet<>(Comparator.comparing(cont -> cont.getValue().getNome()));
        agendaOrdemNomesContato.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> contato : agendaOrdemNomesContato)
            System.out.println(contato.getKey() + " - " + contato.getValue().getNome());

    }
}



/*class ComparatorNumeroTelefone implements Comparator<Map.Entry<Integer, Contato>> {

    @Override
    public int compare(Map.Entry<Integer, Contato> c1, Map.Entry<Integer, Contato> c2) {
        return c1.getValue().getNumero().compareTo(c2.getValue().getNumero());
    }
}       */

class Contato {
    private String nome;
    private Integer numero;

    public Contato(String nome, Integer numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public Integer getNumero() {
        return numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return nome.equals(contato.nome) && numero.equals(contato.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, numero);
    }

    @Override
    public String toString() {
        return "Contato{" +
                "nome='" + nome + '\'' +
                ", numero=" + numero +
                '}';
    }
}

class ComparatorNomeContato implements Comparator<Map.Entry<Integer, Contato>> {

    @Override
    public int compare(Map.Entry<Integer, Contato> c1, Map.Entry<Integer, Contato> c2) {
        return c1.getValue().getNome().compareToIgnoreCase(c2.getValue().getNome());
    }
}
