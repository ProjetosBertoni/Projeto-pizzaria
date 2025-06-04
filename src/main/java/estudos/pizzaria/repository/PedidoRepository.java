package estudos.pizzaria.repository;

import estudos.pizzaria.domain.pedidos.Pedidos;
import estudos.pizzaria.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository  extends JpaRepository<Pedidos, Long> {
    List<Pedidos> findByCliente(User cliente);
}
