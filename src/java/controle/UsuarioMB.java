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
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import modelo.Usuario;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author Frank
 */
@ManagedBean
@ViewScoped
public class UsuarioMB {

    private Usuario usuario;
    private List<Usuario> listaUsuarios;
    private DAOGenerico<Usuario> daoUsuario;

    public UsuarioMB() {
        criarObjetos();
        preencherListaUsuarios();
        //        Object usuarioLogado = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //        String username;
        //       
        //        username = usuarioLogado.toString();
        //        System.out.println("Loga: "+username);
    }

    private void criarObjetos() {
        usuario = new Usuario();
        listaUsuarios = new ArrayList<Usuario>();
        daoUsuario = new DAOGenerico<Usuario>(Usuario.class);
    }

    private void preencherListaUsuarios() {
        listaUsuarios = daoUsuario.buscarTodos();

    }

    public void remover(Long id) {
        daoUsuario.excluir(id);
        preencherListaUsuarios();
    }

    public void inserir() {
        if (usuario.getId() == null) {
            daoUsuario.salvar(usuario);
        } else {
            daoUsuario.alterar(usuario);
        }
        preencherListaUsuarios();
        usuario = new Usuario();

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

}
