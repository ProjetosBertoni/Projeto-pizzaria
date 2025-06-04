package estudos.pizzaria.repository;

import estudos.pizzaria.domain.cardapio.Produtos;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produtos, Long> {

    Optional findByNome(@NotBlank String nome);
}
