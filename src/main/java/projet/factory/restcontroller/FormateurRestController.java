package projet.factory.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projet.factory.entity.Formateur;
import projet.factory.repository.FormateurRepository;

@RestController
@RequestMapping("/rest/formateur")
@CrossOrigin(origins="*")
public class FormateurRestController {
	
	@Autowired
	FormateurRepository formateurRepository;

	@GetMapping("")
	public List<Formateur> findAll(){
		return formateurRepository.findAll();
	}
	
}
