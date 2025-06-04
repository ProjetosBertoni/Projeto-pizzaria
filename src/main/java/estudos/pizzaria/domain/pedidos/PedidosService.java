package estudos.pizzaria.domain.pedidos;

import estudos.pizzaria.domain.cardapio.Produtos;
import estudos.pizzaria.domain.user.User;
import estudos.pizzaria.dto.CriarPedidoDTO;
import estudos.pizzaria.infra.security.AuthUtils;
import estudos.pizzaria.repository.PedidoRepository;
import estudos.pizzaria.repository.ProdutoRepository;
import estudos.pizzaria.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidosService {
    private final PedidoRepository pedidoRepository;
    private final UserRepository userRepository;
    private final ProdutoRepository produtoRepository;


    public PedidosService(PedidoRepository pedidoRepository, UserRepository userRepository, ProdutoRepository produtoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.userRepository = userRepository;
        this.produtoRepository = produtoRepository;
    }

    public void criarPedido(CriarPedidoDTO dto) {
        String userId = AuthUtils.getUserId();
        User cliente = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        Pedidos pedidos = new Pedidos();
        pedidos.setCliente(cliente);

        List<ItemPedido> itens = dto.itens().stream().map(itemDTO -> {
            Produtos produtos = produtoRepository.findById(itemDTO.produtoId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));

            ItemPedido item = new ItemPedido();
            item.setProdutos(produtos);
            item.setQuantidade(itemDTO.quantidade());
            item.setPrecoUnitario(produtos.getPreco());
            item.setPedidos(pedidos);

            return item;
        }).toList();

        pedidos.setItens(itens);
        pedidos.calcularTotal();

        pedidoRepository.save(pedidos);
    }

    public List<Pedidos> listarPedidosDoCliente(){
        String idDoUsuario = AuthUtils.getUserId();
        User user = userRepository.findById(idDoUsuario).orElseThrow(() -> new RuntimeException("Usuario não encontrado!"));

        return pedidoRepository.findByCliente(user);
    }




}
