package spring.boot.desafio.nubanck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.desafio.nubanck.dto.ContatoDTO;
import spring.boot.desafio.nubanck.model.Cliente;
import spring.boot.desafio.nubanck.model.Contato;
import spring.boot.desafio.nubanck.repository.ClienteRepository;
import spring.boot.desafio.nubanck.repository.ContatoRepository;

import java.util.Optional;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody ContatoDTO dto) {

        Optional<Cliente> clienteOpt = clienteRepository.findById(dto.getClienteId());
        if (clienteOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente não encontrado");
        }

        Contato contato = new Contato();
        contato.setTelefone(dto.getTelefone());
        contato.setEmail(dto.getEmail());
        contato.setCliente(clienteOpt.get());

        contatoRepository.save(contato);

        return ResponseEntity.status(HttpStatus.CREATED).body(contato);
    }

}
