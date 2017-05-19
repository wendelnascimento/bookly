package br.com.bookly.bean;

import javax.persistence.*;
import java.util.List;

/**
 * Created by wendelnascimento on 19/05/17.
 */
@Entity(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY);
    private Integer id;

    private String nome;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Livro> livros;
}
