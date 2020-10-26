<%@page contentType="text/html" import="java.util.List" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Problemas no processamnteo do pedido</title>
        <link href='<%=request.getContextPath()%>/aj.css' rel='stylesheet' type='text/css'></link>
    </head>
    <body>

        <h3>Alguns problemas foram encontrados nos dados informados</h3>
        <h4>Por favor verifique:</h4>
        <hr/>
        <%
        List<String> problemas = (List<String>) request.getAttribute("problemas");
        for (String problema : problemas) {
        %>
        <ul class="gridCampo"><%= problema%></ul>
        <%
        }
        %>
        <hr/>
        <a href="javascript: history.back();" class="tituloform">voltar e corrigir</a>
    </body>
</html>
