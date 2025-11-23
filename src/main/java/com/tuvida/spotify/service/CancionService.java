package com.tuvida.spotify.service;

import com.tuvida.spotify.domain.Artista;
import com.tuvida.spotify.domain.Cancion;
import com.tuvida.spotify.dto.CancionDTO;
import com.tuvida.spotify.mapper.SpotifyMapper;
import com.tuvida.spotify.repository.ArtistaRepository;
import com.tuvida.spotify.repository.CancionRepository;
import org.springframework.stereotype.Service;

@Service
public class CancionService {

    private final CancionRepository cancionRepository;
    private final ArtistaRepository artistaRepository;
    private final SpotifyMapper mapper;

    public CancionService(CancionRepository cancionRepository, ArtistaRepository artistaRepository, SpotifyMapper mapper) {
        this.cancionRepository = cancionRepository;
        this.artistaRepository = artistaRepository;
        this.mapper = mapper;
    }

    public CancionDTO guardarCancion(CancionDTO dto) {
        // 1. Buscamos el artista por el ID que viene en el DTO
        Artista artista = artistaRepository.findById(dto.getArtistaId())
                .orElseThrow(() -> new RuntimeException("Artista no encontrado"));

        // 2. Convertimos a entidad y le asignamos el artista
        Cancion cancion = mapper.toCancionEntity(dto, artista);

        // 3. Guardamos
        Cancion guardada = cancionRepository.save(cancion);

        return mapper.toCancionDTO(guardada);
    }
}