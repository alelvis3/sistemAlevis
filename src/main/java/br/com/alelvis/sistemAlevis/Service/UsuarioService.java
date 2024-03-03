package br.com.alelvis.sistemAlevis.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alelvis.sistemAlevis.Repository.UsuarioRepository;
import br.com.alelvis.sistemAlevis.dto.LoginDTO;
import br.com.alelvis.sistemAlevis.dto.UsuarioDTO;
import br.com.alelvis.sistemAlevis.model.Usuario;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repository;

	public UsuarioDTO logar(LoginDTO loginDTO) {
		Usuario usuario = repository.findByLogin(loginDTO.login());

		// Adicione a lógica de verificação da senha e geração do token, se necessário

		return new UsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getPerfil());
	}
}