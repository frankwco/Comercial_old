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
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import modelo.Marca;

/**
 *
 * @author Frank
 */
@ManagedBean
@SessionScoped
public class MarcaMB {

    private Marca marca;
    private List<Marca> listaMarcas;
    private DAOGenerico<Marca> daoMarca;

    public MarcaMB() {
        criarObjetos();
        preencherListaMarcas();
    }

    private void criarObjetos() {
        marca = new Marca();
        listaMarcas = new ArrayList<Marca>();
        daoMarca = new DAOGenerico<Marca>(Marca.class);
    }

    private void preencherListaMarcas() {
        listaMarcas = daoMarca.buscarTodos();
    }

    public void remover(Long id) {
        daoMarca.excluir(id);
        preencherListaMarcas();
    }

    public void inserir() {
        if (marca.getId() == null) {
            daoMarca.salvar(marca);
        } else {
            daoMarca.alterar(marca);
        }
        preencherListaMarcas();
        marca = new Marca();
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Marca> getListaMarcas() {
        return listaMarcas;
    }

    public void setListaMarcas(List<Marca> listaMarcas) {
        this.listaMarcas = listaMarcas;
    }

}
