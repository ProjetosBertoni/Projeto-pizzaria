package estudos.pizzaria.controller;

import estudos.pizzaria.domain.cardapio.Produtos;
import estudos.pizzaria.domain.cardapio.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    private ProdutosService produtosService;

    @PostMapping
    public ResponseEntity<Produtos> adicionarPizza(@RequestBody Produtos produtos){
        Produtos salva = produtosService.adicionar(produtos);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPizza(@PathVariable Long id){
        produtosService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Produtos>> listarPizzas(){
        List<Produtos> produtos = produtosService.listar();
        if (produtos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(produtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produtos> atualizarPizza(@PathVariable Long id, @RequestBody Produtos novaProdutos){
        Produtos atualizada = produtosService.atualizar(id, novaProdutos);
        return ResponseEntity.ok(atualizada);
    }
}

