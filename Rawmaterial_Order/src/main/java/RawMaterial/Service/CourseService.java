package RawMaterial.Service;

import java.util.List;
import java.util.Optional;

import RawMaterial.Model.Course;

public interface CourseService {
	
	List<Course> getall();
	Optional<Course> findById(int id);
	void deleteById(int id);
	void save(Course newCourse);
	void updateCourse(Optional<Course> prevDetails, Course newDetails);
	int getLatestId();


}
