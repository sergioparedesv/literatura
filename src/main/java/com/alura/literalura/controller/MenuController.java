package com.alura.literalura.controller;

import com.alura.literalura.exception.LibroNoEncontradoException;
import com.alura.literalura.model.Autor;
import com.alura.literalura.model.Libro;
import com.alura.literalura.service.AutorService;
import com.alura.literalura.service.LibroService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class MenuController {

    private final LibroService libroService;
    private final AutorService autorService;

    public MenuController(LibroService libroService, AutorService autorService) {
        this.libroService = libroService;
        this.autorService = autorService;
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Buscar libro por título");
            System.out.println("2. Listar todos los libros");
            System.out.println("3. Listar autores registrados");
            System.out.println("4. Listar autores vivos en un año");
            System.out.println("5. Listar libros por idioma");
            System.out.println("0. Salir");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }
            switch (opcion) {
                case 1 -> buscarLibro(scanner);
                case 2 -> listarLibros();
                case 3 -> listarAutores();
                case 4 -> listarAutoresVivos(scanner);
                case 5 -> listarLibrosPorIdioma(scanner);
                case 0 -> System.out.println("Hasta luego!");
                default -> System.out.println("Opción inválida");
            }
        }
    }

    private void buscarLibro(Scanner scanner) {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        try {
            Libro libro = libroService.buscarPorTituloYRegistrar(titulo);
            System.out.println("Encontrado: " + libro);
        } catch (LibroNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    private void listarLibros() {
        List<Libro> libros = libroService.listarLibros();
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados");
        } else {
            libros.forEach(System.out::println);
        }
    }

    private void listarAutores() {
        List<Autor> autores = autorService.listarAutores();
        if (autores.isEmpty()) {
            System.out.println("No hay autores registrados");
        } else {
            autores.forEach(System.out::println);
        }
    }

    private void listarAutoresVivos(Scanner scanner) {
        System.out.print("Año: ");
        int year = Integer.parseInt(scanner.nextLine());
        List<Autor> autores = autorService.listarAutoresVivosEn(year);
        if (autores.isEmpty()) {
            System.out.println("No se encontraron autores vivos en ese año");
        } else {
            autores.forEach(System.out::println);
        }
    }

    private void listarLibrosPorIdioma(Scanner scanner) {
        System.out.print("Idioma: ");
        String idioma = scanner.nextLine();
        List<Libro> libros = libroService.listarPorIdioma(idioma);
        if (libros.isEmpty()) {
            System.out.println("No se encontraron libros en ese idioma");
        } else {
            libros.forEach(System.out::println);
        }
    }
