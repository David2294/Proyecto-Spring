package co.com.pizzeria.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categorias")
	private Integer id;
	@Column(name = "nombre_categorias")
	private String nombre;

	public Categoria() {
	}

	@Override
	public String toString() {
		return "Categoria [codigo=" + id + ", nombre=" + nombre + "]";
	}
	// Get

	public Categoria(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Integer getCodigo() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	// Set

	public void setCodigo(Integer id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
