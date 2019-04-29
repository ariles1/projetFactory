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

import projet.factory.entity.Cours;
import projet.factory.repository.CoursRepository;

@RestController
@RequestMapping("/rest/cours")
@CrossOrigin(origins="*")
public class CoursRestController {
	
	@Autowired
	CoursRepository coursRepository;

	@GetMapping("")
	public List<Cours> findAll(){
		return coursRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cours> findById(@PathVariable(name = "id") Integer id) {
		Optional<Cours> opt = coursRepository.findById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<Cours>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("")
	public ResponseEntity<Void> insert(@Valid @RequestBody Cours cours, BindingResult br,
			UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		coursRepository.save(cours);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uCB.path("/rest/personne/{id}").buildAndExpand(cours.getId()).toUri());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	@PutMapping("")
	private ResponseEntity<Void> update(@RequestBody Cours cours, BindingResult br) {
		if (br.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Cours> opt = coursRepository.findById(cours.getId());
		if (opt.isPresent()) {
			cours.setVersion(opt.get().getVersion());
			coursRepository.save(cours);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Integer id) {
		coursRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}