package estudos.pizzaria.infra.security;

import estudos.pizzaria.domain.user.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthUtils {
    public static String getUserId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof User user){
            return user.getId();

        }
        throw new RuntimeException("Usuário não autenticado");
    }

}
