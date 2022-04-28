package br.com.dio.collection.map;
/*
Dada a população estimada de alguns estados do nordeste brasileiro, faça:
 Estado = PE - população = 9.616.621
 Estado = AL - população = 3.351.543
 Estado = CE - população  = 9.187.103
 Estado = RN - população = 3.534.265
 */

import java.util.*;

import static javax.swing.UIManager.put;

public class ExercicioMap1 {
    public static void main(String[] args) {
        System.out.println("Crie um dicionário que relacione os estados e suas respectivas populações: ");
        Map<String, Integer> populaçãoEstados = new HashMap<>(){{
            put("PE",9616621);
            put("AL",3351543);
            put("CE",9187103);
            put("RN",3534265);
        }} ;
        System.out.println(populaçãoEstados);

        System.out.println("Substitua a população do estado RN por : 3.534.165");
        populaçãoEstados.put("RN",3534165);
        System.out.println(populaçãoEstados);

        System.out.println("Confira se o estado da Paraíba (PB)  está no dicionário, caso não, adicione " +
                "PB - 4.039.277: " + populaçãoEstados.containsKey("PB"));
             if(!populaçãoEstados.containsKey("PB"))  populaçãoEstados.put("PB",4039277);
                 System.out.println(populaçãoEstados.toString());

        System.out.println("Exiba a população do estado PE: " + populaçãoEstados.get("PE"));


        Map<String, Integer> populaçãoOrdemInfo = new LinkedHashMap<>(){{
            put("PE",9616621);
            put("AL",3351543);
            put("CE",9187103);
            put("RN",3534265);
        }} ;
        System.out.println("Exiba todos os estados e suas populaçãos na ordem em que foram informados: " + populaçãoOrdemInfo);

        System.out.println("Exiba todos os estados e suas populações na ordem alfabética: ");

        Map<String, Integer> populaçãoOrdemAlfabetica = new TreeMap<>(){{
            put("PE",9616621);
            put("AL",3351543);
            put("CE",9187103);
            put("RN",3534265);
        }} ;

        System.out.println(populaçãoOrdemAlfabetica);
        System.out.println("Exiba o estado com o menor população  e seu respectivo valor\n")  ;
        Integer menorPopulacao = Collections.min(populaçãoEstados.values());
        Set<Map.Entry<String, Integer>> populacoes = populaçãoEstados.entrySet();
        System.out.println("populacoes " + populacoes);
        String estadoMenorPopulacao = "";

        for (Map.Entry<String, Integer> populacao : populacoes) {
            if (populacao.getValue().equals(menorPopulacao)) {
                estadoMenorPopulacao = populacao.getKey();
                System.out.println("Estado com menor população: " + estadoMenorPopulacao + " - " + menorPopulacao);
            }
        }

        System.out.println("Exiba o estado com o maior população  e seu respectivo valor")  ;
        Integer maiorPopulacao = Collections.max(populaçãoEstados.values());

        String estadoMaiorPopulacao = "";

        for (Map.Entry<String, Integer> populacao : populacoes) {
            if (populacao.getValue().equals(maiorPopulacao)) {
                estadoMaiorPopulacao = populacao.getKey();
                System.out.println("Estado com maior população: " + estadoMaiorPopulacao + " - " + maiorPopulacao);
            }
        }

        Iterator<Integer> iterator = populaçãoEstados.values().iterator();
        Integer soma = 0;
        while(iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println("Exiba a soma da populacao destes estados: " + soma);
        System.out.println("Exiba a media da populacao destes estados: " + soma/populaçãoEstados.size());

        System.out.println(populaçãoEstados);
        System.out.println("Remova as populacoes com o populacao menor que 4000000: ");
        Iterator<Integer> iterator1 = populaçãoEstados.values().iterator();
        while(iterator1.hasNext()){
            if(iterator1.next() <4000000 ) iterator1.remove();
        }
        System.out.println(populaçãoEstados);

        //Apague o dicionario
        populaçãoEstados.clear();

        System.out.println("Confira se o dicionário está vazio: " + populaçãoEstados.isEmpty());
    }
}
