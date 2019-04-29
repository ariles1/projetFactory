package projet.factory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projet.factory.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	

}
