package personal.learning.service;

import java.util.LinkedHashMap;

import personal.learning.web.dto.UserRegistrationDTO;

public interface UserService {
	
	void save(UserRegistrationDTO userRegistrationDTO);

	LinkedHashMap<String, String> getCountryMap();

	LinkedHashMap<String, String> getLangMap();

	String getSchoolName();
}
