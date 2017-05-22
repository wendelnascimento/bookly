package br.com.bookly.bean;


import javax.persistence.*;
import java.util.List;

/**
 * Created by wendelnascimento on 19/05/17.
 */
@Entity(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name =  "senha", nullable = false)
    private String senha;

    private String foto;

    @OneToOne(optional = false)
    private Cartao cartao;

    @Column(name = "admin", nullable = false)
    private boolean admin = false;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private ListaDesejos listaDesejos;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Compra> compras;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public ListaDesejos getListaDesejos() {
        return listaDesejos;
    }

    public void setListaDesejos(ListaDesejos listaDesejos) {
        this.listaDesejos = listaDesejos;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }
}
