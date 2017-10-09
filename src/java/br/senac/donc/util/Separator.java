// Classe responsável em coletar os dados referentes aos gastos dos vereadores no balancete mensal,
// disponíveis em um arquivo TXT previamente convertido de um PDF utilizando o algoritmo Falcon.
// Em desenvolvimento.

package br.senac.donc.util;

import br.senac.donc.model.Balancete;
import br.senac.donc.model.Vereador;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Separator {
    
    public static void main(String[] args) {

        Balancete balancete = new Balancete();
        Vereador vereador = new Vereador();

        //inserir o caminho do arquivo .txt no disco
        String pathFile = "/home/danilosetubal/Devlopment/repositories/olho-na-camara/falcon/sggpJaneiro2017.txt";

        System.out.printf("\nConteúdo do arquivo texto:\n");
        try {
            //o objeto arq lê o arquivo .txt
            FileReader arq = new FileReader(pathFile);
            //aqui ele armazena o conteudo na memoria
//            BufferedReader lerArq = new BufferedReader(arq);
            BufferedReader lerArq = new BufferedReader(new InputStreamReader(new FileInputStream(pathFile), "UTF8"));

            String linha; //= lerArq.readLine(); 
// lê a primeira linha
// a variável "linha" recebe o valor "null" quando o processo
// de repetição atingir o final do arquivo texto

            do {
                linha = lerArq.readLine(); // lê da segunda até a última linha

                System.out.printf("%s\n", linha);

//               captura do periodo 
                if (linha.equals("Período :")) {
                    balancete.setDataInicial(lerArq.readLine());
                    balancete.setDataFinal(lerArq.readLine());
                    System.out.println(balancete.getDataInicial());
                    String dataFim = balancete.getDataFinal().replace("a", "");
                    System.out.println(dataFim);
                }

                //Captura vereador
                if (linha.equals("Vereador :")) {
                    //pulando uma linha pois a linha apos Vereador é o codigo do vereador
                    lerArq.readLine();
                    vereador.setNomeCompleto(lerArq.readLine());
                    System.out.println(vereador.getNomeCompleto());

                }

                //captura gastos
                if (linha.equals("CREDITOS")) {

                    //pulando uma linha pois a linha apos CREDITOS é o saldo anterios
                    lerArq.readLine();

                    // atribui o dado recebido a uma string para depois converter para double
                    String cota = lerArq.readLine();
                    //tira a visgula pois double nao aceita virgula
                    cota = cota.replace(",", "");
                    Double cotaDouble = (Double.parseDouble(cota));
                    balancete.setCotaMensal(cotaDouble);
                    System.out.println("Creditos capturados: "+cotaDouble);
                }

                if (linha.equals("COTA MENSAL")) {
//
//                    //pulando uma linha pois a linha apos CREDITOS é o saldo anterios
//                    lerArq.readLine();
//
//                    // atribui o dado recebido a uma string para depois converter para double
//                    String cotaM = lerArq.readLine();
//                    //tira a visgula pois double nao aceita virgula
//                    cotaM = cotaM.replace(",", "");
//                    Double cotaDouble = (Double.parseDouble(cotaM));
//                    gastos.setCotaMensal(cotaDouble);
                  String line22 = Files.readAllLines(Paths.get(pathFile)).get(21);
                    System.out.println("Cota mensal capturada: " +line22);
                    break;
                }

            } while (linha != null);

           arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

        System.out.println();
    }
}