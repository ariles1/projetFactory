package projet.factory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projet.factory.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer>{
	

}
