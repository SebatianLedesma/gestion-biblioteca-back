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
public class UserControlador {
	
	@Autowired 
	private UserRepositorio repository;

	//Return all users in a list		
	@GetMapping("/usuarios")
	public List<User> listarTodosLosUsuarios() {
		return repository.findAll();
	}
		
	//Save the user
	@PostMapping("/usuarios")
	public User saveUser(@RequestBody User user) {
		return repository.save(user);
	}
	
	//Search an user
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<User> getUserbyId(@PathVariable Long id){
		User user = repository.findById(id)
						        .orElseThrow(() -> new ResourceNotFoundException("No existe el usuario con el ID : " + id));
			return ResponseEntity.ok(user);
	}
		
	    
  //Edit an specific User by id	
    @PutMapping("/usuarios/{id}") 
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails){
		User user = repository.findById(id)
						  .orElseThrow(()-> new ResourceNotFoundException("No existe el usuario con el id: " + id));
		
		user.setCity_id(userDetails.getCity_id());
		user.setCountry_id(userDetails.getCountry_id());
		user.setEmail(userDetails.getEmail());
		user.setProvince_id(userDetails.getProvince_id());
		user.setDeleted(userDetails.getDeleted());
		
		
		User userUpdated = repository.save(user);
		
		return ResponseEntity.ok(userUpdated);		
    }
    
    	  
    //Delete a User
  
  	@DeleteMapping("/usuarios/{id}")
  	public ResponseEntity<Map<String,Boolean>> deleteUser(@PathVariable Long id){
  		User user = repository.findById(id)
  				            .orElseThrow(() -> new ResourceNotFoundException("No existe el usuario con el ID : " + id));
  		
  		repository.delete(user);
  		Map<String, Boolean> respuesta = new HashMap<>();
  		respuesta.put("eliminar",Boolean.TRUE);
  		return ResponseEntity.ok(respuesta);
      }
    
 

}
