package RawMaterial.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import RawMaterial.Model.Course;
import RawMaterial.Service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	CourseService courseService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getall(Model model) {
		List<Course> allCourses = courseService.getall();
		Collections.reverse(allCourses);
		model.addAttribute("courses", allCourses);
		return "course/home";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public int save(@ModelAttribute Course newCourse) {
		//System.out.println(newCourse.isActive());
		courseService.save(newCourse);
		int id = courseService.getLatestId();
		return id;
	}
	
	@RequestMapping(value="/view/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Course view(@PathVariable int id) {
		Optional<Course> course = courseService.findById(id);
		return course.get();
	}
	
	@RequestMapping(value="/edit/{id}", method = RequestMethod.POST)
	@ResponseBody
	public int edit(@PathVariable int id, @ModelAttribute Course newDetails) {
		Optional<Course> prevDetails = courseService.findById(id);
		courseService.updateCourse(prevDetails, newDetails);
		return id;
		
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public String delete(@PathVariable int id) {
		courseService.deleteById(id);
		return "Ok";
	}
	
	
	
}
