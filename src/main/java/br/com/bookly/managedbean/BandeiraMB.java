package br.com.bookly.managedbean;

import br.com.bookly.bean.Bandeira;
import br.com.bookly.dao.BandeiraDAO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wendelnascimento on 21/05/17.
 */
@ManagedBean
@SessionScoped
public class BandeiraMB {
    private Bandeira bandeira;
    private List<Bandeira> bandeiras;
    protected BandeiraDAO bandeiraDAO = BandeiraDAO.getInstance();

    public Bandeira getBandeira() {
        return bandeira;
    }

    public void setBandeira(Bandeira bandeira) {
        this.bandeira = bandeira;
    }

    public List<Bandeira> getBandeiras() {
        return bandeiras;
    }

    public void setBandeiras(List<Bandeira> bandeiras) {
        this.bandeiras = bandeiras;
    }

    public BandeiraMB() {
        bandeira = new Bandeira();
        bandeiras = listar();
    }

    public String cadastrar() {
        try {
            bandeiraDAO.save(bandeira);
            return "index";
        } catch (Exception ex) {
            return "erro";
        }
    }

    public String gotoCadastrar() {
        try {
            bandeira = new Bandeira();
            return "cadastro";
        } catch (Exception ex) {
            return "erro";
        }
    }

    public String editar() {
        try {
            bandeiraDAO.update(bandeira);
            return "index";
        } catch (Exception ex) {
            return "erro";
        }
    }

    public String gotoEditar() {
        try {
            bandeira = bandeiraDAO.getBandeiraById(bandeira.getId());
            return "editar";
        } catch (Exception ex) {
            return "erro";
        }
    }

    public List<Bandeira> listar() {
        try {
            bandeiras = bandeiraDAO.bandeiraList();
        } catch (Exception ex) {

        }
        return bandeiras;
    }

    public String gotoListar() {
        try {
            listar();
            return "lista";
        } catch (Exception ex) {
            return "erro";
        }
    }

    public String deletar() {
        try {
            bandeiraDAO.delete(bandeira.getId());
            return "index";
        } catch (Exception ex) {
            return "erro";
        }
    }

    public String gotoDeletar() {
        try {
            bandeira = bandeiraDAO.getBandeiraById(bandeira.getId());
            return "deletar";
        } catch (Exception ex) {
            return "erro";
        }
    }
}
