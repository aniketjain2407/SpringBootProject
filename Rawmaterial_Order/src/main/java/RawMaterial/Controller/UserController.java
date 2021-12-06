package RawMaterial.Controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import RawMaterial.Model.User;
import RawMaterial.Service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping()
	public String getAllUser(Model model){
		List<User> users = userService.findAll();
		Collections.reverse(users);
		model.addAttribute("users", users);
		return "user/home";
	}
	
	@RequestMapping(value = "/view/{id}",method = RequestMethod.GET)
	@ResponseBody
	public Optional<User> viewUser(@PathVariable int id) {
		Optional<User> newuser = userService.getById(id);
		return newuser;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	@ResponseBody
	public int editUser(@ModelAttribute User user,@PathVariable int id) {
		Optional<User> prevdetails = userService.getById(id);
		userService.updateUser(prevdetails,user);
		return id;	
	}
		
	@ResponseBody
	@GetMapping("/delete/{id}")
	public String deleteuser(@PathVariable int id) {
		userService.deleteById(id);
		return "OK";
	}
	
	@PostMapping("/save")
	@ResponseBody
	public int adduser(@ModelAttribute("User") User newuser,HttpServletRequest request){
		userService.save(newuser);
		int latestId = userService.getLatestId();
		return latestId;
		// return new ResponseEntity<>(HttpStatus.OK);	
	}
	

}
