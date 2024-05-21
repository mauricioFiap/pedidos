package br.com.fiap.mscliente.repository;

// Repositório ClienteRepository
import br.com.fiap.mscliente.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
