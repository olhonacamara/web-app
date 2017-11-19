<%@page import="br.senac.donc.model.Ranking"%>
<%@page import="java.util.List"%>
<%@page import="br.senac.donc.dao.BalanceteDAOImpl"%>
<jsp:include page="resources/navbar.jsp" />

<div class="container">
    <div class="index-content-container">
        <%

            BalanceteDAOImpl dao = new BalanceteDAOImpl();
            List<Ranking> objetos = dao.exibeSomaGeral();

            Integer count = 1;

            for (Ranking objeto : objetos) {
        %>

        <tr>


        <span style="font-size: 80px; color: red;"><%= objeto.getSomaTotal()%>
        </span>

        </tr>
        <%
            }

        %>
        <h3>Este é o total gasto pelos vereadores apenas com verba de gabinete desde Janeiro de 2017!!</h3>
    </div>

    <div>
        <h3>Selecione um item para visualizar o Ranking de gastos: </h3>

        <select name="rankings" onchange="location = this.value;">
            <option value="geral.jsp"></option>
            <option value="geral.jsp">Ranking - Geral</option>
            <option value="bolsa-estagio.jsp">Ranking - Bolsa/Estágios</option>
            <option value="passagens.jsp">Ranking - Passagens</option>
            <option value="telefone-fixo.jsp">Ranking - Telefone Fixo</option>
            <option value="xerox.jsp">Ranking - Xerox</option>
            <option value="correios.jsp">Ranking - Correios</option>
            <option value="material-expediente.jsp">Ranking - Material de Expediente</option>
            <option value="diarias.jsp">Ranking - Diárias</option>
            <option value="outros.jsp">Ranking - Outros</option>
            <option value="selos.jsp">Ranking - Selos</option>
            <option value="servicos.jsp">Ranking - Serviços</option>
            <option value="telefone-tim.jsp">Ranking - Telefone Tim</option>
            <option value="cursos.jsp">Ranking - Cursos</option>
            <option value="carimbos.jsp">Ranking - Carimbos</option>
            <option value="interurbano.jsp">Ranking - Ligações Interurbano</option>
            <option value="jornal-revista.jsp">Ranking - Jornal / Revista</option>
        </select>
    </div>


    <jsp:include page="resources/footer.jsp" />

</div>



