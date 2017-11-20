<%@page import="br.senac.donc.model.Ranking"%>
<%@page import="java.util.List"%>
<%@page import="br.senac.donc.dao.BalanceteDAOImpl"%>
<jsp:include page="resources/navbar.jsp" />

<div class="container">
    <div class="index-content-container">
       
        <h2>O projeto Olho na Câmara!</h2>
        <br>
        <p> O Brasil vive uma crise política que está trazendo consequências econômicas graves ao país. 
            A impunidade dos crimes de corrupção e lavagem de dinheiro público permeiam os noticiários 
            todos os dias e o sentimento do brasileiro é de impotência frente a tantos casos de uso 
            indevido dos recursos públicos. Em Florianópolis por exemplo foi deflagrada em 2014 a 
            'Operação Ave de Rapina' que desmantelou uma organização criminosa que atuava principalmente 
            na Câmara de Vereadores. A Lei nº 12.527/2011 conhecida como LAI: Lei de Acesso à Informação, 
            regulamenta o direito constitucional de acesso às informações públicas e cria mecanismos para 
            que pessoas físicas e jurídicas possam solicitar dados e informações dos órgãos e entidades federais, 
            distritais, estaduais e municipais, além disso por força da Lei Complementar nº 131/2009 os municípios 
            devem disponibilizar, em meio eletrônico e em tempo real, informações detalhadas sobre a execução 
            orçamentária e financeira de suas receitas e despesas. Muitos órgãos criaram os chamados 'Portais 
            da Transparência' para cumprir as leis estabelecidas porém na maioria das vezes os dados e informações 
            estão disponíveis porém muito pouco acessíveis para o cidadão. Foi verificado que o portal da 
            transparência da Câmara Municipal de Florianópolis é deficiente quando observam-se detalhes 
            relacionados a usabilidade e atualização dos dados. Visando a redução do poder discricionário 
            no uso dos dinheiro público por parte dos vereadores de Florianópolis foi desenvolvido um sistema 
            que coleta e extrai dados referentes ao uso da verba de gabinete oferecida mensalmente aos 
            vereadores e disponibiliza um ranking de gastos por vereador na web, bem como um webservice com os 
            dados coletados estruturados em um arquivo .json para que sejam utilizados por outros desenvolvedores 
            em suas aplicações.</p>
        <br>
        
        <p>
           Caro amigo densenvolvedor, este projeto é totalmente open-source!</br>
           Todo o código e documentação encontram-se no nosso github.</br>
           Acesse e contribua com a nossa comunidade!
        </p>
        <a href="https://github.com/olhonacamara" target="_blank">
        <img style="height: 24px; width: 24px" title="GitHub" alt="githubIcon" 
             src="https://assets-cdn.github.com/images/modules/logos_page/Octocat.png" />
        </a>
        <a href="https://github.com/olhonacamara" target="_blank">https://github.com/olhonacamara</a>
        
        

        
    </div>
    
    


    <jsp:include page="resources/footer.jsp" />

</div>



