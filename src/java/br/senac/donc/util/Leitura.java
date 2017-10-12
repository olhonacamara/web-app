/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.donc.util;

import br.senac.donc.model.Balancete;
import br.senac.donc.model.Vereador;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Leitura {

    public static void main(String[] args) {

        Balancete balancete = new Balancete();
        Vereador vereador = new Vereador();
        
        int cont = 0;
        int contVereador = 0;

        //como ler através da contagem de linhas?:
        //String line22 = Files.readAllLines(Paths.get("/Volumes/Macintosh_HD/tiagomeurer/Desktop/test.txt")).get(21);
        //inserir o caminho do arquivo .txt no disco
        String caminho = "src/java/br/senac/donc/util/balanceteTXT.txt";
        
        System.out.printf("\nConteúdo do arquivo extraido do .txt:\n");
        
        try {
            
            //o objeto arq lê o arquivo .txts
            FileReader arq = new FileReader(caminho);
            //aqui ele armazena o conteudo na memoria
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = null; //= lerArq.readLine(); 

            // lê a primeira linha
            // a variável "linha" recebe o valor "null" quando o processo
            // de repetição atingir o final do arquivo texto
            do {
                linha = lerArq.readLine(); // lê da segunda até a última linha

                if (linha != null) {
                    if (linha.equals("Vereador :")) {
                        cont++;
                        System.out.println("");
                        System.out.println("Pagina " + cont);
                    }

                    //captura do periodo 
                    // Padrão MySQL AAAA/MM/DD
                    {
                        if (linha.equals("Período :")) {

                            
                            String dataInicialString = lerArq.readLine();
                            String dataFinalString = lerArq.readLine().replace("a", "");
                            System.out.println("Data Inicial:" + dataInicialString + 
                                    "\nData Final: " + dataFinalString);

                            Date dataInicio = null;
                            Date dataFinal = null;
                            String dataInicial = new String(lerArq.readLine());
                            String dataFim = new String(lerArq.readLine());
                            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                            format.setLenient(false);
                            try {
                                dataInicio = format.parse(dataInicialString);
                                dataFinal = format.parse(dataFinalString);
                            } catch (ParseException ex) {
                                ex.printStackTrace();
                            }
                            balancete.setDataFinal(dataFinal);
                            balancete.setDataInicial(dataInicio);
                            System.out.println("Capturou o perido de "
                                    + balancete.getDataInicial() + " à " + balancete.getDataFinal());
                        }
                    }

                    //Captura vereador
                    if (linha.equals("Vereador :")) {
                        //pulando uma linha pois a linha apos Vereador é o codigo do vereador
                        lerArq.readLine();
                        vereador.setNomeCompleto(lerArq.readLine());
                        System.out.println("Vereador: " + vereador.getNomeCompleto());
                        contVereador++;
                    }

                    //captura gastos cota mensal
                    if (linha.equals("Mês")) {
                        // atribui o dado recebido a uma string para depois converter para double
                        String cota = lerArq.readLine();
                        //tira a virgula pois double nao aceita virgula
                        cota = cota.replace(",", "");
                        Double cotaDouble = (Double.parseDouble(cota));
                        balancete.setCotaMensal(cotaDouble);
                        System.out.println("Valor capturado de CREDITOS: " + balancete.getCotaMensal());

                    }

                    //Capturando a linha *OUTROS*
                    if (linha.equals("OUTROS")) {
                        String outros = lerArq.readLine();
                        outros = outros.replace(",", "");
                        Double outrosDouble = (Double.parseDouble(outros));
                        balancete.setOutros1(outrosDouble);
                        System.out.println("Valor capturado de COTA: " + balancete.getOutros1());
                    }

                    //captura a linha *CREDITO ANO ANTERIOR*
                    if (linha.equals("OUTROS")) {
                        lerArq.readLine();
                        String anoAnterior = lerArq.readLine();
                        anoAnterior = anoAnterior.replace(",", "");
                        Double anoAnteriorDouble = (Double.parseDouble(anoAnterior));
                        balancete.setAnoAnterior(anoAnteriorDouble);
                        System.out.println("Valor capturado de CREDITO DE ANO ANTERIOR: " + balancete.getAnoAnterior());
                    }

                    //capturando a linha *DEBITOS*
                    if (linha.equals("Credito ano anterior")) {
                        lerArq.readLine();
                        lerArq.readLine();
                        String debitos = lerArq.readLine();
                        debitos = debitos.replace(",", "");
                        Double debitosDouble = (Double.parseDouble(debitos));
                        balancete.setDebitos(debitosDouble);
                        System.out.println("Valor capturado de DÉBITOS: " + balancete.getDebitos());
                    }

                    //capturando a linha *BOLSA/ESTAGIO*
                    if (linha.equals("DEBITOS")) {
                        lerArq.readLine();
                        lerArq.readLine();
                        String bolsaEstagio = lerArq.readLine();
                        bolsaEstagio = bolsaEstagio.replace(",", "");
                        Double bolsaEstagioDouble = (Double.parseDouble(bolsaEstagio));
                        balancete.setBolsaEstagio(bolsaEstagioDouble);
                        System.out.println("Valor capturado de BOLSA/ESTAGIO: " + balancete.getBolsaEstagio());
                    }

                    //capturando a linha *PASSAGENS*
                    if (linha.equals("Bolsa / Estágio")) {
                        lerArq.readLine();
                        lerArq.readLine();
                        String passagens = lerArq.readLine();
                        passagens = passagens.replace(",", "");
                        Double passagensDouble = (Double.parseDouble(passagens));
                        balancete.setPassagens(passagensDouble);
                        System.out.println("Valor capturado de PASSAGENS: " + balancete.getPassagens());
                    }

                    //capturando a linha *Telefone Fixo (GVT)*
                    if (linha.equals("Passagens")) {
                        lerArq.readLine();
                        lerArq.readLine();
                        String fixo = lerArq.readLine();
                        fixo = fixo.replace(",", "");
                        Double fixoDouble = (Double.parseDouble(fixo));
                        balancete.setTelefoneFixo(fixoDouble);
                        System.out.println("Valor capturado de TELEFONE FIXO: " + balancete.getTelefoneFixo());
                    }

                    //capturando a linha *XEROX*
                    if (linha.equals("Telefone Fixo (GVT)")) {
                        lerArq.readLine();
                        lerArq.readLine();
                        String xerox = lerArq.readLine();
                        xerox = xerox.replace(",", "");
                        Double xeroxDouble = (Double.parseDouble(xerox));
                        balancete.setXerox(xeroxDouble);
                        System.out.println("Valor capturado de XEROX: " + balancete.getXerox());
                    }

                    //capturando a linha *CORREIO*
                    if (linha.equals("Xerox")) {
                        lerArq.readLine();
                        lerArq.readLine();
                        String correio = lerArq.readLine();
                        correio = correio.replace(",", "");
                        Double correioDouble = (Double.parseDouble(correio));
                        balancete.setCorreio(correioDouble);
                        System.out.println("Valor capturado de CORREIO: " + balancete.getCorreio());
                    }

                    //capturando a linha *Material de Expediente*
                    if (linha.equals("Correio")) {
                        lerArq.readLine();
                        lerArq.readLine();
                        String materialExpediente = lerArq.readLine();
                        materialExpediente = materialExpediente.replace(",", "");
                        Double materialExpedienteDouble = (Double.parseDouble(materialExpediente));
                        balancete.setMaterialExpediente(materialExpedienteDouble);
                        System.out.println("Valor capturado de MATERIAL DE EXPEDIENTE: " + balancete.getMaterialExpediente());
                    }

                    //capturando a linha *Diarias*
                    if (linha.equals("Material de Expediente")) {
                        lerArq.readLine();
                        lerArq.readLine();
                        String diarias = lerArq.readLine();
                        diarias = diarias.replace(",", "");
                        Double diariasDouble = (Double.parseDouble(diarias));
                        balancete.setDiarias(diariasDouble);
                        System.out.println("Valor capturado de DIARIAS: " + balancete.getDiarias());
                    }

                    //capturando a linha *Gratificação*
                    if (linha.equals("Diárias")) {
                        lerArq.readLine();
                        lerArq.readLine();
                        String gratificacao = lerArq.readLine();
                        gratificacao = gratificacao.replace(",", "");
                        Double gratificacaoDouble = (Double.parseDouble(gratificacao));
                        balancete.setGratificacao(gratificacaoDouble);
                        System.out.println("Valor capturado de GRATIFICAÇÃO: " + balancete.getGratificacao());
                    }

                    //capturando a linha *OUTROS*
                    if (linha.equals("Gratificação")) {
                        lerArq.readLine();
                        lerArq.readLine();
                        String outros2 = lerArq.readLine();
                        outros2 = outros2.replace(",", "");
                        Double outros2Double = (Double.parseDouble(outros2));
                        balancete.setOutros2(outros2Double);
                        System.out.println("Valor capturado de OUTROS: " + balancete.getOutros2());
                    }

                    //capturando a linha *Selos*
                    if (linha.equals("2.09")) {
                        lerArq.readLine();
                        lerArq.readLine();
                        lerArq.readLine();
                        String selos = lerArq.readLine();
                        selos = selos.replace(",", "");
                        Double selosDouble = (Double.parseDouble(selos));
                        balancete.setSelos(selosDouble);
                        System.out.println("Valor capturado de Selos: " + balancete.getSelos());
                    }

                    //capturando a linha *Serviços*
                    if (linha.equals("Selos")) {
                        lerArq.readLine();
                        lerArq.readLine();
                        String servicos = lerArq.readLine();
                        servicos = servicos.replace(",", "");
                        Double servicosDouble = (Double.parseDouble(servicos));
                        balancete.setServicos(servicosDouble);
                        System.out.println("Valor capturado de Serviços: " + balancete.getServicos());
                    }

                    //capturando a linha *Telefone TIM*
                    if (linha.equals("Serviços")) {
                        lerArq.readLine();
                        lerArq.readLine();
                        String telefoneMovel = lerArq.readLine();
                        telefoneMovel = telefoneMovel.replace(",", "");
                        Double telefoneMovelDouble = (Double.parseDouble(telefoneMovel));
                        balancete.setTelefoneMovel(telefoneMovelDouble);
                        System.out.println("Valor capturado de Telefone - TIM: " + balancete.getTelefoneMovel());
                    }

                    //capturando a linha *Cursos*
                    if (linha.equals("Telefone - TIM")) {
                        lerArq.readLine();
                        lerArq.readLine();
                        String cursos = lerArq.readLine();
                        cursos = cursos.replace(",", "");
                        Double cursosDouble = (Double.parseDouble(cursos));
                        balancete.setCursos(cursosDouble);
                        System.out.println("Valor capturado de Cursos: " + balancete.getCursos());
                    }

                    //capturando a linha *Carimbos*
                    if (linha.equals("Cursos")) {
                        lerArq.readLine();
                        lerArq.readLine();
                        String carimbos = lerArq.readLine();
                        carimbos = carimbos.replace(",", "");
                        Double carimbosDouble = (Double.parseDouble(carimbos));
                        balancete.setCarimbos(carimbosDouble);
                        System.out.println("Valor capturado de Carimbos: " + balancete.getCarimbos());
                    }

//                //capturando a linha *Ligação Interurbano (B.TELECOM/EMBRATEL)*
                    if (linha.equals("Carimbos")) {
                        int i = 0;
                        if (i < 8) {
                            lerArq.readLine();

                        }
                        String interurbano = lerArq.readLine();
                        interurbano = interurbano.replace(",", "");
                        Double interurbanoDouble = (Double.parseDouble(interurbano));
                        balancete.setInterurbano(interurbanoDouble);
                        System.out.println("Valor capturado de Ligação Interurbano (B.TELECOM/EMBRATEL): " + balancete.getInterurbano());
                        i = i++;
                    }

                    //capturando a linha *Débito ano anterior*
                    if (linha.equals("Ligação Interurbano (B.TELECOM/EMBRATEL)")) {
                        lerArq.readLine();
                        lerArq.readLine();
                        String debitoAnoAnterior = lerArq.readLine();
                        debitoAnoAnterior = debitoAnoAnterior.replace(",", "");
                        Double debitoAnoAnteriorDouble = (Double.parseDouble(debitoAnoAnterior));
                        balancete.setDebitoAnoAnterior(debitoAnoAnteriorDouble);
                        System.out.println("Valor capturado de Débito ano anterior: " + balancete.getDebitoAnoAnterior());
                    }

                    //capturando a linha *Jornal/Revista*
                    if (linha.equals("Débito ano anterior")) {
                        lerArq.readLine();
                        lerArq.readLine();
                        String jornalRevista = lerArq.readLine();
                        jornalRevista = jornalRevista.replace(",", "");
                        Double jornalRevistaDouble = (Double.parseDouble(jornalRevista));
                        balancete.setJornalRevista(jornalRevistaDouble);
                        System.out.println("Valor capturado de Jornal/Revista: " + balancete.getJornalRevista());
                    }

                    //capturando a linha *Saldo anterior*
                    if (linha.equals("Saldo Anterior :")) {
                        String saldoAnterior = lerArq.readLine();
                        Double saldoAnteriorDouble;
                        balancete.setAnoAnterior(saldoAnteriorDouble = replaceDouble(saldoAnterior));
                        System.out.println("Valor capturado de Saldo anterior: " + balancete.getAnoAnterior());
                    }

                    //capturando a linha *Saldo Acumulado*
                    if (linha.equals("Saldo Acumulado:")) {
                        String saldoAcumulado = lerArq.readLine();
                        Double saldoAcumuladoDouble;
                        balancete.setSaldoAcumulado(saldoAcumuladoDouble = replaceDouble(saldoAcumulado));
                        System.out.println("Valor capturado de Saldo Acumulado: " + balancete.getSaldoAcumulado());
                    }

                    //capturando a linha *Creditos no Mes*
                    if (linha.equals("Créditos no Mês :")) {
                        lerArq.readLine();
                        String creditosMes = lerArq.readLine();
                        Double creditosMesDouble;
                        balancete.setCreditosMes(creditosMesDouble = replaceDouble(creditosMes));
                        System.out.println("Valor capturado de Creditos Mês: " + balancete.getCreditosMes());
                    }

                    //capturando a linha *Debitos no Mes*
                    if (linha.equals("Débitos no Mês :")) {
                        String debitosMes = lerArq.readLine();
                        Double debitosMesDouble;
                        balancete.setDebitosMes(debitosMesDouble = replaceDouble(debitosMes));
                        System.out.println("Valor capturado de Debitos Mês: " + balancete.getDebitosMes());

                    }
                }

            } while (linha != null);

            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        //imprime a quantidade de vezes que o codigo passou pela captura de vereadores
        System.out.println("O codigo percorreu um total de " + contVereador + " vereadores.");
        //criar um metodo para realizar a conversão de String para Double   
        //criar método para o replace de "," para ""

    }

    public static Double replaceDouble(String valor) {
        String valorReplace = valor.replace(",", "");
        if (valorReplace.contains("(") && valorReplace.contains(")")) {
            valorReplace = valorReplace.replace("(", "");
            valorReplace = valorReplace.replace(")", "");
        }
        Double valorDouble = (Double.parseDouble(valorReplace));
        return valorDouble;
    }
}