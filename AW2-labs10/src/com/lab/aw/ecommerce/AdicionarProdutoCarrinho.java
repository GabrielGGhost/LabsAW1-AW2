package com.lab.aw.ecommerce;

import com.lab.aw.business.GerenciadorCompras;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adicionarProdutoCarrinho")
public class AdicionarProdutoCarrinho extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        GerenciadorCompras gerenciador = new GerenciadorCompras();
        gerenciador.adicionarProdutoCarrinho(request);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/CarrinhoComprasView.jsp");
        dispatcher.forward(request, response);
    }

}
