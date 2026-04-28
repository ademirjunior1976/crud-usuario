package br.com.usuario.crud_usuario.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.usuario.crud_usuario.model.Usuario;
import br.com.usuario.crud_usuario.repository.UsuarioRepository;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {
    
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	/**
     * @param name the name to greet
     * @return greeting text
     */
    

    
    
    @PostMapping(value = "/salvar") /*Medoto salvar da API*/
    @ResponseBody /* Retorna dados Json para o corpo da responsta*/
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) { /*Recebe dados para salvar*/
    	Usuario user = usuarioRepository.save(usuario);
    	return new ResponseEntity<Usuario>(user, HttpStatus.CREATED); /*Retorna a lista em JSON*/
    }
    
    
    @DeleteMapping(value = "/deletar") /*Medoto salvar da API*/
    @ResponseBody /* Retorna dados Json para o corpo da responsta*/
    public ResponseEntity<String> deletar(@RequestParam Long iduser) { /*Recebe dados para salvar*/
    	usuarioRepository.deleteById(iduser);
    	return new ResponseEntity<String>("Usuário deletado com sucesso !!!", HttpStatus.OK); /*Retorna a lista em JSON*/
    }
    
    
    @GetMapping(value = "/buscaruserid") /*Medoto salvar da API*/
    @ResponseBody /* Retorna dados Json para o corpo da responsta*/
    public ResponseEntity<Usuario> buscaruserid(@RequestParam(name = "iduser") Long iduser) { /*Recebe dados para salvar*/
    	Usuario usuario = usuarioRepository.findById(iduser).get();
    	return new ResponseEntity<Usuario>(usuario, HttpStatus.OK); /*Retorna a lista em JSON*/
    }
    
    
    @PutMapping(value = "/atualizar") /*Medoto salvar da API*/
    @ResponseBody /* Retorna dados Json para o corpo da responsta*/
    public ResponseEntity<?> atualizar(@RequestBody Usuario usuario) { /*Recebe dados para salvar*/
    	if (usuario.getId() == null) {
    		return new ResponseEntity<String>("Id do Usuário não pode ser nulo !!!", HttpStatus.OK); /*Retorna a lista em JSON*/
    	}
    	Usuario user = usuarioRepository.saveAndFlush(usuario);
    	return new ResponseEntity<Usuario>(user, HttpStatus.OK); /*Retorna a lista em JSON*/
    }

    
    @GetMapping(value = "/buscarpornome") /*Medoto salvar da API*/
    @ResponseBody /* Retorna dados Json para o corpo da responsta*/
    public ResponseEntity<List<Usuario>> buscarpornome(@RequestParam(name = "nome") String nome) { /*Recebe dados para salvar*/
    	List<Usuario> usuario = usuarioRepository.buscarpornome(nome.trim().toUpperCase());
    	return new ResponseEntity<List<Usuario>>(usuario, HttpStatus.OK); /*Retorna a lista em JSON*/
    }
    
    
    @GetMapping(value = "/listartodos") /*Medoto listartodos da API*/
    @ResponseBody /* Retorna dados Json para o corpo da responsta*/
    public ResponseEntity<List<Usuario>> listarUsuario() {
    	List<Usuario> usuario = usuarioRepository.findAll(); /*Executa a consulta no BD*/
    	return new ResponseEntity<List<Usuario>>(usuario, HttpStatus.OK); /*Retorna a lista em JSON*/
    }
    
    
    
}
