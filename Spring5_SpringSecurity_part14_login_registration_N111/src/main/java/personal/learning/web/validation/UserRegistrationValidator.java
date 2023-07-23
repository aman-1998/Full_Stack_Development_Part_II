package personal.learning.web.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.BindingResult;

import personal.learning.service.UserService;
import personal.learning.service.UserServiceImpl;

public class UserRegistrationValidator {
	
	private BindingResult validate(String country, 
			   String[] languages, 
			   String email, BindingResult result, 
			   String operation, String originalEmail, UserService userService) {

		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		//AppDAOImpl dao = context.getBean("DAOBean", AppDAOImpl.class);
		
		if(operation != null) {
			if(!operation.isEmpty() && !operation.equals("updateCustomer")) {
				result.rejectValue("email", "error.email.invalid.operation.update");
			}
		}
		
		//Country Validation
//		if(country != null) {
//			if(!country.isEmpty()) {
//				int maxPk = userService.getCountryListfromDB().size();
//				if(Integer.valueOf(country) > maxPk) {
//					result.rejectValue("country", "error.country.invalid");
//				}
//			}
//		}
		
		//Language Validation
		if(languages.length != 0) {
			for(String lang : languages) {
				if(!lang.equals("Hindi") && !lang.equals("English") 
					&& !lang.equals("Sanskrit") && !lang.equals("Maithili")) {
					result.rejectValue("language", "error.language.invalid");
				}
			}
		}
		
		//Email validation
//		switch(operation) {
//			case "updateCustomer":
//				if(email != null) {
//					if(email.isEmpty()) {
//						result.rejectValue("email", "error.email.empty");
//					} else {
//						if(!email.equals(originalEmail)) {
//							result.rejectValue("email", "error.email.update.notAllowed");
//						}
//					}
//				} else {
//					result.rejectValue("email", "error.email.empty");
//				}
//				break;
//			default:
//				if(email != null) {
//					if(email.isEmpty()) {
//						result.rejectValue("email", "error.email.empty");
//					} else {
//						String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
//						Pattern pattern = Pattern.compile(regex);
//						Matcher matcher = pattern.matcher(email);
//						boolean isValidEmail = matcher.matches();
//						if(!isValidEmail) {
//							result.rejectValue("email", "error.email.invalid");
//						} else {
//							boolean isNewCustomer = userService.isNewCustomer(email);
//							if(!isNewCustomer) {
//								result.rejectValue("email", "error.email.duplicate");
//							}
//						}
//					}
//				} else {
//					result.rejectValue("email", "error.email.empty");
//				}
//				break;
//			}
		return result;
	}
}
