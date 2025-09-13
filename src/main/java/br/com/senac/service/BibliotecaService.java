package br.com.senac.service;

import br.com.senac.dao.IBibliotecaDAO;
import br.com.senac.model.Biblioteca;
import java.util.List;

public class BibliotecaService {

    private final IBibliotecaDAO bibliotecaDAO;

    public BibliotecaService(IBibliotecaDAO bibliotecaDAO) {
        this.bibliotecaDAO = bibliotecaDAO;
    }

    public void cadastrar(Biblioteca b) {
        bibliotecaDAO.cadastrar(b);
    }

    public void excluir(Long id) {
        bibliotecaDAO.excluir(id);
    }

    public List<Biblioteca> listarTodos() {
        return bibliotecaDAO.listarTodos();
    }

    public List<Biblioteca> listarPorGenero(String genero) {
        return bibliotecaDAO.listarPorGenero(genero);
    }
}