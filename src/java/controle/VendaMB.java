/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DAOGenerico;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.ItensVenda;
import modelo.Venda;

/**
 *
 * @author Frank
 */
@ManagedBean
@ViewScoped
public class VendaMB {

    private List<Venda> listaVendas;
    private List<ItensVenda> listaItensVenda;
    private Venda venda;
    private ItensVenda itensVenda;
    private DAOGenerico<Venda> daoVenda = new DAOGenerico<>(Venda.class);
    private DAOGenerico<ItensVenda> daoItensVenda = new DAOGenerico<>(ItensVenda.class);

    public VendaMB() {
        criarObjetos();
        preencherListaVendas();
    }
    public void criarObjetos(){
        listaItensVenda = new ArrayList<>();
        listaVendas = new ArrayList<>();
        venda = new Venda();
        itensVenda = new ItensVenda();
    }
    
    public void inserirItensVenda(){
        listaItensVenda.add(itensVenda);
        itensVenda = new ItensVenda();
    }
    
    public void inserirVenda(){
        //setar o valor total do item
        //setar o valor total da venda
        if(venda.getId()==null){
            daoVenda.salvar(venda);
            for(ItensVenda item:listaItensVenda){
                item.setVenda(venda);
                daoItensVenda.salvar(item);
            }
        }else{
            daoVenda.alterar(venda);
        }
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
