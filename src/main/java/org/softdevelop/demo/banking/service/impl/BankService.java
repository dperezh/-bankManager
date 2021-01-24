package org.softdevelop.demo.banking.service.impl;

import lombok.NoArgsConstructor;
import org.softdevelop.demo.banking.model.Bank;
import org.softdevelop.demo.banking.model.BranchOffice;
import org.softdevelop.demo.banking.repository.BankRepository;
import org.softdevelop.demo.banking.service.IBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@Service
public class BankService implements IBank {
    private BankRepository bankrepo;
    @Autowired
    public BankService(BankRepository bankrepo) {
        this.bankrepo = bankrepo;
    }
    @Override
    public List<Bank> getAllBanks() {
        // TODO Auto-generated method stub
        return bankrepo.findAll();
    }
    @Override
    public Optional<Bank> findById(int id) {
        // TODO Auto-generated method stub
        return bankrepo.findById(id);
    }

    @Override
    public Optional<Bank> findByName(String name) {
        return bankrepo.findByName(name);
    }

    @Override
    public Bank save(Bank std) {
        // TODO Auto-generated method stub
        return bankrepo.save(std);
    }
    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        bankrepo.deleteById(id);
    }

    @Override
    public List<BranchOffice> getBranchOfficesByBankId(int id) {
        Optional<Bank> bank = bankrepo.findById(id);
        List<BranchOffice> branchOffices = new ArrayList<>();
        if(bank.isPresent()){
            branchOffices = bank.get().getBranchOffices();
        }
        return branchOffices;
    }
}
