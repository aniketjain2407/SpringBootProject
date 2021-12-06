package RawMaterial.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import RawMaterial.Model.Farmerfranchise;
import RawMaterial.Repo.RawMaterialRepo;

public interface RawMaterialService{
	List<Farmerfranchise> findAll();
	Farmerfranchise getById(Integer id);
	void save(Farmerfranchise ff);
	List<Farmerfranchise> searchbyid(List<Integer> ids);
	Farmerfranchise getlastff();
	void deletefarmerfranchise(Integer id);
}
