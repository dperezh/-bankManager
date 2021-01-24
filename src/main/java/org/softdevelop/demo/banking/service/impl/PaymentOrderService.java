package org.softdevelop.demo.banking.service.impl;

import org.softdevelop.demo.banking.model.BranchOffice;
import org.softdevelop.demo.banking.model.PaymentOrder;
import org.softdevelop.demo.banking.repository.BranchOfficeRepository;
import org.softdevelop.demo.banking.repository.PaymentOrderRepository;
import org.softdevelop.demo.banking.service.IPaymentOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentOrderService implements IPaymentOrder {

    private PaymentOrderRepository paymentOrderRepo;
    private BranchOfficeRepository branchOfficeRepository;

    @Autowired
    public PaymentOrderService(PaymentOrderRepository paymentOrderRepo, BranchOfficeRepository branchOfficeRepository) {
        this.paymentOrderRepo = paymentOrderRepo;
        this.branchOfficeRepository = branchOfficeRepository;
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

    @Override
    public PaymentOrder associateOrderToBranch(int orderId, int branchId) {
        Optional<BranchOffice> branchOffice = branchOfficeRepository.findById(branchId);
        Optional<PaymentOrder> paymentOrder = paymentOrderRepo.findById(orderId);
        if(branchOffice.isPresent() && paymentOrder.isPresent()) {
            paymentOrder.get().setBranchOffice(branchOffice.get());
            return paymentOrderRepo.save(paymentOrder.get());
        }
        return null;
    }
}
