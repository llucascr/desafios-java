package spring.boot.desafio.nubanck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.desafio.nubanck.dto.ClienteDTO;
import spring.boot.desafio.nubanck.dto.ClienteResponseDTO;
import spring.boot.desafio.nubanck.dto.ContatoResponseDTO;
import spring.boot.desafio.nubanck.model.Cliente;
import spring.boot.desafio.nubanck.model.Contato;
import spring.boot.desafio.nubanck.repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvarClientes(ClienteDTO dto) {

        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());

        if (dto.getContatos() != null && dto.getContatos().size() > 0) {
            List<Contato> contatos = dto.getContatos()
                    .stream().map(c -> {
                        Contato contato = new Contato();
                        contato.setTelefone(c.getTelefone());
                        contato.setEmail(c.getEmail());
                        contato.setCliente(cliente);
                        return contato;
                    }).toList();
            cliente.setContatos(contatos);
        }

        return clienteRepository.save(cliente);
    }

    public List<ClienteResponseDTO> listarTodos() {
        return clienteRepository.findAll().stream().map(this::toDTO).toList();
    }

    public List<ContatoResponseDTO> listarContatosPorCliente(Long clienteId) {

        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        return cliente.getContatos().stream()
                .map(c -> {
                    ContatoResponseDTO contatoDTO = new ContatoResponseDTO();
                    contatoDTO.setId(c.getId());
                    contatoDTO.setTelefone(c.getTelefone());
                    contatoDTO.setEmail(c.getEmail());
                    return contatoDTO;
                }).toList();
    }

    private ClienteResponseDTO toDTO(Cliente cliente) {
        ClienteResponseDTO dto = new ClienteResponseDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());

        List<ContatoResponseDTO> contatos = cliente.getContatos()
                .stream().map(c -> {
                    ContatoResponseDTO contatoDTO = new ContatoResponseDTO();
                    contatoDTO.setId(c.getId());
                    contatoDTO.setTelefone(c.getTelefone());
                    contatoDTO.setEmail(c.getEmail());
                    return contatoDTO;
                }).toList();
        dto.setContatos(contatos);
        return dto;
    }


}
