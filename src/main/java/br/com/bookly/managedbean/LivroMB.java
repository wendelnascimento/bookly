package br.com.bookly.managedbean;

import br.com.bookly.bean.Livro;
import br.com.bookly.dao.LivroDAO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wendelnascimento on 21/05/17.
 */
@ManagedBean
@SessionScoped
public class LivroMB {
    private Livro livro;
    private List<Livro> livros;
    protected LivroDAO livroDAO = LivroDAO.getInstance();

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }


    public LivroMB() {
        livro = new Livro();
        livros = new ArrayList<Livro>();
    }

    public void cadastrar() {
        try {

            livroDAO.save(livro);
        } catch (Exception ex) {

        }
    }

    public String gotoCadastrar() {
        try {
            livro = new Livro();
            return "cadastro";
        } catch (Exception ex) {
            return "erro";
        }
    }
}
