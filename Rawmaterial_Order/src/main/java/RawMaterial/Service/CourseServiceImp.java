package RawMaterial.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import RawMaterial.Model.Course;
import RawMaterial.Repo.CourseRepo;

@Component
public class CourseServiceImp implements CourseService {
	
	@Autowired
	CourseRepo courseRepo;

	@Override
	public List<Course> getall() {
		return courseRepo.findAll();
	}

	@Override
	public Optional<Course> findById(int id) {
		return courseRepo.findById(id);
	}

	@Override
	public void deleteById(int id) {
		courseRepo.deleteById(id);
	}

	@Override
	public void save(Course newCourse) {
		courseRepo.save(newCourse);
		
	}

	@Override
	public void updateCourse(Optional<Course> prevDetails, Course newDetails) {
		Course olddetails = prevDetails.get();
		olddetails.setActive(newDetails.isActive());
		olddetails.setField(newDetails.getField());
		olddetails.setMaxMarks(newDetails.getMaxMarks());
		olddetails.setMinMarks(newDetails.getMinMarks());
		olddetails.setName(newDetails.getName());
		olddetails.setPrice(newDetails.getPrice());
		olddetails.setDiscount(newDetails.getDiscount());
		olddetails.setTax(newDetails.getTax());
		
		courseRepo.save(olddetails);
	}

	@Override
	public int getLatestId() {
		int id = courseRepo.getLatestId();
		return id;
	}


}
