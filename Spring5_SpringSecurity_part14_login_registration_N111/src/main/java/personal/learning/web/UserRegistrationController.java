package personal.learning.web;

import java.util.LinkedHashMap;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import personal.learning.service.UserService;
import personal.learning.web.dto.UserRegistrationDTO;

@Controller
@RequestMapping(value="/registration")
public class UserRegistrationController {
	
	private UserService userService;
	
	public UserRegistrationController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public ModelAndView loadRegistrationForm() {
		
		ModelAndView modelAndView = initRegistration();
		return modelAndView;
	}
	
	private ModelAndView initRegistration() {
		
		ModelAndView modelAndView = new ModelAndView("registrationPage");
		
		//Use School repository and service for this. Modification required. Just for test done as of now
		String schoolName = userService.getSchoolName();
		
		LinkedHashMap<String, String> genderMap = new LinkedHashMap<>();
		genderMap.put("Male", "Male");
		genderMap.put("Female", "Female");
		
		LinkedHashMap<String, String> countryMap = new LinkedHashMap<>();
		countryMap = userService.getCountryMap();
		
		LinkedHashMap<String, String> langMap = new LinkedHashMap<>();
		langMap = userService.getLangMap();
		
		UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO();
		
		modelAndView.addObject("user", userRegistrationDTO);
		modelAndView.addObject("genderMap", genderMap);
		modelAndView.addObject("countryMap", countryMap);
		modelAndView.addObject("langMap", langMap);
		
		return modelAndView;
	}
	
	@PostMapping
	public ModelAndView registrationHandler(@ModelAttribute("user") @Valid UserRegistrationDTO user,
											BindingResult result,
											SessionStatus status) {
												
		return null;
	}
	
}
