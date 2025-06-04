package estudos.pizzaria.controller;


import estudos.pizzaria.domain.user.AdminService;
import estudos.pizzaria.domain.user.User;
import estudos.pizzaria.dto.CadastrosDTO;
import estudos.pizzaria.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gerenciador")
public class AdminController {
    private final AdminService adminService;
    private final UserRepository userRepository;

    public AdminController(AdminService adminService, UserRepository userRepository) {
        this.adminService = adminService;
        this.userRepository = userRepository;
    }

    @PostMapping("/removerPerfil")
    public ResponseEntity remover(@RequestBody CadastrosDTO dados){
        adminService.removerCadastro(dados);
        return ResponseEntity.ok("Apagado");
    }

    @GetMapping("/listar-usuarios")
    public ResponseEntity<List<User>> listarUsuarios(){
        List<User> usuarios = adminService.listarTodosUsuarios();

        if (usuarios.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(usuarios);
    }


}
