package projet.factory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projet.factory.entity.Stagiaire;

public interface StagiaireRepository extends JpaRepository<Stagiaire, Integer>{
	

}
