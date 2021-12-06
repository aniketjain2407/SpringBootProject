package RawMaterial.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import RawMaterial.Model.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer>{

	@Query(value = "select max(id) from Course")
	int getLatestId();
	
	
	
}
