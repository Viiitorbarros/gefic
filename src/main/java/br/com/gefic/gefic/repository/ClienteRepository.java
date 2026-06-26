package br.com.gefic.gefic.repository;

import br.com.gefic.gefic.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
