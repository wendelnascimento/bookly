package br.com.bookly.bean;

import javax.persistence.*;
import java.util.List;

/**
 * Created by wendelnascimento on 19/05/17.
 */
@Entity(name = "Lista_desejos")
public class ListaDesejos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(optional = false)
    private Usuario usuario;

    @ManyToMany
    @JoinTable(name = "lista_desejos_livro", catalog = "bookly", joinColumns = {
            @JoinColumn(name = "lista_desejos", nullable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "livro", nullable = false)
    })
    private List<Livro> livros;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}
