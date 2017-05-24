package br.com.bookly.managedbean;

import br.com.bookly.bean.Autor;
import br.com.bookly.dao.AutorDAO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wendelnascimento on 21/05/17.
 */
@ManagedBean
@SessionScoped
public class AutorMB {
    public Autor autor;
    public List<Autor> autores;
    protected AutorDAO autorDAO = AutorDAO.getInstance();

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public AutorMB() {
        autor = new Autor();
        autores = listar();
    }

    public String cadastrar() {
        try {
            autorDAO.save(autor);
            return "index";
        } catch (Exception ex) {
            return "erro";
        }
    }

    public String gotoCadastrar() {
        try {
            autor = new Autor();
            return "cadastro";
        } catch (Exception ex) {
            return "erro";
        }
    }

    public List<Autor> listar() {
        try {
            autores = autorDAO.autorList();
        } catch (Exception ex) {

        }
        return autores;
    }

    public String gotoListar() {
        try {
            listar();
            return "lista";
        } catch (Exception ex) {
            return "erro";
        }
    }

    public String editar() {
        try {
            autorDAO.update(autor);
            return "index";
        } catch (Exception ex) {
            return "erro";
        }
    }

    public String gotoEditar() {
        try {
            autor = autorDAO.getAutorById(autor.getId());
            return "editar";
        } catch (Exception ex) {
            return "erro";
        }
    }

    public String deletar() {
        try {
            autorDAO.delete(autor.getId());
            return "index";
        } catch (Exception ex) {
            return "erro";
        }
    }

    public String gotoDeletar() {
        try {
            autor = autorDAO.getAutorById(autor.getId());
            return "deletar";
        } catch (Exception ex) {
            return "erro";
        }
    }
}
