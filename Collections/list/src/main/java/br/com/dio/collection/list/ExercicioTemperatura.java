package br.com.dio.collection.list;
/*Faça um programa que receba a temperatura média os 6 primeiros meses do ano e armazene-as em uma lista.
Após isto, calcule a média semestral das temperaturas e mostre todas as temperaturas acima desta média,
e em que mês elas ocorreram (mostrar o mês por extenso: 1 – Janeiro, 2 – Fevereiro e etc).
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExercicioTemperatura {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Double> temperaturas = new ArrayList<>();


        int tempCount = 0;
        while (true)  {
            if(tempCount == 6)   break;
            System.out.println("Digite a temperatura: ");
            double temp = scan.nextDouble();
            temperaturas.add(temp);
            tempCount++;

        }

        System.out.println(temperaturas);

    }

}
