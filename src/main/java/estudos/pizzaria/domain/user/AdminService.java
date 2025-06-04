package estudos.pizzaria.domain.user;

import estudos.pizzaria.dto.CadastrosDTO;
import estudos.pizzaria.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final UserRepository userRepository;

    public AdminService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<String> removerCadastro(CadastrosDTO dados){
        Optional<User> deleteUser = userRepository.findByEmail(dados.email());

        userRepository.delete(deleteUser.get());

        return ResponseEntity.ok("Perfil removido com sucesso!");
    }

    public List<User> listarTodosUsuarios(){
        return userRepository.findAll();

    }

}
