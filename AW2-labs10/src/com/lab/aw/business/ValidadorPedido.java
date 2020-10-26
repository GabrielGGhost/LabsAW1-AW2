package com.lab.aw.business;

import com.lab.model.CarrinhoCompras;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class ValidadorPedido {

    public void validarPedido(HttpServletRequest request) throws ServletException, IOException {
        CarrinhoCompras carrinho = (CarrinhoCompras) request.getSession().getAttribute("carrinhoCompras");

        List<String> listaDeProblemas = new ArrayList<String>();

        if (carrinho == null || carrinho.getItems().size() == 0) {
            listaDeProblemas.add("Carrinho de compras vazio");
        }

        if (naumTemTamanhoMinimo(request, "nome", 6)) {
            listaDeProblemas.add("Nome muito curto");
        }

        if (naumTemTamanhoMinimo(request, "cpf", 11) || temDigitosNaumNumericos(request, "cpf")) {
            listaDeProblemas.add("CPF deve ter 11 digitos no minimo (somente numeros)");
        }

        if (parametroNaumInformado(request, "email")) { // tipo do cartao de credito
            listaDeProblemas.add("Email nao informado");
        }

        if (parametroNaumInformado(request, "tipo")) { // tipo do cartao de credito
            listaDeProblemas.add("Tipo de cartao de credito nao informado");
        }

        if (naumTemTamanhoMinimo(request, "numeroCartao", 16) || temDigitosNaumNumericos(request, "numeroCartao")) {
            listaDeProblemas.add("Numero de cartao invalido (16 digitos)");
        }

        if (parametroNaumInformado(request, "dataValidade")) { // tipo do cartao de credito
            listaDeProblemas.add("Validade do cartao nao informada");
        }
        
        request.setAttribute("problemas", listaDeProblemas);
    }

    private boolean parametroNaumInformado(HttpServletRequest request, String paramName) {

        String param = request.getParameter(paramName);
        return (param == null || param.trim().length() == 0);

    }

    private boolean naumTemTamanhoMinimo(HttpServletRequest request, String paramName, int tamanhoMinimo) {

        if (parametroNaumInformado(request, paramName)) {
            return true;
        }
        String param = request.getParameter(paramName);
        return (param.trim().length() < tamanhoMinimo);
    }

    private boolean temDigitosNaumNumericos(HttpServletRequest request, String paramName) {

        String param = request.getParameter(paramName);
        for (int i = 0; i < param.length(); i++) {
            if (!Character.isDigit(param.charAt(i))) {
                return true;
            }
        }
        return false;

    }
}
