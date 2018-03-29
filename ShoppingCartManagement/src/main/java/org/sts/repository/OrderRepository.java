package org.sts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sts.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	Order findByOrderNumber(String orderNumber);
}
