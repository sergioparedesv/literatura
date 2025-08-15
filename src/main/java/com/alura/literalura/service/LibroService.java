
package com.alura.literalura.service;

import com.alura.literalura.dto.LibroDTO;
import com.alura.literalura.exception.LibroNoEncontradoException;
import com.alura.literalura.model.Autor;
import com.alura.literalura.model.Libro;
import com.alura.literalura.repository.LibroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LibroService {

    private final LibroRepository libroRepository;
    private final AutorService autorService;
    private final GutendexService gutendexService;

    public LibroService(LibroRepository libroRepository, AutorService autorService, GutendexService gutendexService) {
        this.libroRepository = libroRepository;
        this.autorService = autorService;
        this.gutendexService = gutendexService;
    }

    @Transactional
    public Libro buscarPorTituloYRegistrar(String titulo) {
        return libroRepository.findByTituloIgnoreCase(titulo)
                .orElseGet(() -> {
                    LibroDTO dto = gutendexService.buscarLibroPorTitulo(titulo)
                            .orElseThrow(() -> new LibroNoEncontradoException(titulo));
                    Autor autor;
                    if (dto.getAuthors() != null && !dto.getAuthors().isEmpty()) {
                        autor = autorService.obtenerOCrear(dto.getAuthors().get(0));
                    } else {
                        com.alura.literalura.dto.AutorDTO desconocido = new com.alura.literalura.dto.AutorDTO();
                        desconocido.setName("Desconocido");
                        autor = autorService.obtenerOCrear(desconocido);
                    }
                    String idioma = (dto.getLanguages() != null && !dto.getLanguages().isEmpty())
                            ? dto.getLanguages().get(0)
                            : "desconocido";
                    Libro libro = new Libro(dto.getTitle(), idioma, autor);
                    return libroRepository.save(libro);
                });
    }

    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    public List<Libro> listarPorIdioma(String idioma) {
        return libroRepository.findByIdiomaIgnoreCase(idioma);
    }
}