/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DAOGenerico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Produto;
import modelo.Estado;

/**
 *
 * @author Frank
 */
@ManagedBean
@ViewScoped
public class ProdutoMB {

    private Produto produto;
    private List<Produto> listaProdutos;
    private DAOGenerico<Produto> daoProduto;

    public ProdutoMB() {
        criarObjetos();
        preencherListaProdutos();
    }

    private void criarObjetos() {
        produto = new Produto();
        listaProdutos = new ArrayList<Produto>();
        daoProduto = new DAOGenerico<Produto>(Produto.class);

    }

    private void preencherListaProdutos() {
        listaProdutos = daoProduto.buscarTodos();
    }

    public void remover(Long id) {
        daoProduto.excluir(id);
        preencherListaProdutos();
    }

    public void inserir() {
        if (produto.getId() == null) {
            daoProduto.salvar(produto);
        } else {
            daoProduto.alterar(produto);
        }
        preencherListaProdutos();
        produto = new Produto();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

}
