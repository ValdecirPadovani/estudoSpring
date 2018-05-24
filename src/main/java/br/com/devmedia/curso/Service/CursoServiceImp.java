package br.com.devmedia.curso.Service;

import br.com.devmedia.curso.dao.CursoDao;
import br.com.devmedia.curso.domain.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
@Transactional
public class CursoServiceImp implements CursoService{

    @Autowired
    private CursoDao dao;

    @Override
    public void save(Curso curso) {
        dao.save(curso);
    }

    @Override
    public void update(Long id, Curso curso) {
        curso.setId(id);
        dao.update(curso);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Curso findByid(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Curso> findAll() {
        return dao.findAll();
    }

    @Override
    /*
        Não precisa de usar o update do dao, pois o estado do objeto é Transiente
        Nesse caso ao usar o setDataInicio, ja será feio o update no banco
     */
    public Curso updateDataInicio(Long id, Date dataInicio) {
        Curso curso = dao.findById(id);
        curso.setDataInicio(dataInicio);
        return curso;
    }
}
