package com.alura.literalura.repository;

import com.alura.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    Optional<Autor> findByNombreIgnoreCase(String nombre);

    @Query("SELECT a FROM Autor a WHERE (:year >= a.fechaNacimiento OR a.fechaNacimiento IS NULL) " +
            "AND (:year <= a.fechaFallecimiento OR a.fechaFallecimiento IS NULL)")
    List<Autor> findAutoresVivosEnAno(@Param("year") Integer year);
}
