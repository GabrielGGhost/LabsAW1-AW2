package com.lab.aw.dao;

import java.util.List;

import com.lab.exception.GlobalcodeException;
import com.lab.model.Produto;

public interface ProdutoDAO {

    public void save(Produto p) throws GlobalcodeException;

    public List<Produto> getCatalogoProdutos() throws GlobalcodeException;

    public Produto getProdutoById(int id) throws GlobalcodeException;

    public void createTable() throws GlobalcodeException;
}