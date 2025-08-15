package com.alura.literalura.service;

import com.alura.literalura.dto.GutendexResponse;
import com.alura.literalura.dto.LibroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
public class GutendexService {

    private static final String BASE_URL = "https://gutendex.com/books/";
    private final RestTemplate restTemplate = new RestTemplate();

    public Optional<LibroDTO> buscarLibroPorTitulo(String titulo) {
        String url = BASE_URL + "?search=" + UriUtils.encode(titulo, StandardCharsets.UTF_8);
        ResponseEntity<GutendexResponse> response = restTemplate.getForEntity(url, GutendexResponse.class);
        GutendexResponse body = response.getBody();
        if (body != null && body.getResults() != null && !body.getResults().isEmpty()) {
            return Optional.of(body.getResults().get(0));
        }
        return Optional.empty();
    }
}
