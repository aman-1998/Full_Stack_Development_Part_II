package personal.learning.service;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import personal.learning.dao.UserRepository;
import personal.learning.model.Country;
import personal.learning.model.School;
import personal.learning.web.dto.UserRegistrationDTO;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public void save(UserRegistrationDTO userRegistrationDTO) {
		
	}

	@Override
	public LinkedHashMap<String, String> getCountryMap() {
		LinkedHashMap<String, String> countryCodeMap = new LinkedHashMap<>();
		List<Country> countryList = userRepository.getCountryMap();
		for(Country country : countryList) {
			countryCodeMap.put(country.getId(), country.getCountryName());
		}
		return countryCodeMap;
	}

	@Override
	public LinkedHashMap<String, String> getLangMap() {
		LinkedHashMap<String, String> langMap = userRepository.getLangMap();
		return langMap;
	}
	
	@Override
	public String getSchoolName() {
		String name = StringUtils.EMPTY;
		try {
			name = userRepository.getSchoolName();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
}
