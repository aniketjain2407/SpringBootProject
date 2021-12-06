package RawMaterial.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import RawMaterial.Model.Farmerfranchise;

@Repository
public interface RawMaterialRepo extends JpaRepository<Farmerfranchise, Integer> {
	
	//@Query(nativeQuery = true,value="SELECT ff FROM Farmerfranchise ff where ff.Id=:Id ORDER BY Id DESC LIMIT 1")
	@Query(nativeQuery = true,value="SELECT * FROM Farmerfranchise ff ORDER BY ff.Id DESC LIMIT 1")
	Farmerfranchise getlastff();


}
