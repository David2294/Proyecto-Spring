package co.com.pizzeria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.pizzeria.models.entity.Categoria;
import co.com.pizzeria.repository.CategoriaRepository;

@Service
public class CategoriaServices {

	@Autowired
	private CategoriaRepository repository;

	public List<Categoria> findAll() throws Exception {
		return (List<Categoria>) repository.findAll();
	}

	public Categoria guardarNuevoResgistroCategoria(Categoria registroActualizado) {
		Categoria nuevoRegistro = repository.save(registroActualizado);
		return nuevoRegistro;
	}

	public Categoria actualizarUnregistroDeCategorias(Integer id, Categoria registroActualizado) {
		Categoria categoriaAntiguo = buscarCategoriaPorId(id);
		
		categoriaAntiguo.setNombre(registroActualizado.getNombre());
		Categoria categoriaNuevo = repository.save(categoriaAntiguo) ;
		
		return categoriaNuevo;
	}

	public Categoria buscarCategoriaPorId(Integer id) {
		Optional<Categoria> categorioaOptional = repository.findById(id);
		if (categorioaOptional.isEmpty()) {
			throw new NullPointerException("No se encontro datos con el ID : " + id);

		}
		return categorioaOptional.get();

	}
	public void eliminarResgistroCategoria(Integer id) {
		buscarCategoriaPorId(id);
		repository.deleteById(id);
	}

}
