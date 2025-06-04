package estudos.pizzaria.dto;

import estudos.pizzaria.domain.cardapio.Categoria;
import jakarta.validation.constraints.NotBlank;

public record ProdutosDTO(
        Long id,

        @NotBlank
        String nome,
        @NotBlank
        String sabor,
        Double preco,
        Categoria categoria

) {
}
