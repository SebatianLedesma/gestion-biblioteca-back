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

public class InstitucionControlador {
	
	@Autowired 
	private InstitucionRepositorio repository;

	//Return all institutions in a list		
	@GetMapping("/instituciones")
	public List<Institucion> listarTodasLasInstituciones() {
		return repository.findAll();
	}
		
	//Save the user
	@PostMapping("/instituciones")
	public Institucion guardarInstitucion(@RequestBody Institucion institucion) {
		return repository.save(institucion);
	}
	
	//Search an institution
	@GetMapping("/instituciones/{id}")
	public ResponseEntity<Institucion> obtenerInstitucionPorId(@PathVariable Long id){
		Institucion institucion = repository.findById(id)
						        .orElseThrow(() -> new ResourceNotFoundException("No existe el institución con el ID : " + id));
			return ResponseEntity.ok(institucion);
	}
		
	    
  //Edit an specific institution by id	
    @PutMapping("/instituciones/{id}") 
    public ResponseEntity<Institucion> actualizarInstitucion(@PathVariable Long id, @RequestBody Institucion detallesInstitucion){
    	Institucion institucion = repository.findById(id)
						  .orElseThrow(()-> new ResourceNotFoundException("No existe la institución con el id: " + id));
		
		institucion.setName(detallesInstitucion.getName());
		institucion.setCuit_number(detallesInstitucion.getCuit_number());
		institucion.setUser_id(detallesInstitucion.getUser_id());
		

		
		Institucion institucionActualizada = repository.save(institucion);
		
		return ResponseEntity.ok(institucionActualizada);		
    }
    
    	  
    //Delete an institution
  
  	@DeleteMapping("/instituciones/{id}")
  	public ResponseEntity<Map<String,Boolean>> eliminarInstitucion(@PathVariable Long id){
  		Institucion institucion = repository.findById(id)
  				            .orElseThrow(() -> new ResourceNotFoundException("No existe la institución con el ID : " + id));
  		
  		repository.delete(institucion);
  		Map<String, Boolean> respuesta = new HashMap<>();
  		respuesta.put("eliminar",Boolean.TRUE);
  		return ResponseEntity.ok(respuesta);
      }
    
 

}
