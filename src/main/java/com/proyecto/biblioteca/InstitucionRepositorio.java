package com.proyecto.biblioteca;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface InstitucionRepositorio extends JpaRepository<Institucion, Long>{
	
	List<Institucion> findByName(@Param("name") String name);

}
