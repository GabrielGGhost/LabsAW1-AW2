package br.com.estudo.aw.dao;

import java.util.List;

import br.com.estudo.model.Produto;
import br.com.estudo.util.GlobalcodeException;

public interface ProdutoDAO {

    public void save(Produto p) throws GlobalcodeException;

    public List<Produto> getCatalogoProdutos() throws GlobalcodeException;

    public Produto getProdutoById(int id) throws GlobalcodeException;

    public void createTable() throws GlobalcodeException;
}