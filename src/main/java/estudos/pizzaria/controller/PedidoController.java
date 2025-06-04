package estudos.pizzaria.controller;

import estudos.pizzaria.domain.pedidos.Pedidos;
import estudos.pizzaria.domain.pedidos.PedidosService;
import estudos.pizzaria.dto.CriarPedidoDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidosService pedidosService;

    public PedidoController(PedidosService pedidosService) {
        this.pedidosService = pedidosService;
    }

    @PostMapping
    public ResponseEntity<?> criarPedido(@RequestBody @Valid CriarPedidoDTO dto){
        pedidosService.criarPedido(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Pedidos>> listarPedidosDoCliente(){
        return ResponseEntity.ok(pedidosService.listarPedidosDoCliente());
    }
}
