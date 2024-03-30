package org.jsp.jobportal.repository;

import org.jsp.jobportal.dto.PortalUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortalUserRepository extends JpaRepository<PortalUser,Integer> {

	boolean existsByEmail(String email);

}
