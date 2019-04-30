package projet.factory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import projet.factory.entity.Cours;

public interface CoursRepository extends JpaRepository<Cours, Integer>{

	@Query("select c from Cours c where c.formation.id=:id")
	List<Cours> findAllCoursesOfFormation(Integer id);
	

}
