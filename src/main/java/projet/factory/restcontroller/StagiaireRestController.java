package projet.factory.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projet.factory.entity.Stagiaire;
import projet.factory.repository.StagiaireRepository;

@RestController
@RequestMapping("/rest/stagiaire")
@CrossOrigin(origins="*")
public class StagiaireRestController {
	
	@Autowired
	StagiaireRepository stagiaireRepository;

	@GetMapping("")
	public List<Stagiaire> findAll(){
		return stagiaireRepository.findAll();
	}
	
}
