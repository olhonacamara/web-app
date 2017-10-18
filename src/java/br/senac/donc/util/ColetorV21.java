package br.senac.donc.util;

import br.senac.donc.dao.BalanceteDAOImpl;
import br.senac.donc.model.Balancete;
import br.senac.donc.model.Vereador;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.Session;

/* Classe responsável por coletar os dados de gastos dos vereadores dos arquivos
/* de texto previamente convertidos pelo Falcon e armazená-los no banco de dados. */
public class ColetorV21 {

    public static void main(String[] args) {
        
        Vereador vereador = new Vereador();
        
        int contVereador = 0;

        // Caminho completo do diretório onde estão os relatórios .txt
        String pathRelatorios = "/home/danilosetubal/Devlopment/repositories/olho-na-camara/"+
                "web-app/src/java/br/senac/donc/util/relatorios/2017/";
        
        File f = null;
        String[] paths;
        
        try {
            f = new File(pathRelatorios);
            paths = f.list();
            
            // Percorre todos os arquivos contidos no diretório.
            for (String pathFile : paths) {

                FileReader arquivo = new FileReader(pathRelatorios+pathFile);
                BufferedReader lerArquivo = new BufferedReader(arquivo);
                
                System.out.println("");
                System.out.println("####################################"
                        + "#################");
                System.out.println("Início da coleta do arquivo: " + pathFile);
                System.out.println("####################################"
                        + "#################");
                
                colector(arquivo, lerArquivo);
                
                arquivo.close();
            }
        } catch(IOException e) {
            System.out.println("O caminho especificado não contém arquivos disponiveis e/ou está incorreto."
                    + "\n Verifique se o caminho está acessível, correto e/ou contém arquivos disponíveis.");
            e.printStackTrace();
        }
        
        //imprime a quantidade de vezes que o codigo passou pela captura de vereadores
        System.out.println("O codigo percorreu um total de " + contVereador + " vereadores.");
        //criar um metodo para realizar a conversão de String para Double   
        //criar método para o replace de "," para ""

        // TODO: Verificar por que a session não está sendo encerrada.
        //session.close();
    }
    
    public static boolean colector(FileReader arquivo, BufferedReader lerArquivo) throws IOException {
        
        // Abre a sessão pra armazenar o balancete lido no banco de dados;
        Session session;
        session = HibernateUtil.abrirSessao();
        
         String linha = null;
         int i = 1;
         int contVereador = 0;
         
         Balancete balancete = new Balancete();
         
         do {            
            linha = lerArquivo.readLine();
            
            if (linha != null) {
                
                // Lê e coleta o nome do vereador.
                if (linha.equals("Vereador :")) {
                    lerArquivo.readLine();
                    System.out.println("Vereador: "+ "(" + i++ + ")" + ": " + lerArquivo.readLine());
                }
                
                
                if (linha.equals("Período :")) {
                            Date dataInicio = null;
                            Date dataFinal = null;
                            String dataInicial = new String(lerArquivo.readLine());
                            String dataFim = new String(lerArquivo.readLine().replace("a", ""));
                            
                            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                            
                            try {
                                dataInicio = format.parse(dataInicial);
                                dataFinal = format.parse(dataFim);
                            } catch (ParseException ex) {
                                ex.printStackTrace();
                            }
                            balancete.setDataFinal(dataFinal);
                            balancete.setDataInicial(dataInicio);
                            
                            System.out.println("Capturou o perido de "
                                    +dataInicial + " à " + dataFim);                                    
                }
                
                    if (linha.equals("Mês")) {
                        String cota = lerArquivo.readLine();
                        cota = cota.replace(",", "");
                        Double cotaDouble = (Double.parseDouble(cota));
                        balancete.setCotaMensal(cotaDouble);
                        System.out.println("Valor capturado de CREDITOS: " + balancete.getCotaMensal());
                    }
                    
                    if (linha.equals("OUTROS")) {
                        String outros = lerArquivo.readLine();
                        outros = outros.replace(",", "");
                        Double outrosDouble = (Double.parseDouble(outros));
                        balancete.setOutros1(outrosDouble);
                        System.out.println("Valor capturado de COTA: " + balancete.getOutros1());
                    }

                    if (linha.equals("OUTROS")) {
                        lerArquivo.readLine();
                        String anoAnterior = lerArquivo.readLine();
                        anoAnterior = anoAnterior.replace(",", "");
                        Double anoAnteriorDouble = (Double.parseDouble(anoAnterior));
                        balancete.setAnoAnterior(anoAnteriorDouble);
                        System.out.println("Valor capturado de CREDITO DE ANO ANTERIOR: " + balancete.getAnoAnterior());
                    }

                    if (linha.equals("Credito ano anterior")) {
                        lerArquivo.readLine();
                        lerArquivo.readLine();
                        String debitos = lerArquivo.readLine();
                        debitos = debitos.replace(",", "");
                        Double debitosDouble = (Double.parseDouble(debitos));
                        balancete.setDebitos(debitosDouble);
                        System.out.println("Valor capturado de DÉBITOS: " + balancete.getDebitos());
                    }

                    if (linha.equals("DEBITOS")) {
                        lerArquivo.readLine();
                        lerArquivo.readLine();
                        String bolsaEstagio = lerArquivo.readLine();
                        bolsaEstagio = bolsaEstagio.replace(",", "");
                        Double bolsaEstagioDouble = (Double.parseDouble(bolsaEstagio));
                        balancete.setBolsaEstagio(bolsaEstagioDouble);
                        System.out.println("Valor capturado de BOLSA/ESTAGIO: " + balancete.getBolsaEstagio());
                    }

                    if (linha.equals("Bolsa / Estágio")) {
                        lerArquivo.readLine();
                        lerArquivo.readLine();
                        String passagens = lerArquivo.readLine();
                        passagens = passagens.replace(",", "");
                        Double passagensDouble = (Double.parseDouble(passagens));
                        balancete.setPassagens(passagensDouble);
                        System.out.println("Valor capturado de PASSAGENS: " + balancete.getPassagens());
                    }

                    if (linha.equals("Passagens")) {
                        lerArquivo.readLine();
                        lerArquivo.readLine();
                        String fixo = lerArquivo.readLine();
                        fixo = fixo.replace(",", "");
                        Double fixoDouble = (Double.parseDouble(fixo));
                        balancete.setTelefoneFixo(fixoDouble);
                        System.out.println("Valor capturado de TELEFONE FIXO: " + balancete.getTelefoneFixo());
                    }

                    if (linha.equals("Telefone Fixo (GVT)")) {
                        lerArquivo.readLine();
                        lerArquivo.readLine();
                        String xerox = lerArquivo.readLine();
                        xerox = xerox.replace(",", "");
                        Double xeroxDouble = (Double.parseDouble(xerox));
                        balancete.setXerox(xeroxDouble);
                        System.out.println("Valor capturado de XEROX: " + balancete.getXerox());
                    }

                    if (linha.equals("Xerox")) {
                        lerArquivo.readLine();
                        lerArquivo.readLine();
                        String correio = lerArquivo.readLine();
                        correio = correio.replace(",", "");
                        Double correioDouble = (Double.parseDouble(correio));
                        balancete.setCorreio(correioDouble);
                        System.out.println("Valor capturado de CORREIO: " + balancete.getCorreio());
                    }

                    if (linha.equals("Correio")) {
                        lerArquivo.readLine();
                        lerArquivo.readLine();
                        String materialExpediente = lerArquivo.readLine();
                        materialExpediente = materialExpediente.replace(",", "");
                        Double materialExpedienteDouble = (Double.parseDouble(materialExpediente));
                        balancete.setMaterialExpediente(materialExpedienteDouble);
                        System.out.println("Valor capturado de MATERIAL DE EXPEDIENTE: " + balancete.getMaterialExpediente());
                    }

                    if (linha.equals("Material de Expediente")) {
                        lerArquivo.readLine();
                        lerArquivo.readLine();
                        String diarias = lerArquivo.readLine();
                        diarias = diarias.replace(",", "");
                        Double diariasDouble = (Double.parseDouble(diarias));
                        balancete.setDiarias(diariasDouble);
                        System.out.println("Valor capturado de DIARIAS: " + balancete.getDiarias());
                    }

                    if (linha.equals("Diárias")) {
                        lerArquivo.readLine();
                        lerArquivo.readLine();
                        String gratificacao = lerArquivo.readLine();
                        gratificacao = gratificacao.replace(",", "");
                        Double gratificacaoDouble = (Double.parseDouble(gratificacao));
                        balancete.setGratificacao(gratificacaoDouble);
                        System.out.println("Valor capturado de GRATIFICAÇÃO: " + balancete.getGratificacao());
                    }

                    if (linha.equals("Gratificação")) {
                        lerArquivo.readLine();
                        lerArquivo.readLine();
                        String outros2 = lerArquivo.readLine();
                        outros2 = outros2.replace(",", "");
                        Double outros2Double = (Double.parseDouble(outros2));
                        balancete.setOutros2(outros2Double);
                        System.out.println("Valor capturado de OUTROS: " + balancete.getOutros2());
                    }

                    if (linha.equals("2.09")) {
                        lerArquivo.readLine();
                        lerArquivo.readLine();
                        lerArquivo.readLine();
                        String selos = lerArquivo.readLine();
                        selos = selos.replace(",", "");
                        Double selosDouble = (Double.parseDouble(selos));
                        balancete.setSelos(selosDouble);
                        System.out.println("Valor capturado de Selos: " + balancete.getSelos());
                    }

                    if (linha.equals("Selos")) {
                        lerArquivo.readLine();
                        lerArquivo.readLine();
                        String servicos = lerArquivo.readLine();
                        servicos = servicos.replace(",", "");
                        Double servicosDouble = (Double.parseDouble(servicos));
                        balancete.setServicos(servicosDouble);
                        System.out.println("Valor capturado de Serviços: " + balancete.getServicos());
                    }

                    if (linha.equals("Serviços")) {
                        lerArquivo.readLine();
                        lerArquivo.readLine();
                        String telefoneMovel = lerArquivo.readLine();
                        telefoneMovel = telefoneMovel.replace(",", "");
                        Double telefoneMovelDouble = (Double.parseDouble(telefoneMovel));
                        balancete.setTelefoneMovel(telefoneMovelDouble);
                        System.out.println("Valor capturado de Telefone - TIM: " + balancete.getTelefoneMovel());
                    }

                    if (linha.equals("Telefone - TIM")) {
                        lerArquivo.readLine();
                        lerArquivo.readLine();
                        String cursos = lerArquivo.readLine();
                        cursos = cursos.replace(",", "");
                        Double cursosDouble = (Double.parseDouble(cursos));
                        balancete.setCursos(cursosDouble);
                        System.out.println("Valor capturado de Cursos: " + balancete.getCursos());
                    }

                    if (linha.equals("Carimbos")) {
                        lerArquivo.readLine();
                        String carimbos = lerArquivo.readLine();
                        carimbos = carimbos.replace(",", "");
                        Double carimbosDouble = (Double.parseDouble(carimbos));
                        balancete.setCarimbos(carimbosDouble);
                        System.out.println("Valor capturado de Carimbos: " + balancete.getCarimbos());
                    }

                    if (linha.equals("Ligação Interurbano (B.TELECOM/EMBRATEL)")) {
                        int ia = 0;
                        if (ia < 8) {
                            lerArquivo.readLine();
                        }
                        String interurbano = lerArquivo.readLine();
                        interurbano = interurbano.replace(",", "");
                        Double interurbanoDouble = (Double.parseDouble(interurbano));
                        balancete.setInterurbano(interurbanoDouble);
                        System.out.println("Valor capturado de Ligação Interurbano (B.TELECOM/EMBRATEL): " + balancete.getInterurbano());
                        i = i++;
                    }

                    //capturando a linha *Débito ano anterior*
                    if (linha.equals("Débito ano anterior")) {
                        lerArquivo.readLine();
                        lerArquivo.readLine();
                        String debitoAnoAnterior = lerArquivo.readLine();
                        debitoAnoAnterior = debitoAnoAnterior.replace(",", "");
                        Double debitoAnoAnteriorDouble = (Double.parseDouble(debitoAnoAnterior));
                        balancete.setDebitoAnoAnterior(debitoAnoAnteriorDouble);
                        System.out.println("Valor capturado de Débito ano anterior: " + balancete.getDebitoAnoAnterior());
                    }

                    //capturando a linha *Jornal/Revista*
                    if (linha.equals("Jornal / Revista")) {
                        lerArquivo.readLine();
                        String jornalRevista = lerArquivo.readLine();
                        jornalRevista = jornalRevista.replace(",", "");
                        Double jornalRevistaDouble = (Double.parseDouble(jornalRevista));
                        balancete.setJornalRevista(jornalRevistaDouble);
                        System.out.println("Valor capturado de Jornal/Revista: " + balancete.getJornalRevista());
                    }

                    //capturando a linha *Saldo anterior*
                    if (linha.equals("Saldo Anterior :")) {
                        String saldoAnterior = lerArquivo.readLine();
                        Double saldoAnteriorDouble;
                        balancete.setAnoAnterior(saldoAnteriorDouble = replaceDouble(saldoAnterior));
                        System.out.println("Valor capturado de Saldo anterior: " + balancete.getAnoAnterior());
                    }

                    //capturando a linha *Saldo Acumulado*
                    if (linha.equals("Saldo Acumulado:")) {
                        String saldoAcumulado = lerArquivo.readLine();
                        Double saldoAcumuladoDouble;
                        balancete.setSaldoAcumulado(saldoAcumuladoDouble = replaceDouble(saldoAcumulado));
                        System.out.println("Valor capturado de Saldo Acumulado: " + balancete.getSaldoAcumulado());
                    }

                    //capturando a linha *Creditos no Mes*
                    if (linha.equals("Créditos no Mês :")) {
                        lerArquivo.readLine();
                        String creditosMes = lerArquivo.readLine();
                        Double creditosMesDouble;
                        balancete.setCreditosMes(creditosMesDouble = replaceDouble(creditosMes));
                        System.out.println("Valor capturado de Creditos Mês: " + balancete.getCreditosMes());
                    }

                    //capturando a linha *Debitos no Mes*
                    if (linha.equals("Débitos no Mês :")) {
                        String debitosMes = lerArquivo.readLine();
                        Double debitosMesDouble;
                        balancete.setDebitosMes(debitosMesDouble = replaceDouble(debitosMes));
                        System.out.println("Valor capturado de Debitos Mês: " + balancete.getDebitosMes());

                    }
                
                // Armazena o balancete no banco de dados.
                BalanceteDAOImpl balanceteDao = new BalanceteDAOImpl();
                balanceteDao.salvarOuAlterar(balancete, session);
                
            }
            
        } while (linha != null);
                
        return true;
        
    }
    
    
    /**
     * Método utilizado para retirar os parentênses que acompanham alguns
     * valores nos arquivos de balancete.
     * @param valor String que acompanha um valor cercado por parênteses.
     * @return Um double do valor tratado.
     */
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
