package br.com.senac.service;

import br.com.senac.dao.IUsuarioDAO;
import br.com.senac.model.Usuario;

public class UsuarioService {

    private final IUsuarioDAO usuarioDAO;

    public UsuarioService(IUsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public Usuario login(String login, String senha) {
        return usuarioDAO.login(login, senha);
    }
}