package bradesco_java_bootcamp.service;

import bradesco_java_bootcamp.model.User;

public interface UserService {
	User findById(Long id);
	
	User create(User userToCreate);

}
