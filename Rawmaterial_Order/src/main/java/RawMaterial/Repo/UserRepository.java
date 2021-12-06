package RawMaterial.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import RawMaterial.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(value = "select max(id) from User")
	int getLatestId();

	User findByName(String username);
	
	
}
