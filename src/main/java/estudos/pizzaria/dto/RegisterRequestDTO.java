package estudos.pizzaria.dto;

import estudos.pizzaria.domain.roles.Role;

public record RegisterRequestDTO(String name, String email, String password, Role role) {
}
