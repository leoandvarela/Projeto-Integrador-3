package br.com.senac.dao;

import br.com.senac.model.Usuario;

public interface IUsuarioDAO {
    Usuario login(String login, String senha);
}