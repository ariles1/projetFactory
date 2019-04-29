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

import projet.factory.entity.Matiere;
import projet.factory.repository.MatiereRepository;

@RestController
@RequestMapping("/rest/matiere")
@CrossOrigin(origins="*")
public class MatiereRestController {
	
	@Autowired
	MatiereRepository matiereRepository;

	@GetMapping("")
	public List<Matiere> findAll(){
		return matiereRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Matiere> findById(@PathVariable(name = "id") Integer id) {
		Optional<Matiere> opt = matiereRepository.findById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<Matiere>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("")
	public ResponseEntity<Void> insert(@Valid @RequestBody Matiere matiere, BindingResult br,
			UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		matiereRepository.save(matiere);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uCB.path("/rest/personne/{id}").buildAndExpand(matiere.getId()).toUri());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	@PutMapping("")
	private ResponseEntity<Void> update(@RequestBody Matiere matiere, BindingResult br) {
		if (br.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Matiere> opt = matiereRepository.findById(matiere.getId());
		if (opt.isPresent()) {
			matiere.setVersion(opt.get().getVersion());
			matiereRepository.save(matiere);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Integer id) {
		matiereRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}