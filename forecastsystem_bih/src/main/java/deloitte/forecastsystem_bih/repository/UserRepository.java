package deloitte.forecastsystem_bih.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import deloitte.forecastsystem_bih.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);
	
}
