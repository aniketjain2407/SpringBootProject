package RawMaterial.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/student")
public class StudentController {

	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String getallStudent() {
		return "student/home";
	}
	
}
