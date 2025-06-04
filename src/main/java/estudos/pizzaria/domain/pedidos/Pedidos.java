package estudos.pizzaria.domain.pedidos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import estudos.pizzaria.domain.user.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private Double total;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private User cliente;

    @OneToMany(mappedBy = "pedidos", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ItemPedido> itens;


    public void calcularTotal() {
        this.total = itens.stream()
                .mapToDouble(ItemPedido::getSubtotal)
                .sum();
    }

    public User getCliente() {
        return cliente;
    }

    public void setCliente(User cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
}
