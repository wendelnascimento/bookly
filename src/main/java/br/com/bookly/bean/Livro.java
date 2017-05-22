package br.com.bookly.bean;

import javax.persistence.*;
import java.util.List;

/**
 * Created by wendelnascimento on 19/05/17.
 */
@Entity(name = "Livro")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @ManyToOne(optional = false)
    private Autor autor;

    @ManyToOne(optional = false)
    private Editora editora;

    @ManyToOne(optional = false)
    private Assunto assunto;

    @Column(name = "preco", nullable = false)
    private Double preco;

    private Double desconto;

    @ManyToMany(mappedBy = "livros", cascade = CascadeType.ALL)
    private List<ListaDesejos> listaDesejos;

    @ManyToMany(mappedBy = "livros", cascade = CascadeType.ALL)
    private List<Compra> compras;

    public Livro() {
        autor = new Autor();
        editora = new Editora();
        assunto = new Assunto();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public Assunto getAssunto() {
        return assunto;
    }

    public void setAssunto(Assunto assunto) {
        this.assunto = assunto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public List<ListaDesejos> getListaDesejos() {
        return listaDesejos;
    }

    public void setListaDesejos(List<ListaDesejos> listaDesejos) {
        this.listaDesejos = listaDesejos;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }
}
