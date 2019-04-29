package projet.factory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projet.factory.entity.Cours;

public interface CoursRepository extends JpaRepository<Cours, Integer>{
	

}
