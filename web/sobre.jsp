<%@page import="br.senac.donc.model.Ranking"%>
<%@page import="java.util.List"%>
<%@page import="br.senac.donc.dao.BalanceteDAOImpl"%>
<jsp:include page="resources/navbar.jsp" />

<div class="container">
    <div class="index-content-container">
       
        <h2>O projeto Olho na C�mara!</h2>
        <br>
        <p> O Brasil vive uma crise pol�tica que est� trazendo consequ�ncias econ�micas graves ao pa�s. 
            A impunidade dos crimes de corrup��o e lavagem de dinheiro p�blico permeiam os notici�rios 
            todos os dias e o sentimento do brasileiro � de impot�ncia frente a tantos casos de uso 
            indevido dos recursos p�blicos. Em Florian�polis por exemplo foi deflagrada em 2014 a 
            'Opera��o Ave de Rapina' que desmantelou uma organiza��o criminosa que atuava principalmente 
            na C�mara de Vereadores. A Lei n� 12.527/2011 conhecida como LAI: Lei de Acesso � Informa��o, 
            regulamenta o direito constitucional de acesso �s informa��es p�blicas e cria mecanismos para 
            que pessoas f�sicas e jur�dicas possam solicitar dados e informa��es dos �rg�os e entidades federais, 
            distritais, estaduais e municipais, al�m disso por for�a da Lei Complementar n� 131/2009 os munic�pios 
            devem disponibilizar, em meio eletr�nico e em tempo real, informa��es detalhadas sobre a execu��o 
            or�ament�ria e financeira de suas receitas e despesas. Muitos �rg�os criaram os chamados 'Portais 
            da Transpar�ncia' para cumprir as leis estabelecidas por�m na maioria das vezes os dados e informa��es 
            est�o dispon�veis por�m muito pouco acess�veis para o cidad�o. Foi verificado que o portal da 
            transpar�ncia da C�mara Municipal de Florian�polis � deficiente quando observam-se detalhes 
            relacionados a usabilidade e atualiza��o dos dados. Visando a redu��o do poder discricion�rio 
            no uso dos dinheiro p�blico por parte dos vereadores de Florian�polis foi desenvolvido um sistema 
            que coleta e extrai dados referentes ao uso da verba de gabinete oferecida mensalmente aos 
            vereadores e disponibiliza um ranking de gastos por vereador na web, bem como um webservice com os 
            dados coletados estruturados em um arquivo .json para que sejam utilizados por outros desenvolvedores 
            em suas aplica��es.</p>
        <br>
        
        <p>
           Caro amigo densenvolvedor, este projeto � totalmente open-source!</br>
           Todo o c�digo e documenta��o encontram-se no nosso github.</br>
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



