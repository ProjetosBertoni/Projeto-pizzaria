package estudos.pizzaria.domain.cardapio;

import estudos.pizzaria.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProdutosService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produtos adicionar(Produtos produtos) {
        if (produtoRepository.findByNome(produtos.getNome()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Pizza já cadastrada!");
        }
        return produtoRepository.save(produtos);
    }

    public void remover(Long id) {
        Produtos produtos = produtoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pizza não encontrada!"));
        produtoRepository.delete(produtos);
    }

    public List<Produtos> listar() {
        return produtoRepository.findAll();
    }

    public Produtos atualizar(Long id, Produtos novaProdutos) {
        Produtos produtosExistente = produtoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pizza não encontrada!"));
        produtosExistente.setNome(novaProdutos.getNome());
        produtosExistente.setSabor(novaProdutos.getSabor());
        produtosExistente.setPreco(novaProdutos.getPreco());
        return produtoRepository.save(produtosExistente);
    }
}
