<%@page import="br.senac.donc.model.Ranking"%>
<%@page import="java.util.List"%>
<%@page import="br.senac.donc.dao.BalanceteDAOImpl"%>
<jsp:include page="resources/navbar.jsp" />

<div class="container">
    <div class="index-content-container">
        <%
            BalanceteDAOImpl dao = new BalanceteDAOImpl();
            List<Ranking> objetos = dao.exibeSomaGeral();
            for (Ranking objeto : objetos) {
        %>
        <tr>
        <div style="text-align: center">


            <span style="font-size: 40px;">R$</span>
            <div  id="total-gasto" class="total-gasto" hidden>
                <%= objeto.getSomaTotal()%> 
            </div>

            <div id="odometer" class="odometer" style="font-size: 70px;">0</div>


            <h3 style="color: '#22375b'">
                Este é o total gasto pelos vereadores com verba de gabinete desde Janeiro de 2017!!
            </h3>
        </div> 
        </tr>
        <%
            }

        %>
    </div>
    <br>

    <div style = "text-align: center">
        <h4>Selecione um item abaixo para visualizar o ranking destes gastos: </h4>

        <select data-live-search="true" class="selectpicker" name="rankings" 
                onchange="location = this.value;"
                title="Escolha uma categoria.">
            <option value="geral.jsp"></option>
            <option value="geral.jsp">Ranking - Geral</option>
            <option value="partido.jsp">Ranking - Geral por partido</option>
            <option value="bolsa-estagio.jsp">Ranking - Bolsas e Estágios</option>
            <option value="passagens.jsp">Ranking - Passagens</option>
            <option value="telefone-fixo.jsp">Ranking - Telefone Fixo</option>
            <option value="xerox.jsp">Ranking - Xerox</option>
            <option value="correios.jsp">Ranking - Correios</option>
            <option value="material-expediente.jsp">Ranking - Material de Expediente</option>
            <option value="diarias.jsp">Ranking - Diárias</option>
            <option value="outros.jsp">Ranking - Outros</option>
            <option value="selos.jsp">Ranking - Selos</option>
            <option value="servicos.jsp">Ranking - Serviços</option>
            <option value="telefone-movel.jsp">Ranking - Telefone Móvel</option>
            <option value="cursos.jsp">Ranking - Cursos</option>
            <option value="carimbos.jsp">Ranking - Carimbos</option>
            <option value="interurbano.jsp">Ranking - Ligações Interurbano</option>
            <option value="jornal-revista.jsp">Ranking - Jornais e Revistas</option>
        </select> <br/><br/>

    </div>


    <jsp:include page="resources/footer.jsp" />

</div>



