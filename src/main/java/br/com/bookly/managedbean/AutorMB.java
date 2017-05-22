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

    public void cadastrar() {
        try {
            autorDAO.save(autor);
        } catch (Exception ex) {

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
}
