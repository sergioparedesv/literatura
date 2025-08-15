package com.alura.literalura.service;

import com.alura.literalura.dto.AutorDTO;
import com.alura.literalura.model.Autor;
import com.alura.literalura.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Autor obtenerOCrear(AutorDTO dto) {
        String nombre = dto.getName() != null ? dto.getName() : "Desconocido";
        return autorRepository.findByNombreIgnoreCase(nombre)
                .orElseGet(() -> autorRepository.save(new Autor(
                        nombre, dto.getBirthYear(), dto.getDeathYear())));
    }

    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    public List<Autor> listarAutoresVivosEn(Integer year) {
        return autorRepository.findAutoresVivosEnAno(year);
    }
}
