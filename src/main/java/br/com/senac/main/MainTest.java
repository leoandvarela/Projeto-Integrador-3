package br.com.senac.main;

import br.com.senac.dao.BibliotecaDAO;
import br.com.senac.dao.UsuarioDAO;
import br.com.senac.model.Biblioteca;
import br.com.senac.service.BibliotecaService;
import br.com.senac.service.UsuarioService;

import java.util.List;

public class MainTest {
    public static void main(String[] args) {

        BibliotecaService bibliotecaService = new BibliotecaService(new BibliotecaDAO());
        UsuarioService usuarioService = new UsuarioService(new UsuarioDAO());

        // Teste Cadastro
        Biblioteca b = new Biblioteca();
        b.setAutor("Autor Teste");
        b.setNomeLivro("Livro Teste");
        b.setDataPublicacao("2025-09-12");
        b.setGenero("Ficção");
        bibliotecaService.cadastrar(b);

        // Teste Listagem
        List<Biblioteca> livros = bibliotecaService.listarTodos();
        livros.forEach(l -> System.out.println(l.getNomeLivro() + " - " + l.getAutor()));

        // Teste Login
        var usuario = usuarioService.login("admin", "123");
        if (usuario != null) {
            System.out.println("Login OK: " + usuario.getNome() + " (" + usuario.getTipo() + ")");
        } else {
            System.out.println("Login inválido!");
        }

        // Teste Exclusão
        bibliotecaService.excluir(b.getId());
        System.out.println("Registro excluído.");
    }
}