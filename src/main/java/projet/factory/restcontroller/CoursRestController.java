package projet.factory.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
}
