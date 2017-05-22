package br.com.bookly.managedbean;

import br.com.bookly.bean.Frete;
import br.com.bookly.dao.FreteDAO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wendelnascimento on 21/05/17.
 */
@ManagedBean
@SessionScoped
public class FreteMB {
    private Frete frete;
    private List<Frete> fretes;
    protected FreteDAO freteDAO = FreteDAO.getInstance();

    public Frete getFrete() {
        return frete;
    }

    public void setFrete(Frete frete) {
        this.frete = frete;
    }

    public List<Frete> getFretes() {
        return fretes;
    }

    public void setFretes(List<Frete> fretes) {
        this.fretes = fretes;
    }

    public FreteMB() {
        frete = new Frete();
        fretes = new ArrayList<Frete>();
    }

    public void cadastrar() {
        try {
            freteDAO.save(frete);
        } catch (Exception ex) {

        }
    }

    public String gotoCadastrar() {
        try {
            frete = new Frete();
            return "cadastro";
        } catch (Exception ex) {
            return "erro";
        }
    }
}
