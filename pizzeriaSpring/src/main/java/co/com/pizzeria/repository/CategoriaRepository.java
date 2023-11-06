package co.com.pizzeria.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.pizzeria.models.entity.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria,Integer>{
	
}
