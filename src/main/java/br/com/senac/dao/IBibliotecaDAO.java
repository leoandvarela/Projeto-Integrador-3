package br.com.senac.dao;

import br.com.senac.model.Biblioteca;
import java.util.List;

public interface IBibliotecaDAO {
    void cadastrar(Biblioteca biblioteca);
    void excluir(Long id);
    List<Biblioteca> listarTodos();
    List<Biblioteca> listarPorGenero(String genero);
}