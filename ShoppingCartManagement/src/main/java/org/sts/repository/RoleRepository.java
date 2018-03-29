package org.sts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sts.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {


	Role findByName(String name);
	
}
