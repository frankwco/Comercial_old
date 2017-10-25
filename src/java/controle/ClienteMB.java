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
import modelo.Cliente;

/**
 *
 * @author Frank
 */
@ManagedBean
@ViewScoped
public class ClienteMB {

    private Cliente cliente;
    private List<Cliente> listaClientes;
    private DAOGenerico<Cliente> daoCliente;

    public ClienteMB() {
        criarObjetos();
        preencherListaClientes();
    }

    private void criarObjetos() {
        cliente = new Cliente();
        listaClientes = new ArrayList<Cliente>();
        daoCliente = new DAOGenerico<Cliente>(Cliente.class);

    }

    private void preencherListaClientes() {
        listaClientes = daoCliente.buscarTodos();
    }

    public void remover(Long id) {
        daoCliente.excluir(id);
        preencherListaClientes();
    }

    public void inserir() {
        if (cliente.getId() == null) {
            daoCliente.salvar(cliente);
        } else {
            daoCliente.alterar(cliente);
        }
        preencherListaClientes();
        cliente = new Cliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

}
