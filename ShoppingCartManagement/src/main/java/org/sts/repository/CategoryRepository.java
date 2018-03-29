package org.sts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sts.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	Category getByName(String name);

}
