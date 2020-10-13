package br.com.lab.dao;

import java.util.List;

import br.com.lab.model.Produto;
import br.com.lab.util.GlobalcodeException;


public interface ProdutoDAO {

    public void save(Produto p) throws GlobalcodeException;

    public List<Produto> getCatalogoProdutos() throws GlobalcodeException;

    public Produto getProdutoById(int id) throws GlobalcodeException;

    public void createTable() throws GlobalcodeException;
}