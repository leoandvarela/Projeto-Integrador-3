📚 Projeto Biblioteca – Etapa 6

📌 Descrição

Este projeto é a refatoração do sistema de Biblioteca desenvolvido na fase anterior em Java Desktop (Swing).
O código foi reorganizado para preparar a migração para um sistema web, aplicando princípios SOLID e padrões de projeto.

O objetivo desta etapa é separar as responsabilidades, melhorar a manutenibilidade e deixar o código pronto para ser utilizado em frameworks modernos como Spring Boot.

🗂 Estrutura de pacotes

br.com.senac.controller   → Controladores (futuro uso no sistema web)
br.com.senac.dao          → Classes DAO e interfaces de acesso a dados
br.com.senac.model        → Entidades JPA (Biblioteca, Usuario)
br.com.senac.service      → Camada de regras de negócio (BibliotecaService, UsuarioService)
br.com.senac.util         → Classes utilitárias (ex.: JPAUtil)
br.com.senac.app          → Classe Principal com método main() para testes

✅ Funcionalidades

Gerenciamento de Livros (Biblioteca):

Cadastrar, excluir e listar livros.

Filtro por gênero.

Gerenciamento de Usuários:

Cadastro de usuários.

Login com validação de credenciais.

🔧 Tecnologias utilizadas

Java 17+

JPA / Hibernate

Banco de Dados Relacional (MySQL, H2 ou outro configurado)

Maven (para gerenciamento de dependências)

📐 Princípios aplicados

SRP (Responsabilidade Única): separação clara entre entidade, DAO, Service e Controller.

OCP (Aberto/Fechado): fácil expansão sem alterar código existente.

DIP (Inversão de Dependência): Services dependem de interfaces DAO.

DAO Pattern: isolamento do acesso a dados.

Service Layer Pattern: centralização da lógica de negócio.
