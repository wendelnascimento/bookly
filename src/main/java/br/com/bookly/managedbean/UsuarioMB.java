package br.com.bookly.managedbean;

import br.com.bookly.bean.Usuario;
import br.com.bookly.dao.UsuarioDAO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * Created by wendelnascimento on 20/05/17.
 */
@ManagedBean
@SessionScoped
public class UsuarioMB {
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioMB() {
        usuario = new Usuario();
    }

    public String gotoCadastro() {
        try {
            usuario = new Usuario();
            return "cadastro";
        } catch (Exception ex) {
            return "erro";
        }
    }
}
