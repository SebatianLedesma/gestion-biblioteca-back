package com.proyecto.biblioteca;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller API REST

@RestController
@RequestMapping("/api/v1")


public class LibroControlador {
	
	@Autowired private LibroRepositorio repository;

	//Return all the items
	
	@GetMapping("/libros") public List<Libro> allLibros(){
		
		return repository.findAll();		
	}
	
	//Return an specific book by title
	
    @GetMapping("/libros/{books}") public List<Libro> findByTitle(@PathVariable("title") String title){
		
		return repository.findByTitle(title);		
	}

	//Create a new User

    @PostMapping("/libros") public Libro createLibro(@RequestBody Libro book){
		
    	return repository.save(book);		
	}

    //Update an Id
    
    @PutMapping("/libros/{id}") public Libro updateLibro(@PathVariable Long id, @RequestBody Libro book){
		
		return repository.save(book);		
	}
    
    //Delete an Id
    
    @DeleteMapping("/libros/{id}") public void deleteLibro(@PathVariable("id") Long id){
		
		repository.deleteById(id);		
	}
    
  
}
