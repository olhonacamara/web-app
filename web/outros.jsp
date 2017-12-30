<%@page import="br.senac.donc.model.Ranking"%>
<%@page import="br.senac.donc.model.Vereador"%>
<%@page import="java.util.List"%>
<%@page import="br.senac.donc.util.HibernateUtil"%>
<%@page import="br.senac.donc.dao.VereadorDAOImpl"%>
<%@page import="br.senac.donc.dao.BalanceteDAOImpl"%>
<jsp:include page="resources/navbar.jsp" />
<!-- Page Content -->
<div class="container">


    <!-- Introduction Row -->
    <div class="row">
        <div class="col-lg-12">
            <div class="chart-container">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4>
                            Gastos com Outros em 2017
                            <i class="fa fa-question-circle" aria-hidden="true"></i>
                            <br>
                            <small>
                                Gastos relacionados a verba de gabinete recebida
                                mensalmente pelos vereadores.
                            </small>
                        </h4>
                    </div>
                    <div class="panel-body">
                        <canvas height="80px" id="geralChart"></canvas>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="content-container">
        <!-- Team Members Row -->
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">
                    Ranking de gastos com Outros
                    <small>Janeiro a Agosto - 2017</small>
                </h2>
                <h4 class="descricao">
                    Valores relacionados aos gastos com a verba de gabinete recebida mensalmente.<br>
                </h4>
            </div>

            <div class="col-lg-12 col-sm-6 text-center">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Posição</th>
                            <th>Vereador</th>
                            <th>Partido</th>
                            <th>Gasto</th>
                        </tr>
                    </thead>
                    <tbody>

                        <%

                            BalanceteDAOImpl dao = new BalanceteDAOImpl();
                            List<Ranking> objetos = dao.listarRankingGasto("outros1");

                            Integer count = 1;

                            for (Ranking objeto : objetos) {
                        %>

                        <tr>
                            <td>

                                <%
                                    if (count <= 3) {
                                %>
                                <span class="label label-danger"># <%= count%></span>
                                <%
                                } else {
                                %>
                                <span class="label label-default"># <%= count%></span>
                                <%
                                    }
                                %>

                                <% count++;%>
                            </td>
                            <td><%= objeto.getNome()%></td>
                            <td><%= objeto.getPartido()%></td>
                            <td><%= objeto.getGasto()%></td>
                        </tr>

                        <%
                            }

                        %>



                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <div style = "text-align: center">
        <h4>Selecione abaixo o ranking de outros gastos: </h4>

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
    <hr>

    <jsp:include page="resources/footer.jsp" />
    <script src="resources/js/charts/chart-outros.js"></script>