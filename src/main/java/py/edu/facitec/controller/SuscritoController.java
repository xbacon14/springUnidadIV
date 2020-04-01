package py.edu.facitec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.model.Suscrito;
import py.edu.facitec.repository.SuscritoRepository;

@RestController
@CrossOrigin
@RequestMapping({ "/api/suscrito" })
public class SuscritoController {

	@Autowired
	private SuscritoRepository suscritoRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Suscrito> getSuscritos() {
		List<Suscrito> lista = suscritoRepository.findAll();
		return lista;
	}

	@RequestMapping("/findByCodigo")
	public ResponseEntity<List<Suscrito>> findByCodigo(@RequestParam(name = "codigo") Long codigo) {
		List<Suscrito> list = suscritoRepository.findByCodigo(codigo);
		return ResponseEntity.ok(list);
	}

	@PostMapping("/guardar")
	public ResponseEntity<Suscrito> guardar(@RequestBody Suscrito suscrito) {
		suscrito = suscritoRepository.save(suscrito);
		return ResponseEntity.ok(suscrito);

	}
}
