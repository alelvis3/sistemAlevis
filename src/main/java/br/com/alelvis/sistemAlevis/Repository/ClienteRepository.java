package br.com.alelvis.sistemAlevis.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alelvis.sistemAlevis.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
