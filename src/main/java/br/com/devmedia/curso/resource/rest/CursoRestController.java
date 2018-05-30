package br.com.devmedia.curso.resource.rest;

import br.com.devmedia.curso.Service.CursoService;
import br.com.devmedia.curso.domain.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(
        value = "/cursos",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class CursoRestController {

    @Autowired
    private CursoService service;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        service.delete(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Curso editarDataInicio(@PathVariable("id") Long id, @RequestBody Curso curso){
        return service.updateDataInicio(id, curso.getDataInicio());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Curso updateCuros(@PathVariable("id") Long id, @RequestBody Curso curso){
        service.update(id, curso);
        return curso;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Curso getCurso(@PathVariable("id") Long id){
        return service.findByid(id);
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Curso curso){

        service.save(curso);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(curso.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Curso> listar(){
        return service.findAll();
    }

}
