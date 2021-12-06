package RawMaterial.Controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import RawMaterial.Model.Farmerfranchise;
import RawMaterial.Service.RawMaterialService;
import net.minidev.json.JSONArray;

@Controller
@RequestMapping("/")
public class RawMaterialController {
	@Autowired
	RawMaterialService service;
	
	@GetMapping(value = "/")
	public String getff(Model model){
		//List<Farmerfranchise> listff = service.findAll();
		//Collections.reverse(listff);
		//model.addAttribute("listff", listff);
		//System.out.println("reverse listff:"+listff);
		int ordercount = service.findAll().size();
		model.addAttribute("ordercount", ordercount);
		return "rawmaterial/home";
	}
	/*
	@GetMapping(value="/addff")
	public String addff(Model model) {
		model.addAttribute("ff", new Farmerfranchise());
		return "addff";
	}
	
	@PostMapping(value = "/save")
	public String addff(@ModelAttribute Farmerfranchise ff,RedirectAttributes redirect) {
		service.save(ff);
		redirect.addFlashAttribute("success message", "New FamerFranchise Created Successfully");
		return "redirect:/farmers/create";
	}
*/	

	
	@RequestMapping(value = "/view/{id}",method= RequestMethod.GET)
	public ResponseEntity<Farmerfranchise> view(@PathVariable int id){
		//System.out.println(service.get(id));
		Farmerfranchise ff = service.getById(id);
		System.out.println(ff);
		//model.addAttribute("ff","ff");
		return ResponseEntity.of(Optional.of(ff));
	}

	@RequestMapping(value="/list",method = RequestMethod.GET)
	public  ResponseEntity<List<Farmerfranchise>> getff(){
		List<Farmerfranchise> listff = service.findAll();
		//System.out.println("listff:" + listff);
		//System.out.println(jsonstr);
		return ResponseEntity.of(Optional.of(listff));
	}
	@RequestMapping(value="/edit/{id}",method = RequestMethod.POST)
	public ResponseEntity<?> edit(@ModelAttribute Farmerfranchise ff,@PathVariable int id){
		Farmerfranchise editff  = service.getById(id);
		System.out.println(ff);
		editff.setDistrict(ff.getDistrict());
		editff.setState(ff.getState());
		editff.setFranchise(ff.getFranchise());
		editff.setQuantity(ff.getQuantity());
		editff.setProduct(ff.getProduct());
		service.save(editff);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping(value = "/save")
	@ResponseBody
	public ResponseEntity<Farmerfranchise> addff(@ModelAttribute Farmerfranchise ff,RedirectAttributes redirect) {
		service.save(ff);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public ResponseEntity<String> delete(@PathVariable Integer id){
		service.deletefarmerfranchise(id);
		//System.out.println("Id:" + id);
		//Farmerfranchise ff = service.getById(id);
		//System.out.println(ff);
		return ResponseEntity.of(Optional.of("You have deleted iid correponds to"+id));
	}
		

}
