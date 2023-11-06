package co.com.pizzeria.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import co.com.pizzeria.models.entity.Categoria;
import co.com.pizzeria.services.CategoriaServices;

@RestController
@RequestMapping("/api/categoria")
@CrossOrigin("*")
public class CategoriaController {

	private static final Logger log = LoggerFactory.getLogger(CategoriaController.class);

	@Autowired
	private CategoriaServices services;
	@GetMapping()
	public ResponseEntity<?> bucarTodasLasCategorias() throws Exception {
		
		List<Categoria> listaCategoriasResponse = services.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(listaCategoriasResponse);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> bucarCategoriasPorId(@PathVariable Integer id) throws Exception {
		
		Categoria categoriasResponse = services.buscarCategoriaPorId(id);
		return ResponseEntity.status(HttpStatus.OK).body(categoriasResponse);
	}
	@PostMapping()
	public ResponseEntity<?> nuevoResgistroDeCategorias(@RequestBody Categoria categoriaNueva) {
		Categoria categoriasResponse = services.guardarNuevoResgistroCategoria(categoriaNueva);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriasResponse);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarLaCategoriaCategorias(@PathVariable Integer id,@RequestBody Categoria categoriaActualizar) {
		
		Categoria categoriasResponse = services.actualizarUnregistroDeCategorias(id,categoriaActualizar);
		return ResponseEntity.status(HttpStatus.OK).body(categoriasResponse);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> borrarLaCategoriaCategorias(@PathVariable Integer id) {
		services.eliminarResgistroCategoria(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Se elimino correctamente el resgistro de ID : "+id);
	}

}
