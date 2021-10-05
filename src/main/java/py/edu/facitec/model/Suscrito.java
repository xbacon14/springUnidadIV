package py.edu.facitec.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity

public class Suscrito {

	public Suscrito() {
		super();
	}

	public Suscrito(Long codigo) {
		super();
		this.codigo = codigo;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String correo;
	private String nombre;

	@OneToMany(mappedBy = "suscrito")
	@JsonManagedReference(value = "cs")
	private List<Comentario> comentarios;

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Long getCodigo() {
		return codigo;

	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Suscrito [codigo=" + codigo + ", correo=" + correo + ", nombre=" + nombre + ", comentarios="
				+ comentarios + "]";
	}

}
