package RawMaterial.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import RawMaterial.Model.User;
import RawMaterial.Repo.UserRepository;

@Service
public class UserServiceImp implements UserService,UserDetailsService, AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {
	
	@Autowired
	private UserRepository repo;

	@Override
	public List<User> findAll() {
		return repo.findAll();
	}

	@Override
	public Optional<User> getById(Integer id) {
		return repo.findById(id);
	}

	@Override
	public void save(User newuser) {
		// System.out.println("userdetails in repo: " + newuser.getId() + newuser.getName() + newuser.getPassword() + newuser.getPhoneno() + newuser.getUserType());
		repo.save(newuser);
	}

	@Override
	public List<User> findAllByIds(List<Integer> ids) {
		return repo.findAllById(ids);
	}

	@Override
	public void deleteById(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public void updateUser(Optional<User> prevdetails, User newdetails) {
		User edituser = prevdetails.get();
		edituser.setName(newdetails.getName());
		edituser.setPassword(newdetails.getPassword());
		edituser.setPhoneno(newdetails.getPhoneno());
		edituser.setUserType(newdetails.getUserType());
		repo.save(edituser);
	}

	@Override
	public int getLatestId() {
		return repo.getLatestId();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByName(username);
		if (user==null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
		}
		else {
			return user;
		}
	}

	@Override
	public UserDetails loadUserDetails(PreAuthenticatedAuthenticationToken token) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
