package com.lab.aw.ecommerce;

import com.lab.aw.business.ValidadorPedido;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/validarPedido")
public class ValidaPedido extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ValidadorPedido validador = new ValidadorPedido();
        validador.validarPedido(request);
        List<String> listaDeProblemas = (List<String>) request.getAttribute("problemas");

        String destino = null;

        // ------------------------------------------------------------------------
        // Adicione aqui o código pedido no laboratorio
        // ------------------------------------------------------------------------

        if(listaDeProblemas.size() == 0) {
        	destino = "/jsp/PedidoView.jsp";
        } else {
        	destino = "/jsp/ListaProblemasPedido.jsp";

        }


        RequestDispatcher dispatcher = request.getRequestDispatcher(destino);
        dispatcher.forward(request, response);

    }

}
