package py.edu.facitec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.model.Comentario;
import py.edu.facitec.repository.ComentarioRepository;

@RestController
@CrossOrigin
@RequestMapping({ "/api/comentario" })

public class ComentarioController {

	@Autowired
	private ComentarioRepository comentarioRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Comentario> getComentarios() {
		List<Comentario> lista = comentarioRepository.findAll();
		return lista;
	}

	@RequestMapping(value = " /findByCodigo", method = RequestMethod.GET)
	public ResponseEntity<Optional<Comentario>> findById(@RequestParam(value = "id") Long id) {
		Optional<Comentario> list = comentarioRepository.findById(id);
		return ResponseEntity.ok(list);
	}

	@PostMapping("/guardar")
	public ResponseEntity<Comentario> guardar(@RequestBody Comentario Comentario) {
		Comentario = comentarioRepository.save(Comentario);
		return ResponseEntity.ok(Comentario);

	}
}
