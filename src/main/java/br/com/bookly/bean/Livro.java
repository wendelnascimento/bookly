package br.com.bookly.bean;

import javax.persistence.*;

/**
 * Created by wendelnascimento on 19/05/17.
 */
@Entity(name = "livro")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

    @ManyToOne
    private Autor autor;

    @ManyToOne
    private Editora editora;
}
