package com.alibou.ecommerce.order;

import com.alibou.ecommerce.customer.CustomerClient;
import com.alibou.ecommerce.exception.BusinessException;
import com.alibou.ecommerce.product.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerClient customerClient;

    private final ProductClient productClient;
    public Integer createdOrder(OrderRequest request){

        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No Customer exist"));
        //check the customer --> OpenFeign

        // purchase the products

        // persist order

        // persist order lines

        // start payment process

        // send the order confirmation --> notification service
        return null;
    }
}
