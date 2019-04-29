package projet.factory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projet.factory.entity.Enseigner;
import projet.factory.entity.EnseignerPk;

public interface EnseignerRepository extends JpaRepository<Enseigner, EnseignerPk>{
	

}
