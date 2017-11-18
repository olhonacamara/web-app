    <jsp:include page="resources/navbar.jsp" />

    <div class="container">
        <div class="index-content-container">
            
            <div>
                <span style="font-size: 80px;">R$ 50.984,34</span>
            </div>
            
            <h2>Selecione um Ranking: </h2>
            
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



        