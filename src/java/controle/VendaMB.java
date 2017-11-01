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

    private List<ItensVenda> listaItensVenda;
    private Venda venda;
    private ItensVenda itensVenda;
    private DAOGenerico<Venda> daoVenda = new DAOGenerico<>(Venda.class);
    private DAOGenerico<ItensVenda> daoItensVenda = new DAOGenerico<>(ItensVenda.class);

    public VendaMB() {
        criarObjetos();
       
    }
    public void criarObjetos(){
        listaItensVenda = new ArrayList<>();
        venda = new Venda();
        itensVenda = new ItensVenda();
    }
    
    public void inserirItensVenda(){
        System.out.println("Quantidade: "+itensVenda.getQuantidade());
        listaItensVenda.add(itensVenda);
        System.out.println("Tam Lista: "+listaItensVenda.size());
        itensVenda = new ItensVenda();
        System.out.println("Quantidade: "+itensVenda.getQuantidade());
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
    }

    public List<ItensVenda> getListaItensVenda() {
        return listaItensVenda;
    }

    public void setListaItensVenda(List<ItensVenda> listaItensVenda) {
        this.listaItensVenda = listaItensVenda;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public ItensVenda getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(ItensVenda itensVenda) {
        this.itensVenda = itensVenda;
    }

   

}
