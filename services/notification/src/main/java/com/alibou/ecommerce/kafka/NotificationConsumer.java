package com.alibou.ecommerce.kafka;

import com.alibou.ecommerce.kafka.order.OrderConfirmation;
import com.alibou.ecommerce.kafka.payment.NotificationRepository;
import com.alibou.ecommerce.kafka.payment.PaymentConfirmation;
import com.alibou.ecommerce.notification.Notification;
import com.alibou.ecommerce.notification.NotificationType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.alibou.ecommerce.notification.NotificationType.ORDER_CONFIRMATION;
import static com.alibou.ecommerce.notification.NotificationType.PAYMENT_CONFIRMATION;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {
    private final NotificationRepository repository;
//    private  final EmailService emailService;

    @KafkaListener(topics = "payment-topic")
    public void consumePaymentNotification(PaymentConfirmation paymentConfirmation) {
        log.info(String.format("Consuming the message from payment-topic", paymentConfirmation));
        repository.save(
                Notification.builder()
                        .type(PAYMENT_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .paymentConfirmation(paymentConfirmation)
                        .build()
        );
        //todo email
    }

    @KafkaListener(topics = "order-topic")
    public void consumePaymentNotification(OrderConfirmation orderConfirmation) {
        log.info(String.format("Consuming the message from payment-topic", orderConfirmation));
        repository.save(
                Notification.builder()
                        .type(ORDER_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .orderConfirmation(orderConfirmation)
                        .build()
        );
    }
}
