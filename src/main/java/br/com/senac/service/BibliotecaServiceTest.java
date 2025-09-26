package br.com.senac.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LivroValidator {
    public static void validarNovoLivro(String titulo, String autor) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("O título do livro não pode ser vazio.");
        }
        if (autor != null && autor.length() > 50) {
            throw new IllegalArgumentException("O nome do autor deve ter no máximo 50 caracteres.");
        }
    }
}

public class BibliotecaServiceTest {

    // Simulação do service para testes (pode ser o validator diretamente)
    private LivroValidator validator;

    @BeforeEach
    void setUp() {
        validator = new LivroValidator();
    }

    // Testes de Validação de Adição de Livro

    @Test
    void deveAceitarLivroComDadosValidos() {
        // Cenário: Título e Autor válidos
        String titulo = "O Nome do Vento";
        String autor = "Patrick Rothfuss";

        // Verifica se o método não lança exceção (passa)
        assertDoesNotThrow(() -> validator.validarNovoLivro(titulo, autor),
            "Não deve lançar exceção para dados válidos.");
    }

    @Test
    void deveLancarExcecaoQuandoTituloForNulo() {
        // Cenário: Título nulo
        String titulo = null;
        String autor = "Autor Válido";

        // Verifica se o método lança a exceção esperada
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
            validator.validarNovoLivro(titulo, autor)
        );

        // Verifica a mensagem da exceção (melhora a clareza do erro)
        assertEquals("O título do livro não pode ser vazio.", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoNomeDoAutorForMuitoLongo() {
        // Cenário: Nome do autor com mais de 50 caracteres
        String titulo = "Livro com Título";
        String autorMuitoLongo = "A".repeat(51); // 51 caracteres

        // Verifica se o método lança a exceção esperada
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
            validator.validarNovoLivro(titulo, autorMuitoLongo)
        );

        // Verifica a mensagem da exceção
        assertEquals("O nome do autor deve ter no máximo 50 caracteres.", exception.getMessage());
    }
}