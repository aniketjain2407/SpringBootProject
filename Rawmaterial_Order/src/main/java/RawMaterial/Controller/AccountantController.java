package RawMaterial.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/accountant")
public class AccountantController {
	
	@RequestMapping(value ="",method = RequestMethod.GET)
	public String home() {
		return "accountant/home";
	}

}
