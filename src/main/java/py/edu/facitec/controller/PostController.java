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

import py.edu.facitec.model.Post;
import py.edu.facitec.repository.PostRepository;

@RestController
@CrossOrigin
@RequestMapping({ "/api/post" })
public class PostController {
	@Autowired
	private PostRepository postRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Post> getPosts() {
		List<Post> lista = postRepository.findAll();
		return lista;
	}

	@RequestMapping(value = " /findByid", method = RequestMethod.GET)
	public ResponseEntity<Optional<Post>> findById(@RequestParam(value = "id") Long id) {
		Optional<Post> list = postRepository.findById(id);
		return ResponseEntity.ok(list);
	}

	@PostMapping("/guardar")
	public ResponseEntity<Post> guardar(@RequestBody Post post) {
		post = postRepository.save(post);
		return ResponseEntity.ok(post);

	}

}
