package projet.factory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projet.factory.entity.Indisponibilite;

public interface IndisponibiliteRepository extends JpaRepository<Indisponibilite, Integer>{
	

}
