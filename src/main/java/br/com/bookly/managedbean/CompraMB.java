package br.com.bookly.managedbean;

import br.com.bookly.bean.Compra;
import br.com.bookly.dao.CompraDAO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 * Created by wendelnascimento on 24/05/17.
 */
@ManagedBean
@SessionScoped
public class CompraMB {
    public Compra compra;

    @ManagedProperty(value = "#{carrinhoMB}")
    private CarrinhoMB carrinhoMB;

    @ManagedProperty(value = "#{usuarioMB}")
    private UsuarioMB usuarioMB;

    private CompraDAO compraDAO = CompraDAO.getInstance();

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public CarrinhoMB getCarrinhoMB() {
        return carrinhoMB;
    }

    public void setCarrinhoMB(CarrinhoMB carrinhoMB) {
        this.carrinhoMB = carrinhoMB;
    }

    public UsuarioMB getUsuarioMB() {
        return usuarioMB;
    }

    public void setUsuarioMB(UsuarioMB usuarioMB) {
        this.usuarioMB = usuarioMB;
    }

    public CompraMB() {
        compra = new Compra();
    }

    public String confirmar() {
        try {
            compra.setCartao(usuarioMB.getUsuario().getCartao());
            compra.setFrete(carrinhoMB.getFrete());
            compra.setUsuario(usuarioMB.getUsuario());
            compra.setValor(carrinhoMB.getTotalCarrinho());
            compra.setLivros(carrinhoMB.getCarrinho());
            compra.setId(null);
            compraDAO.save(compra);
            return "index";
        } catch (Exception ex) {
            return "erro";
        }
    }
}
