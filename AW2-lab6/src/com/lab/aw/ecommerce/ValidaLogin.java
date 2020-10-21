package com.lab.aw.ecommerce;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.lab.exception.LoginFailedException;
import com.lab.model.Cliente;

import javax.servlet.annotation.WebServlet;

@WebServlet("/validaLogin")
public class ValidaLogin extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String usuario = request.getParameter("username");
        String senha = request.getParameter("password");

        if ((usuario == null) || (usuario.equals(""))) {
            throw new LoginFailedException("Por favor, digite o usu�rio.");

        } else if ((senha == null) || (senha.equals(""))) {
            throw new LoginFailedException("Por favor, digite a senha.");

        } else if (usuario.equals("gc") && senha.equals("gc")) {
            Cliente cliente = new Cliente("Globalcode", usuario, senha,
                    "(11) 3171-1987", true);
            request.getSession().setAttribute("cliente", cliente);
        } else {
            throw new LoginFailedException("Usu�rio e senha inv�lidos!");
        }

        response.sendRedirect(request.getContextPath()+"/catalogoProdutos");
    }
}
