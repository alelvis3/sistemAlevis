package br.com.alelvis.sistemAlevis.dto;

import br.com.alelvis.sistemAlevis.model.Perfil;

public record UsuarioDTO(Long id, String nome, Perfil perfil) {}
