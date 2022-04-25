package br.com.dio.collection.set;
/*
Crie uma conjunto contendo as cores do arco-íris e:
a) Exiba todas as cores o arco-íris uma abaixo da outra;
b) A quantidade de cores que o arco-íris tem;
c) Exiba as cores em ordem alfabética;
d) Exiba as cores na ordem inversa da que foi informada;
e) Exiba todas as cores que começam com a letra ”v”;
f) Remova todas as cores que não começam com a letra “v”;
g) Limpe o conjunto;
h) Confira se o conjunto está vazio;
 */

import java.util.*;

public class ExercicioSet1 {
    public static void main(String[] args) {
        System.out.println("Crie uma conjunto contendo as cores do arco-íris e:");
        Set<String> cores = new HashSet<>(Arrays.asList("vermelha", "laranja", "amarela", "verde", "azul", "azul-escuro","violeta"));
        System.out.println("Exiba todas as cores do arco-íris uma abaixo da outra");
        System.out.println("----Cores do Arco-Íris----");
        Iterator<String> iterator = cores.iterator();
        while(iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
        System.out.println("A quantidade de cores que o arco-íris tem");
        System.out.println("O arco-íris tem " + cores.size() + " cores");

        System.out.println("Exiba as cores em ordem alfabética");

        System.out.println("--\tOrdem alfabética (Cores Arco-Íris)\t--");
        Set<String> cores2 = new TreeSet<>(Arrays.asList("vermelha", "laranja", "amarela", "verde", "azul", "azul" +
                "-escuro","violeta"));
        for (String cor: cores2) System.out.println(cor);

        System.out.println("Exiba as cores na ordem inversa da que foi informada");
        System.out.println("--\tOrdem inversa de inserção (Cores Arco-Íris)\t--");
        Set<String> cores3 = new LinkedHashSet<>(Arrays.asList("vermelha", "laranja", "amarela", "verde", "azul", "azul" +
                "-escuro","violeta"));
        //converter cores3 em collection, ArrayList
        ArrayList<String> coresInvertido =
                new ArrayList<String>(cores3);
        //Usar a Collections framework para inverter
         Collections.reverse(coresInvertido);
         //Exibir a set invertida
        for (String cor: coresInvertido) System.out.println(cor);

        System.out.println("Exiba todas as cores que começam com a letra ”v”;");
        for(String cor: cores){
            if(cor.startsWith("v"))  System.out.println(cor);
        }

        System.out.println("Remova todas as cores que não começam com a letra 'v'");
        Set<String> coresSemV = new HashSet<>(Arrays.asList("vermelha", "laranja", "amarela", "verde", "azul", "azul" +
                "-escuro","violeta"));

        Iterator<String> iteratorNew = coresSemV.iterator();
        while(iteratorNew.hasNext()) {
            String next = iteratorNew.next();
            if(!next.startsWith("v"))
            iteratorNew.remove()  ;
        }
        System.out.println(coresSemV);

        System.out.println("Limpe o conjunto") ;
        cores.clear() ;
        System.out.println("Confira se o conjunto está vazio: " + cores.isEmpty());
        
    }
}

 
