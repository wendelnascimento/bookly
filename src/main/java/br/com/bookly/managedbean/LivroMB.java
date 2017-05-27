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
        livros = listar();
    }

    public String cadastrar() {
        try {
            livroDAO.save(livro);
            listar();
            return "index";
        } catch (Exception ex) {
            return "erro";
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

    public List<Livro> listar() {
        try {
            livros = livroDAO.livroList();
            for(Livro livroNew: livros) {
                livroNew = livroDAO.getLivroById(livroNew.getId());
            }
        } catch (Exception ex) {

        }
        return livros;
    }

    public String gotoListar() {
        try {
            listar();
            return "lista";
        } catch (Exception ex) {
            return "erro";
        }
    }

    public String editar() {
        try {
            livroDAO.update(livro);
            listar();
            return "index";
        } catch (Exception ex) {
            return "erro";
        }
    }

    public String gotoEditar() {
        try {
            livro = livroDAO.getLivroById(livro.getId());
            return "editar";
        } catch (Exception ex) {
            return "erro";
        }
    }

    public String deletar() {
        try {
            livroDAO.delete(livro.getId());
            return "index";
        } catch (Exception ex) {
            return "erro";
        }
    }

    public String gotoDeletar() {
        try {
            livro = livroDAO.getLivroById(livro.getId());
            return "deletar";
        } catch (Exception ex) {
            return "erro";
        }
    }

    public String gotoLivro() {
        try {
            livro = livroDAO.getLivroById(livro.getId());
            return "livro";
        } catch(Exception ex) {
            return "erro";
        }
    }

    public String pesquisar() {
        try {
            livros = livroDAO.getLivroByName(livro.getTitulo());
            return "index";
        } catch (Exception ex) {
            return "erro";
        }
    }
}
