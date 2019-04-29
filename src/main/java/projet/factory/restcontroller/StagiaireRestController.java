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

import com.fasterxml.jackson.annotation.JsonView;

import projet.factory.entity.Stagiaire;
import projet.factory.entity.view.JsonViews;
import projet.factory.repository.StagiaireRepository;

@RestController
@RequestMapping("/rest/stagiaire")
@CrossOrigin(origins="*")
public class StagiaireRestController {
	
	@Autowired
	StagiaireRepository stagiaireRepository;

	@GetMapping("")
	@JsonView(JsonViews.StagiaireWithOrdinateur.class)
	public List<Stagiaire> findAll(){
		return stagiaireRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Stagiaire> findById(@PathVariable(name = "id") Integer id) {
		Optional<Stagiaire> opt = stagiaireRepository.findById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<Stagiaire>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("")
	public ResponseEntity<Void> insert(@Valid @RequestBody Stagiaire stagiaire, BindingResult br,
			UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		stagiaireRepository.save(stagiaire);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uCB.path("/rest/personne/{id}").buildAndExpand(stagiaire.getId()).toUri());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	@PutMapping("")
	private ResponseEntity<Void> update(@RequestBody Stagiaire stagiaire, BindingResult br) {
		if (br.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Stagiaire> opt = stagiaireRepository.findById(stagiaire.getId());
		if (opt.isPresent()) {
			stagiaire.setVersion(opt.get().getVersion());
			stagiaireRepository.save(stagiaire);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Integer id) {
		stagiaireRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}