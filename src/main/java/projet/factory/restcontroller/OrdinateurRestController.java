package projet.factory.restcontroller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import projet.factory.entity.Ordinateur;
import projet.factory.repository.OrdinateurRepository;

@RestController
@RequestMapping("/rest/ordinateur")
@CrossOrigin(origins="*")
public class OrdinateurRestController {
	
	@Autowired
	OrdinateurRepository ordinateurRepository;

	@GetMapping("")
	public List<Ordinateur> findAll(){
		return ordinateurRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Ordinateur> findById(@PathVariable(name = "id") Integer id) {
		Optional<Ordinateur> opt = ordinateurRepository.findById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<Ordinateur>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("")
	public ResponseEntity<Void> insert(@Valid @RequestBody Ordinateur ordinateur, BindingResult br,
			UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		ordinateurRepository.save(ordinateur);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uCB.path("/rest/personne/{id}").buildAndExpand(ordinateur.getId()).toUri());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	@PutMapping("")
	private ResponseEntity<Void> update(@RequestBody Ordinateur ordinateur, BindingResult br) {
		if (br.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Ordinateur> opt = ordinateurRepository.findById(ordinateur.getId());
		if (opt.isPresent()) {
			ordinateur.setVersion(opt.get().getVersion());
			ordinateurRepository.save(ordinateur);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Integer id) {
		ordinateurRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}