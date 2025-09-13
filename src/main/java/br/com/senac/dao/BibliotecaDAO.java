package br.com.senac.dao;

import br.com.senac.util.JPAUtil;
import br.com.senac.model.Biblioteca;
import br.com.senac.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class BibliotecaDAO implements IBibliotecaDAO {

    @Override
    public void cadastrar(Biblioteca biblioteca) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(biblioteca);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public void excluir(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Biblioteca b = em.find(Biblioteca.class, id);
            if (b != null) {
                em.getTransaction().begin();
                em.remove(b);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Biblioteca> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Biblioteca> query = em.createQuery("SELECT b FROM Biblioteca b", Biblioteca.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Biblioteca> listarPorGenero(String genero) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Biblioteca> query = em.createQuery(
                "SELECT b FROM Biblioteca b WHERE :genero IS NULL OR b.genero LIKE :genero", Biblioteca.class
            );
            query.setParameter("genero", (genero == null || genero.isEmpty()) ? null : "%" + genero + "%");
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}