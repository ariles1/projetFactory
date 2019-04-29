package projet.factory.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
}
