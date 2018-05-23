package br.com.devmedia.curso.Service;

import br.com.devmedia.curso.domain.Curso;

import java.util.Date;
import java.util.List;

public interface CursoService {

    void save(Curso curso);

    void update(Long id, Curso curso);

    void delete(Long id);

    Curso findByid(Long id);

    List<Curso> findAll();

    Curso updateDataInicio(Long id, Date dataInicio);

}
