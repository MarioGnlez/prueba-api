package com.tuvida.spotify.controller;

import com.tuvida.spotify.dto.CancionDTO;
import com.tuvida.spotify.service.CancionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/canciones")
public class CancionController {

    private final CancionService service;

    public CancionController(CancionService service) {
        this.service = service;
    }

    @PostMapping
    public CancionDTO crear(@RequestBody CancionDTO dto) {
        return service.guardarCancion(dto);
    }
}