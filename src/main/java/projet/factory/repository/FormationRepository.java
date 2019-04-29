package projet.factory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projet.factory.entity.Formation;

public interface FormationRepository extends JpaRepository<Formation, Integer>{
	

}
