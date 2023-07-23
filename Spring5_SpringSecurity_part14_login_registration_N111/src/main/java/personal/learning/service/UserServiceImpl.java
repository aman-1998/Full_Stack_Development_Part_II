package personal.learning.service;

import org.springframework.stereotype.Service;

import personal.learning.dao.UserRepository;
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
}
