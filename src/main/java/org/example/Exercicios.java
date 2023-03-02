package org.example;

import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Exercicios {

    private static boolean debugMode = false;

    public static String fibonacci(int num) {
        int a = 0, b = 1, c = 1;
        boolean pertence = false;

        while(c <= num){
            if (c == num) {
                pertence = true;
                break;
            }
            a = b;
            b = c;
            c = a + b;
        }
        if (pertence) {
            return "Pertence";
        }
        return "Não pertence";
    }

    public static void FaturamentoDistribuidora() {
            // varavel responsavel por passar a leitura do arquivo para o tipo mais generico de objetico
            JSONParser parser = new JSONParser();

            // Lista criada para armazenar os valores de cada dia
            List<Double> valores = new ArrayList<>();

            Double soma = 0.0, menor = 0.0, maior = 0.0;
            int acimaMedia = 0;

            // leitura dos dados do arquivo json
            try {
                // Faz um cast para os dados recebidos entrarem em um array de informações
                JSONArray faturamento = (JSONArray) parser.parse(new FileReader("src/main/resources/dados.json"));

                if(debugMode) {
                    System.out.println(faturamento.size());
                    // verificando se todas as informações entram na lista
                }

                // For percorrendo cada elemento do array faturamento criado
                for (Object o : faturamento) {
                    JSONObject jsonInformacoes = (JSONObject) o;

                    Double valor = Double.parseDouble(jsonInformacoes.get("valor").toString());

                    if(valor > 0) {
                        valores.add(valor);
                        soma += valor;
                    }
                }

                 Double media = soma / valores.size();
                 if(debugMode) {
                     System.out.printf("Media: %.2f \n", media);
                 }
                 menor = Collections.min(valores);
                 maior = Collections.max(valores);

                // calcula o número de dias acima da média usando uma stream do Java 8

                 acimaMedia = (int) valores.stream().filter(v -> v > media).count();

                System.out.printf("Menor valor de faturamento: %.2f " +
                        "\nMaior valor de faturamento: %.2f " +
                        "\nNúmero de dias acima da média: %d " +
                        "\nMedia do faturamento: %.2f \n",
                        menor, maior, acimaMedia, media);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static void faturamentoMensal(List<EstadoValor> lista) {
            Map<String, Double> faturamentoMensal;
            faturamentoMensal = lista.stream().collect(Collectors.toMap(EstadoValor::getSigla, EstadoValor::getFaturamento));

            double faturamentoTotal = 0;
            for (double valor : faturamentoMensal.values()) {
                faturamentoTotal += valor;
            }

            System.out.println("Percentual de representação por estado:");

            for (String estado : faturamentoMensal.keySet()) {
                double percentual = (faturamentoMensal.get(estado) / faturamentoTotal) * 100;

                System.out.printf("%s: %.2f%%\n", estado, percentual);
            }
        }
        public static void reverseString(String stringReverter) {
            String revertida = "";
            for (int i = stringReverter.length() - 1; i >= 0; i--) {
                revertida += stringReverter.charAt(i);
            }
            System.out.println("String invertida: " + revertida);
        }
    }
