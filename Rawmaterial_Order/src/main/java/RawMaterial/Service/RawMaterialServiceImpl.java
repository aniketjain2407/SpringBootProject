package RawMaterial.Service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import RawMaterial.Model.Farmerfranchise;
import RawMaterial.Repo.RawMaterialRepo;

@Component
public class RawMaterialServiceImpl implements RawMaterialService {
	
	@Autowired
	private RawMaterialRepo repo;
	
	@PersistenceContext
    EntityManager entityManager;
	
	@Override
	public List<Farmerfranchise> findAll() {
		return repo.findAll();
	}

	@Override
	public Farmerfranchise getById(Integer id) {
		return repo.getById(id);
	}

	@Override
	public void save(Farmerfranchise ff) {
		repo.save(ff);
	}
	
	public List<Farmerfranchise> searchbyid(List<Integer> ids){
		return repo.findAllById(ids);
	}
	@Override
	public Farmerfranchise getlastff() {
		return repo.getlastff();
	}

	@Override
	public void deletefarmerfranchise(Integer id) {
		repo.deleteById(id);
		
	}



}
