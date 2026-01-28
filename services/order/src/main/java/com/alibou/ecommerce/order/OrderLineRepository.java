package com.alibou.ecommerce.order;

import com.alibou.ecommerce.orderline.OrderLine;
import com.alibou.ecommerce.orderline.OrderLineResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {
//    List<OrderLine> order(Order order);

    List<OrderLine> findAllByOrderId(Integer orderId);
}
