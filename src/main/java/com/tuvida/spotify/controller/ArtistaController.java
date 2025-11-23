package com.tuvida.spotify.controller;

import com.tuvida.spotify.dto.ArtistaDTO;
import com.tuvida.spotify.service.ArtistaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artistas")
public class ArtistaController {

    private final ArtistaService service;

    public ArtistaController(ArtistaService service) {
        this.service = service;
    }

    @GetMapping
    public List<ArtistaDTO> listar() {
        return service.obtenerTodos();
    }

    @PostMapping
    public ArtistaDTO crear(@RequestBody ArtistaDTO dto) {
        return service.guardar(dto);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id) {
        service.eliminar(id);
    }
}