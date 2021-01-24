package org.softdevelop.demo.banking.service.impl;

import lombok.NoArgsConstructor;
import org.softdevelop.demo.banking.model.Bank;
import org.softdevelop.demo.banking.model.BranchOffice;
import org.softdevelop.demo.banking.model.PaymentOrder;
import org.softdevelop.demo.banking.repository.BankRepository;
import org.softdevelop.demo.banking.repository.BranchOfficeRepository;
import org.softdevelop.demo.banking.service.IBranchOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor
@Service
public class BranchOfficeService implements IBranchOffice {
    private BranchOfficeRepository branchOfficeRepo;
    private BankRepository bankRepo;
    @Autowired
    public BranchOfficeService(BranchOfficeRepository branchOfficeRepo, BankRepository bankRepo) {
        this.branchOfficeRepo = branchOfficeRepo;
        this.bankRepo = bankRepo;
    }
    @Override
    public List<BranchOffice> getAllBranchOffices() {
        return branchOfficeRepo.findAll();
    }

    @Override
    public Optional<BranchOffice> findById(int id) {
        return branchOfficeRepo.findById(id);
    }

    @Override
    public Optional<BranchOffice> findByName(String name) {
        return branchOfficeRepo.findByName(name);
    }

    @Override
    public BranchOffice save(BranchOffice std, int id) {
        Optional<Bank> bank = bankRepo.findById(id);
        bank.ifPresent(std::setBank);
        return branchOfficeRepo.save(std);
    }

    @Override
    public void deleteById(int id) {
        branchOfficeRepo.deleteById(id);
    }

    @Override
    public List<PaymentOrder> getPaymentOrdersByCurrency(String currency, int id) {
        Optional<BranchOffice> branchOffice = branchOfficeRepo.findById(id);
        List<PaymentOrder> paymentOrders = new ArrayList<>();
        if(branchOffice.isPresent()){
            paymentOrders = branchOffice.get()
                    .getPaymentOrders()
                    .stream()
                    .filter(paymentOrder -> paymentOrder.getCurrency().equals(currency)).collect(Collectors.toList());
        }
        return paymentOrders;
    }
}
