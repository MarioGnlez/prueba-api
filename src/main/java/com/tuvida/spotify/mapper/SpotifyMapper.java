package com.tuvida.spotify.mapper;

import com.tuvida.spotify.domain.Artista;
import com.tuvida.spotify.domain.Cancion;
import com.tuvida.spotify.dto.ArtistaDTO;
import com.tuvida.spotify.dto.CancionDTO;
import org.springframework.stereotype.Component;

@Component
public class SpotifyMapper {

    // --- ARTISTA ---
    public ArtistaDTO toArtistaDTO(Artista artista) {
        if (artista == null) return null;
        ArtistaDTO dto = new ArtistaDTO();
        dto.setId(artista.getId());
        dto.setNombre(artista.getNombre());
        dto.setGenero(artista.getGenero());
        return dto;
    }

    public Artista toArtistaEntity(ArtistaDTO dto) {
        if (dto == null) return null;
        Artista artista = new Artista();
        // No seteamos ID porque lo genera la base de datos
        artista.setNombre(dto.getNombre());
        artista.setGenero(dto.getGenero());
        return artista;
    }

    // --- CANCION ---
    public CancionDTO toCancionDTO(Cancion cancion) {
        if (cancion == null) return null;
        CancionDTO dto = new CancionDTO();
        dto.setId(cancion.getId());
        dto.setTitulo(cancion.getTitulo());
        dto.setDuracionSegundos(cancion.getDuracionSegundos());
        if (cancion.getArtista() != null) {
            dto.setArtistaId(cancion.getArtista().getId());
        }
        return dto;
    }

    public Cancion toCancionEntity(CancionDTO dto, Artista artista) {
        if (dto == null) return null;
        Cancion cancion = new Cancion();
        cancion.setTitulo(dto.getTitulo());
        cancion.setDuracionSegundos(dto.getDuracionSegundos());
        cancion.setArtista(artista);
        return cancion;
    }
}