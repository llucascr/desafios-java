package spring.boot.desafio.nubanck.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponseDTO {

    private Long id;
    private String nome;
    private List<ContatoResponseDTO> contatos = new ArrayList<>();
}
