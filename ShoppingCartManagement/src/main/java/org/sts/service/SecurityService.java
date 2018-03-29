package org.sts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sts.entities.User;
import org.sts.repository.UserRepository;

@Service
@Transactional
public class SecurityService {
	
	 @Autowired UserRepository userRepository;
	   
	  public User findUserByEmail(String email)
	  {
	       return userRepository.findByEmail(email);
	  }

}
