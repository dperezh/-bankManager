package org.softdevelop.demo.banking.service.impl;

import org.softdevelop.demo.banking.model.PaymentOrder;
import org.softdevelop.demo.banking.repository.PaymentOrderRepository;
import org.softdevelop.demo.banking.service.IPaymentOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentOrderService implements IPaymentOrder {
    private PaymentOrderRepository paymentOrderRepo;
    @Autowired
    public PaymentOrderService(PaymentOrderRepository paymentOrderRepo) {
        this.paymentOrderRepo = paymentOrderRepo;
    }
    @Override
    public List<PaymentOrder> getAllPaymentOrders() {
        return paymentOrderRepo.findAll();
    }

    @Override
    public Optional<PaymentOrder> findById(int id) {
        return paymentOrderRepo.findById(id);
    }

    @Override
    public PaymentOrder save(PaymentOrder std) {
        return paymentOrderRepo.save(std);
    }

    @Override
    public void deleteById(int id) {
        paymentOrderRepo.deleteById(id);
    }
}
