package projet.factory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import projet.factory.entity.User;
import projet.factory.repository.UserRepository;

@Service
public class ConsoleApplicationService implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
	/*
		for (User user : userRepository.findAll()) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(user);
		}
	*/
	}
}