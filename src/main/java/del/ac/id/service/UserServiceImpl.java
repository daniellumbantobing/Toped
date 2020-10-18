package del.ac.id.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.jpa.User;
import com.example.demo.jpa.UserRepository;





@Service
public class UserServiceImpl implements UserServie {
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllPenerbangan() {
		
		return this.userRepository.findAll();
	}

	@Override
	public void saveUser(User user) {
		this.userRepository.save(user);
		
	}

	@Override
	public void deleteuserId(String id) {
		this.userRepository.deleteById(id);
		
	}

	@Override
	public User getUserById(String id) {
		Optional<User> optional = userRepository.findById(id);
		User penerbangan = null;
		if(optional.isPresent()) {
			penerbangan = optional.get();
		}else {
			throw new RuntimeException("Employee tidak ditemukan");
		}
		return penerbangan;
	}

	
	

}
