package del.ac.id.service;

import java.util.List;

import com.example.demo.jpa.User;



public interface UserServie {
	List<User> getAllPenerbangan();
	void saveUser(User user);
	void deleteuserId(String id);
	User getUserById(String id);

}
