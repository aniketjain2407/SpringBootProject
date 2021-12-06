package RawMaterial.Service;

import java.util.List;
import java.util.Optional;

import RawMaterial.Model.User;

public interface UserService {
	List<User> findAll();
	Optional<User> getById(Integer id);
	void save(User newuser);
	List<User> findAllByIds(List<Integer> ids);
	void deleteById(Integer id);
	void updateUser(Optional<User> prevdetails, User user);
	int getLatestId();
}
