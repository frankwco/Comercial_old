/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DAOGenerico;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Venda;

/**
 *
 * @author Frank
 */
@ManagedBean
@ViewScoped
public class VendaMB {

    private List<Venda> listaVendas;
    private DAOGenerico<Venda> daoVenda = new DAOGenerico<>(Venda.class);

    public VendaMB() {
        preencherListaVendas();
    }

    private void preencherListaVendas() {
        listaVendas = daoVenda.buscarTodos();
    }

    public List<Venda> getListaVendas() {
        return listaVendas;
    }

    public void setListaVendas(List<Venda> listaVendas) {
        this.listaVendas = listaVendas;
    }

}
