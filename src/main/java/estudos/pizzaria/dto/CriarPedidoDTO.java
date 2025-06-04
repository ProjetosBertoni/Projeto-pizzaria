package estudos.pizzaria.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CriarPedidoDTO(
        @NotNull List<ItemDTO> itens
) {
    public record ItemDTO(
            @NotNull Long produtoId,
            @Min(1) Integer quantidade
    ) {}
}
