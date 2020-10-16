package com.lab.aw.ecommerce;

import java.util.List;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.lab.aw.dao.ProdutoDAO;
import com.lab.aw.dao.ProdutoDB;
import com.lab.util.GlobalcodeException;


@WebServlet("/catalogoProdutos")
public class CatalogoProdutos extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProdutoDAO produtosDB = new ProdutoDB();
        List listaProdutos = null;
        try {
            listaProdutos = produtosDB.getCatalogoProdutos();

            // -------------------------------------------------------------------
            // Insira a partir daqui o codigo pedido no laboratorio:
            // -------------------------------------------------------------------
            request.setAttribute("catalogo", listaProdutos);
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/CatalogoProdutosView.jsp");
            rd.forward(request, response);

        } catch (GlobalcodeException e) {
            throw new ServletException(e);
        }
    }
}
