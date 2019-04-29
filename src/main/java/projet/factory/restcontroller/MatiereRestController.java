package projet.factory.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
}
