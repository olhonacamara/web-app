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
                                Gastos com Cursos em 2017
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
                        Ranking de gastos com Cursos
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
                                List<Ranking> objetos = dao.listarRankingGasto("cursos");
                                
                                Integer count = 1;

                                for (Ranking objeto : objetos) {
                                    %>
                                    
                                    <tr>
                                        <td>
                                            
                                            <%
                                                if (count <= 3) {
                                            %>
                                                    <span class="label label-danger"># <%= count %></span>
                                            <%
                                                } else {
                                            %>
                                                        <span class="label label-default"># <%= count %></span>
                                            <%
                                                    }
                                            %>
                                            
                                            <% count++; %>
                                        </td>
                                        <td><%= objeto.getNome() %></td>
                                        <td><%= objeto.getPartido()%></td>
                                        <td><%= objeto.getGasto() %></td>
                                    </tr>
                                                                        
                                    <%
                                }

                            %>
                            
                        
                        
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <hr>

        <jsp:include page="resources/footer.jsp" />
        <script src="resources/js/charts/chart-cursos.js"></script>

