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
        bandeiras = new ArrayList<Bandeira>();
    }

    public void cadastrar() {
        try {
            bandeiraDAO.save(bandeira);
        } catch (Exception ex) {

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
}
