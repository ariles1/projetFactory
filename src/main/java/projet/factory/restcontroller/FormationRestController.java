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

import projet.factory.entity.Formation;
import projet.factory.entity.view.JsonViews;
import projet.factory.repository.FormationRepository;

@RestController
@RequestMapping("/rest/formation")
@CrossOrigin(origins="*")
public class FormationRestController {
	
	@Autowired
	FormationRepository formationRepository;

	
	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<Formation> findAll(){
		return formationRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Formation> findById(@PathVariable(name = "id") Integer id) {
		Optional<Formation> opt = formationRepository.findById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<Formation>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("")
	public ResponseEntity<Void> insert(@Valid @RequestBody Formation formation, BindingResult br,
			UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		formationRepository.save(formation);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uCB.path("/rest/personne/{id}").buildAndExpand(formation.getId()).toUri());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	@PutMapping("")
	private ResponseEntity<Void> update(@RequestBody Formation formation, BindingResult br) {
		if (br.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Formation> opt = formationRepository.findById(formation.getId());
		if (opt.isPresent()) {
			formation.setVersion(opt.get().getVersion());
			formationRepository.save(formation);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Integer id) {
		formationRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}