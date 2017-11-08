/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DAOGenerico;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import modelo.Estado;
import util.ChamarRelatorio;

/**
 *
 * @author Frank
 */
@ManagedBean
@SessionScoped
public class EstadoMB {

    private Estado estado;
    private List<Estado> listaEstados;
    private DAOGenerico<Estado> daoEstado;

    public EstadoMB() {
        criarObjetos();
        preencherListaEstados();
    }    


    private void criarObjetos() {
        estado = new Estado();
        listaEstados = new ArrayList<Estado>();
        daoEstado = new DAOGenerico<Estado>(Estado.class);
    }

    private void preencherListaEstados() {
        listaEstados = daoEstado.buscarTodos();
    }

    public void remover(Long id) {
        daoEstado.excluir(id);
        preencherListaEstados();
    }

    public void inserir() {
        if (estado.getId() == null) {
            daoEstado.salvar(estado);
        } else {
            daoEstado.alterar(estado);
        }
        preencherListaEstados();
        estado = new Estado();
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Estado> getListaEstados() {
        return listaEstados;
    }

    public void setListaEstados(List<Estado> listaEstados) {
        this.listaEstados = listaEstados;
    }

}
