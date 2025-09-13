package br.com.senac.dao;

import br.com.senac.util.JPAUtil;

import br.com.senac.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class UsuarioDAO implements IUsuarioDAO {

    @Override
    public Usuario login(String login, String senha) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Usuario> query = em.createQuery(
                "SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha", Usuario.class
            );
            query.setParameter("login", login);
            query.setParameter("senha", senha);

            List<Usuario> usuarios = query.getResultList();
            return usuarios.isEmpty() ? null : usuarios.get(0);
        } finally {
            em.close();
        }
    }
}