package br.com.bookly.managedbean;

import br.com.bookly.bean.Livro;

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
    public List<Livro> carrinho;

    public Double totalCarrinho = 0.0;

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

    public CarrinhoMB() {
        carrinho = new ArrayList<Livro>();
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
}
