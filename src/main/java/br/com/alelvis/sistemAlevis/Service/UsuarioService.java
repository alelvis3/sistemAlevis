package br.com.alelvis.sistemAlevis.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alelvis.sistemAlevis.Repository.UsuarioRepository;
import br.com.alelvis.sistemAlevis.model.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public Usuario logar(String login, String senha) {
		return repository.findByLoginAndSenha(login, senha);
	}

}
