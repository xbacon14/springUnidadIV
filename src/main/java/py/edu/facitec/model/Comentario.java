package py.edu.facitec.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Comentario extends General {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private String texto;
	private Integer estrellas;
	
	@ManyToOne
	private Suscrito sucrito;
	
	@ManyToOne
	private Post post;
	
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public Suscrito getSucrito() {
		return sucrito;
	}
	public void setSucrito(Suscrito sucrito) {
		this.sucrito = sucrito;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Integer getEstrellas() {
		return estrellas;
	}
	public void setEstrellas(Integer estrellas) {
		this.estrellas = estrellas;
	}
	@Override
	public String toString() {
		return "Comentario [texto=" + texto + ", estrellas=" + estrellas + ", sucrito=" + sucrito + ", post=" + post
				+ "]";
	}
	
	

}
