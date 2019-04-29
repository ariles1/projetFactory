package projet.factory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projet.factory.entity.Ordinateur;

public interface OrdinateurRepository extends JpaRepository<Ordinateur, Integer>{
	

}
