
package br.edu.infnet.infra.usuarios;

import br.edu.infnet.domain.usuarios.Usuario;
import java.util.HashMap;
import org.springframework.stereotype.Repository;


@Repository
public class UsuarioRepository {
    private HashMap<String, Usuario> usuarios;
    
    public UsuarioRepository() {
        usuarios = new HashMap<>();
        usuarios.put("jose.oliveira@infnet.edu", new Usuario("Jose Oliveira", "jose.oliveira@infnet.edu"));
        usuarios.put("maria.souza@infnet.edu", new Usuario("Maria Souza", "maria.souza@infnet.edu"));      
    }
    
    public Usuario obterPorEmail(String email) {
        return usuarios.get(email);
    
    }
    
    
    public Usuario inserir(Usuario usuario) {
        Usuario retorno = null;
        if(usuario.getEmail() != null && usuarios.get(usuario.getEmail()) == null) {
            usuarios.put(usuario.getEmail(), usuario);
            retorno = usuario;
        }      
        return retorno;
    }
    
}
