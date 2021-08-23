
package br.edu.infnet.infra.usuarios;

import br.edu.infnet.domain.usuarios.Usuario;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;

public class UsuarioService {
    
    private final String REST_URI = "http://localhost:8082/usuarios";
    private final Client client = ClientBuilder.newClient();
    
    public Usuario obterPorEmail(String email) {
        return client
                .target(REST_URI)
                .path("email")
                .path(email)
                .path("json")
                .request(MediaType.APPLICATION_JSON)
                .get(Usuario.class);
    }
    
    public Usuario criarConta(Usuario usuario) {
        return client.target(REST_URI)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(usuario, MediaType.APPLICATION_JSON), Usuario.class);
    }

//    private void target(String REST_URI) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
}