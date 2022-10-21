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

public class EstudianteControlador {
	
	@Autowired 
	private EstudianteRepositorio repository;

	//Return all students in a list		
	@GetMapping("/estudiantes")
	public List<Estudiante> listarTodosLosEstudiantes() {
		return repository.findAll();
	}
		
	//Save the student
	@PostMapping("/estudiantes")
	public Estudiante guardarEstudiante(@RequestBody Estudiante estudiante) {
		return repository.save(estudiante);
	}
	
	//Search a student
	@GetMapping("/estudiantes/{id}")
	public ResponseEntity<Estudiante> obtenerEstudiantePorId(@PathVariable Long id){
		Estudiante estudiante = repository.findById(id)
						        .orElseThrow(() -> new ResourceNotFoundException("No existe el estudiante con el ID : " + id));
			return ResponseEntity.ok(estudiante);
	}
		
	    
  //Edit an specific student by id	
    @PutMapping("/estudiantes/{id}") 
    public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable Long id, @RequestBody Estudiante detallesEstudiante){
    	Estudiante estudiante = repository.findById(id)
						  .orElseThrow(()-> new ResourceNotFoundException("No existe el estudiante con el id: " + id));
		
    	
    	estudiante.setName(detallesEstudiante.getName());
    	estudiante.setSurname(detallesEstudiante.getSurname());
    	estudiante.setDocument_number(detallesEstudiante.getDocument_number());
    	estudiante.setDate_of_birth(detallesEstudiante.getDate_of_birth());
    	estudiante.setUser_id(detallesEstudiante.getUser_id());
    	estudiante.setDeleted(detallesEstudiante.getDeleted());
    			
    	Estudiante estudianteActualizado = repository.save(estudiante);
		
		return ResponseEntity.ok(estudianteActualizado);		
    }
    
    	  
    //Delete a User
  
  	@DeleteMapping("/estudiantes/{id}")
  	public ResponseEntity<Map<String,Boolean>> eliminarEstudiante(@PathVariable Long id){
  		Estudiante estudiante = repository.findById(id)
  				            .orElseThrow(() -> new ResourceNotFoundException("No existe el estudiante con el ID : " + id));
  		
  		repository.delete(estudiante);
  		Map<String, Boolean> respuesta = new HashMap<>();
  		respuesta.put("eliminar",Boolean.TRUE);
  		return ResponseEntity.ok(respuesta);
      }
    
 

}
