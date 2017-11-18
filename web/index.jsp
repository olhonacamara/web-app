    <jsp:include page="resources/navbar.jsp" />

    <div class="container">
        <div class="index-content-container">
            <h2>Selecione um Ranking: </h2>
            <!--<p><a href="geral.jsp">Ranking Geral</a></p>-->
            
            <select name="rankings" onchange="location = this.value;">
                <option value="geral.jsp"></option>
                <option value="geral.jsp">Ranking - Geral</option>
                <option value="saab">Ranking - Bolsa/Estágios</option>
                <option value="mercedes">Ranking - Passagens</option>
                <option value="audi">Ranking - Telefone Fixo</option>
                <option value="audi">Ranking - Xerox</option>
                <option value="audi">Ranking - Correios</option>
                <option value="audi">Ranking - Material de Expediente</option>
                <option value="audi">Ranking - Diárias</option>
                <option value="audi">Ranking - Outros</option>
                <option value="audi">Ranking - Selos</option>
                <option value="audi">Ranking - Serviços</option>
                <option value="audi">Ranking - Telefone Tim</option>
                <option value="audi">Ranking - Cursos</option>
                <option value="audi">Ranking - Carimbos</option>
                <option value="audi">Ranking - Ligações Interurbano</option>
                <option value="audi">Ranking - Jornal / Revista</option>
            </select>
            
        </div>
        
        <jsp:include page="resources/footer.jsp" />

    </div>



        