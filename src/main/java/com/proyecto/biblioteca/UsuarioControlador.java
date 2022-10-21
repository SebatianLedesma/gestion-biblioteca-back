package com.proyecto.biblioteca;


import java.util.HashMap;
import java.util.Map;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gestion.usuario.excepciones.ResourceNotFoundException;



//Controller API REST

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")

public class UsuarioControlador {
	
	@Autowired 
	private UsuarioRepositorio repository;

	//Return all users in a list		
	@GetMapping("/usuarios")
	public List<Usuario> listarTodosLosUsuarios() {
		return repository.findAll();
	}
		
	//Save the user
	@PostMapping("/usuarios")
	public Usuario guardarUsuario(@RequestBody Usuario usuario) {
		return repository.save(usuario);
	}
	
	//Search an user
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id){
			Usuario usuario = repository.findById(id)
						        .orElseThrow(() -> new ResourceNotFoundException("No existe el usuario con el ID : " + id));
			return ResponseEntity.ok(usuario);
	}
		
	    
  //Edit an specific User by id	
    @PutMapping("/usuarios/{id}") 
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario detallesUsuario){
		Usuario usuario = repository.findById(id)
						  .orElseThrow(()-> new ResourceNotFoundException("No existe el usuario con el id: " + id));
		
		usuario.setName(detallesUsuario.getName());
		usuario.setLast_name_p(detallesUsuario.getLast_name_p());
		usuario.setLast_name_m(detallesUsuario.getLast_name_m());
		usuario.setDomicilio(detallesUsuario.getDomicilio());
		usuario.setTel(detallesUsuario.getTel());
		usuario.setSanctions(detallesUsuario.getSanctions());
		usuario.setSanc_money(detallesUsuario.getSanc_money());
		
		Usuario usuarioActualizado = repository.save(usuario);
		
		return ResponseEntity.ok(usuarioActualizado);		
    }
    
    	  
    //Delete a User
  
  	@DeleteMapping("/usuarios/{id}")
  	public ResponseEntity<Map<String,Boolean>> eliminarUsuario(@PathVariable Long id){
  		Usuario usuario = repository.findById(id)
  				            .orElseThrow(() -> new ResourceNotFoundException("No existe el usuario con el ID : " + id));
  		
  		repository.delete(usuario);
  		Map<String, Boolean> respuesta = new HashMap<>();
  		respuesta.put("eliminar",Boolean.TRUE);
  		return ResponseEntity.ok(respuesta);
      }
    
 

}
