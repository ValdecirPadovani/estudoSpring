package br.com.devmedia.curso.dao;

import br.com.devmedia.curso.domain.Curso;
import br.com.devmedia.curso.exception.NaoExisteDaoException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CursoDaoImp implements CursoDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Curso curso) {
        entityManager.persist(curso);
    }

    @Override
    public void update(Curso curso) {
        entityManager.merge(curso);
    }

    @Override
    public void delete(Long id) {
        try {
            entityManager.remove(entityManager.getReference(Curso.class, id));
        }catch (EntityNotFoundException ex){
            throw new NaoExisteDaoException("Este curso não existe.");
        }
    }

    @Override
    public Curso findById(Long id) {
        Curso curso = entityManager.find(Curso.class, id);

        if(curso == null){
          throw new NaoExisteDaoException("Curso não encontrado para o código "+id+".");
        }

        return curso;
    }

    @Override
    public List<Curso> findAll() {
        return entityManager.createQuery("select c from Curso c", Curso.class).getResultList();
    }
}
