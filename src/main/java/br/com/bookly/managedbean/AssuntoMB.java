package br.com.bookly.managedbean;

import br.com.bookly.bean.Assunto;
import br.com.bookly.dao.AssuntoDAO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wendelnascimento on 21/05/17.
 */
@ManagedBean
@SessionScoped
public class AssuntoMB {
    private Assunto assunto;
    private List<Assunto> assuntos;
    protected AssuntoDAO assuntoDAO = AssuntoDAO.getInstance();

    public Assunto getAssunto() {
        return assunto;
    }

    public void setAssunto(Assunto assunto) {
        this.assunto = assunto;
    }

    public List<Assunto> getAssuntos() {
        return assuntos;
    }

    public void setAssuntos(List<Assunto> assuntos) {
        this.assuntos = assuntos;
    }

    public AssuntoMB() {
        assunto = new Assunto();
        assuntos = listar();
    }

    public String cadastrar() {
        try {
            assuntoDAO.save(assunto);
            return "index";
        } catch (Exception ex) {
            return "erro";
        }
    }

    public String gotoCadastrar() {
        try {
            assunto = new Assunto();
            return "cadastro";
        } catch (Exception ex) {
            return "erro";
        }
    }

    public List<Assunto> listar() {
        try {
            assuntos = assuntoDAO.assuntoList();
        } catch (Exception ex) {

        }
        return assuntos;
    }

    public String gotoListar() {
        try {
            assuntos = assuntoDAO.assuntoList();
            return "lista";
        } catch (Exception ex) {
            return "erro";
        }
    }

    public String editar() {
        try {
            assuntoDAO.update(assunto);
            return "index";
        } catch (Exception ex) {
            return "erro";
        }
    }

    public String gotoEditar() {
        try {
            assunto = assuntoDAO.getAssuntoById(assunto.getId());
            return "editar";
        } catch (Exception ex) {
            return "erro";
        }
    }

    public String deletar() {
        try {
            assuntoDAO.delete(assunto.getId());
            return "index";
        } catch (Exception ex) {
            return "erro";
        }
    }

    public String gotoDeletar() {
        try {
            assunto = assuntoDAO.getAssuntoById(assunto.getId());
            return "deletar";
        } catch (Exception ex) {
            return "erro";
        }
    }
}
