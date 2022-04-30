package br.com.dio.collection.map;
/*Dadas as seguintes informações  de id e contato, crie um dicionário e
ordene este dicionário exibindo (Nome id - Nome contato);
id = 1 - Contato = nome: Simba, numero: 2222;
id = 4 - Contato = nome: Cami, numero: 5555;
id = 3 - Contato = nome: Jon, numero: 1111;  */

import java.util.*;

import static javax.swing.UIManager.put;

public class ExercicioMap3 {
    public static void main(String[] args) {
        System.out.println("--\tOrdem aleatória\t--");
        Map<Integer, Contato> agenda = new HashMap<>() {{
            put(1, new Contato("Simba", 2222));
            put(4, new Contato("Cami", 5555));
            put(3, new Contato("Jon", 1111));
        }}   ;

        for (Map.Entry<Integer, Contato> contato : agenda.entrySet())
            System.out.println(contato.getKey() + " - " + contato.getValue().getNome());


        System.out.println("--\tOrdem Inserção\t--");

        Map<Integer, Contato> agendaOrdemInsercao = new LinkedHashMap<>() {{
            put(1, new Contato("Simba", 2222));
            put(4, new Contato("Cami", 5555));
            put(3, new Contato("Jon", 1111));
        }}   ;

        for (Map.Entry<Integer, Contato> contato : agendaOrdemInsercao.entrySet())
            System.out.println(contato.getKey() + " - " + contato.getValue().getNome());

        System.out.println("--\tOrdem id\t--");

        Map<Integer, Contato> agendaOrdemId = new TreeMap<>() {{
            put(1, new Contato("Simba", 2222));
            put(4, new Contato("Cami", 5555));
            put(3, new Contato("Jon", 1111));
        }}   ;

        for (Map.Entry<Integer, Contato> contato : agendaOrdemId.entrySet())
            System.out.println(contato.getKey() + " - " + contato.getValue().getNome());

        System.out.println("--\tOrdem número telefone\t--");

        Set<Map.Entry<Integer, Contato>> agendaOrdemTelefones = new TreeSet<>(new ComparatorNumeroTelefone());
        agendaOrdemTelefones.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> contato : agendaOrdemTelefones)
            System.out.println(contato.getKey() + " - " + contato.getValue().getNumero());

        System.out.println("--\tOrdem nome contato\t--");    
        Set<Map.Entry<Integer, Contato>> agendaOrdemNomesContato = new TreeSet<>(new ComparatorNomeContato());
        agendaOrdemNomesContato.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> contato : agendaOrdemNomesContato)
            System.out.println(contato.getKey() + " - " + contato.getValue().getNome());
    }


}


class ComparatorNumeroTelefone implements Comparator<Map.Entry<Integer, Contato>> {

    @Override
    public int compare(Map.Entry<Integer, Contato> c1, Map.Entry<Integer, Contato> c2) {
        return c1.getValue().getNumero().compareTo(c2.getValue().getNumero());
    }
}

class ComparatorNomeContato implements Comparator<Map.Entry<Integer, Contato>> {

    @Override
    public int compare(Map.Entry<Integer, Contato> c1, Map.Entry<Integer, Contato> c2) {
        return c1.getValue().getNome().compareToIgnoreCase(c2.getValue().getNome());
    }
}