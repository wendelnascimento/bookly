package br.com.bookly.managedbean;

import br.com.bookly.bean.Frete;
import br.com.bookly.bean.Livro;
import br.com.bookly.dao.FreteDAO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wendelnascimento on 23/05/17.
 */
@ManagedBean
@SessionScoped
public class CarrinhoMB {
    private List<Livro> carrinho;

    private Double totalCarrinho = 0.0;

    private Frete frete;

    private FreteDAO freteDao = FreteDAO.getInstance();

    @ManagedProperty(value = "#{livroMB}")
    public LivroMB livroMB;

    public List<Livro> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(List<Livro> carrinho) {
        this.carrinho = carrinho;
    }

    public LivroMB getLivroMB() {
        return livroMB;
    }

    public void setLivroMB(LivroMB livroMB) {
        this.livroMB = livroMB;
    }

    public Double getTotalCarrinho() {
        return totalCarrinho;
    }

    public void setTotalCarrinho(Double totalCarrinho) {
        this.totalCarrinho = totalCarrinho;
    }

    public Frete getFrete() {
        return frete;
    }

    public void setFrete(Frete frete) {
        this.frete = frete;
    }

    public CarrinhoMB() {
        carrinho = new ArrayList<Livro>();
        frete = new Frete();
    }

    public String adicionaCarrinho() {
        try {
            carrinho.add(livroMB.getLivro());
            totalCarrinho += livroMB.getLivro().getPreco() - (livroMB.getLivro().getDesconto() == null ? 0.0 : livroMB.getLivro().getDesconto());
            return "carrinho";
        } catch(Exception ex) {
            return "erro";
        }
    }

    public String gotoConfirmar() {
        try {
            frete = freteDao.getFreteById(frete.getId());
            totalCarrinho += frete.getValor();
            return "confirmar";
        } catch (Exception ex) {
            return "erro";
        }

    }
}
