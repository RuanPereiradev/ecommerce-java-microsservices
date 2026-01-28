package com.alibou.ecommerce.orderline;

import com.alibou.ecommerce.order.Order;
import com.alibou.ecommerce.order.PaymentMethod;
import com.alibou.ecommerce.product.PurchaseRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class OrderLine {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private Integer productId;
    private double quantity;

    public record OrderRequest(
            Integer id,
            String reference,
            @Positive(message = "Order amount should be positive ")
            BigDecimal amount,
            @NotNull(message = "Payment method is required")
            PaymentMethod paymentMethod,
            @NotNull(message = "Customer ID is required")
            @NotEmpty(message = "Customer ID cannot be empty")
            @NotBlank(message = "Customer ID cannot be blank")
            String customerId,

            @NotEmpty(message = "You should at least purchase one product")
            List<PurchaseRequest> products
    ) {
    }


}
