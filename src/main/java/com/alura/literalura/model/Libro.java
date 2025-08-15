package com.alura.literalura.model;

import jakarta.persistence.*;

@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String titulo;

    private String idioma;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Autor autor;

    public Libro() {
    }

    public Libro(String titulo, String idioma, Autor autor) {
        this.titulo = titulo;
        this.idioma = idioma;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return titulo + " - " + (autor != null ? autor.getNombre() : "Desconocido") + " (" + idioma + ")";
    }
}
