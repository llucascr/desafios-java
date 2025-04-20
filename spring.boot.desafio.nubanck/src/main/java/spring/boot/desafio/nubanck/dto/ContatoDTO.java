package spring.boot.desafio.nubanck.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContatoDTO {

    private String telefone;
    private String email;
    private Long clienteId;

}
