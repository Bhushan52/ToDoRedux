package com.yash.todo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.yash.todo.model.Role;
import com.yash.todo.model.User;
import com.yash.todo.model.UserDetailsImpl;
import com.yash.todo.repos.RoleRepository;
import com.yash.todo.repos.UsersRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService,UserServiceCustom {

    @Autowired
    private UsersRepository usersRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
	private PasswordEncoder bCryptPasswordEncoder;
    
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> optionalUser = usersRepository.findByUserName(userName);
        return Optional.ofNullable(optionalUser).orElseThrow(()->new UsernameNotFoundException("Username Not Found"))
               .map(UserDetailsImpl::new).get();
    }
	@Override
	public void saveUser(User user) {
		
		List<Role> roles=roleRepository.findAll();
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roles.stream().collect(Collectors.toSet()));
		usersRepository.save(user);
	}
}
