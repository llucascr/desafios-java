package spring.boot.desafio.nubanck.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.desafio.nubanck.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
