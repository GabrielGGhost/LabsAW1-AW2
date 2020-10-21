<!DOCTYPE html>
<!-- Transformar esta página em uma página de erros -->

<%@page import="java.util.Objects" isErrorPage="true"%>


<html>
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
    </head>
  <body>    
    <form method="post" action='<%=request.getContextPath()%>/validaLogin'>
      <table cellspacing="2" cellpadding="3" width="30%">
        <!-- Verificar se existe o objeto exception antes de mostrar a linha da tabela a seguir -->          
          <tr>
            <td colspan="2">
                <strong>
                   
                   
                   <% if(exception != null) {
                	   out.println(exception.getMessage());
                   }
                   
                   %>
                   
                   
                </strong>
            </td>
          </tr>        
          <tr>
            <td>Usuário</td>
            <td><input type="text" name="username" size="10" />
            </td>
          </tr>        
          <tr>
            <td>Senha</td>
            <td><input type="password" name="password" size="10" />
            </td>
          </tr>
          <tr>
            <td><button type="submit">Entrar</button></td>
            <td>
            </td>
          </tr>
      </table>
    </form>
  </body>
</html>
