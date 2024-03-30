package org.jsp.jobportal.dao;

import org.jsp.jobportal.repository.PortalUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PortalUserDao {
  @Autowired
  PortalUserRepository userRepository;
	public boolean existsByEmail(String email) {
		
		return userRepository.existsByEmail(email);
	}
  
}
