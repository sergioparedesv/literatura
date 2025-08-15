package com.alura.literalura;

import com.alura.literalura.controller.MenuController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

    private final MenuController menuController;

    public LiteraluraApplication(MenuController menuController) {
        this.menuController = menuController;
    }

    public static void main(String[] args) {
        SpringApplication.run(LiteraluraApplication.class, args);
    }

    @Override
    public void run(String... args) {
        menuController.mostrarMenu();
    }
}
