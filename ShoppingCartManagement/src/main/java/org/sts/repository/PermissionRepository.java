package org.sts.repository;

import org.springframework.data.jpa.mapping.JpaPersistentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.sts.entities.Permission;


public interface PermissionRepository extends JpaRepository<Permission, Integer> {

}
