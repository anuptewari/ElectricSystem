package electric.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import electric.system.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	// Method to find a user by email
	User findByEmail(String email);
}
