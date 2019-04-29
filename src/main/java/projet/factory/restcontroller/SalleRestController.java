package projet.factory.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projet.factory.entity.Salle;
import projet.factory.repository.SalleRepository;

@RestController
@RequestMapping("/rest/salle")
@CrossOrigin(origins="*")
public class SalleRestController {
	
	@Autowired
	SalleRepository salleRepository;

	@GetMapping("")
	public List<Salle> findAll(){
		return salleRepository.findAll();
	}
	
}
