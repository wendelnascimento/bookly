package br.com.bookly.managedbean;

import br.com.bookly.bean.Editora;
import br.com.bookly.dao.EditoraDAO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wendelnascimento on 21/05/17.
 */
@ManagedBean
@SessionScoped
public class EditoraMB {
    private Editora editora;
    private List<Editora> editoras;
    protected EditoraDAO editoraDAO = EditoraDAO.getInstance();

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public List<Editora> getEditoras() {
        return editoras;
    }

    public void setEditoras(List<Editora> editoras) {
        this.editoras = editoras;
    }

    public EditoraMB() {
        editora = new Editora();
        editoras = listar();
    }

    public void cadastrar() {
        try {
            editoraDAO.save(editora);
        } catch (Exception ex) {

        }
    }

    public String gotoCadastrar() {
        try {
            editora = new Editora();
            return "cadastro";
        } catch (Exception ex) {
            return "erro";
        }
    }

    public List<Editora> listar() {
        try {
            editoras = editoraDAO.editoraList();
        } catch (Exception ex) {

        }
        return editoras;
    }
}
