package spring.boot.desafio.nubanck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.boot.desafio.nubanck.dto.ClienteDTO;
import spring.boot.desafio.nubanck.dto.ClienteResponseDTO;
import spring.boot.desafio.nubanck.dto.ContatoResponseDTO;
import spring.boot.desafio.nubanck.model.Cliente;
import spring.boot.desafio.nubanck.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody ClienteDTO dto) {
        Cliente clienteSalvo = clienteService.salvarClientes(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listarTodos() {
        return ResponseEntity.ok(clienteService.listarTodos());
    }

    @GetMapping("/{id}/contatos")
    public ResponseEntity<List<ContatoResponseDTO>> listarContatosPorCliente(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.listarContatosPorCliente(id));
    }

}
