package br.com.estudo.aw.ecommerce;


import java.util.List;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import br.com.estudo.aw.dao.ProdutoDAO;
import br.com.estudo.aw.dao.ProdutoDB;
import br.com.estudo.util.GlobalcodeException;

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
            
            request.setAttribute("produtos", listaProdutos);
            
            RequestDispatcher rd = request.getRequestDispatcher("/catalogoProdutosView");
            rd.forward(request, response);

        } catch (GlobalcodeException e) {
            throw new ServletException(e);
        }
    }
}
