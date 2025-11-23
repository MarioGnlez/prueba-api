package com.tuvida.spotify.service;

import com.tuvida.spotify.domain.Artista;
import com.tuvida.spotify.dto.ArtistaDTO;
import com.tuvida.spotify.mapper.SpotifyMapper;
import com.tuvida.spotify.repository.ArtistaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistaService {

    private final ArtistaRepository artistaRepository;
    private final SpotifyMapper mapper;

    public ArtistaService(ArtistaRepository artistaRepository, SpotifyMapper mapper) {
        this.artistaRepository = artistaRepository;
        this.mapper = mapper;
    }

    public List<ArtistaDTO> obtenerTodos() {
        return artistaRepository.findAll().stream()
                .map(mapper::toArtistaDTO)
                .collect(Collectors.toList());
    }

    public ArtistaDTO guardar(ArtistaDTO dto) {
        Artista entidad = mapper.toArtistaEntity(dto);
        Artista guardado = artistaRepository.save(entidad);
        return mapper.toArtistaDTO(guardado);
    }

    public void eliminar(Long id) {
        artistaRepository.deleteById(id);
    }
}