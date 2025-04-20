package spring.boot.desafio.nubanck.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.desafio.nubanck.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
