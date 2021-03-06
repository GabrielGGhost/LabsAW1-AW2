package com.lab.filters;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.lab.model.Cliente;

public class ControleDeAcesso implements Filter {
    
    private FilterConfig fc;
    
    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("[FILTER] Inicializando o filtro LogAccess");
        this.fc = config;
    }
    
    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws ServletException, IOException {
        
        // Colocamos aqui qualquer operacao de filtro de request
        System.out.println("[FILTER] Executando o filtro de log de acesso");
        HttpServletRequest request = (HttpServletRequest) req;
        System.out.println("[FILTER] URL requisitada :" + request.getRequestURI());
        
        //Se o cliente tiver feito login, um objeto de nome cliente existe na sessão.
        Cliente cliente = (Cliente) request.getSession().getAttribute("cliente");
        
        if(cliente != null){
            System.out.println("*** " + cliente.getNome() + " ***");
            // Prossegue a requisição original
            chain.doFilter(req, res);
        }else{
            System.out.println("[FILTER] Redirecionando para a tela de login...");
            HttpServletResponse response = (HttpServletResponse) res;
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
        
    }
    
    @Override
    public void destroy() {
        System.out.println("[FILTER] Destruindo o filtro LogAccess");
    }
}
