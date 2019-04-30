package projet.factory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import projet.factory.entity.Stagiaire;

public interface StagiaireRepository extends JpaRepository<Stagiaire, Integer>{
	
	@Query("select s from Stagiaire s where s.formation.id=:id")
	List<Stagiaire> findAllStagiairesOfFormation(Integer id);
	

}
