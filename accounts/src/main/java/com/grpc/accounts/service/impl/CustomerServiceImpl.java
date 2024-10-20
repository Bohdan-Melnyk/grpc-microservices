package com.grpc.accounts.service.impl;

import com.bank.Bank;
import com.grpc.accounts.dto.AccountsDto;
import com.grpc.accounts.dto.CustomerDetailsDto;
import com.grpc.accounts.exception.ResourceNotFoundException;
import com.grpc.accounts.mapper.AccountsMapper;
import com.grpc.accounts.mapper.BankMapper;
import com.grpc.accounts.mapper.CustomerMapper;
import com.grpc.accounts.repository.AccountsRepository;
import com.grpc.accounts.repository.CustomerRepository;
import com.grpc.accounts.service.CustomerService;
import com.grpc.accounts.service.client.CardsFeignClient;
import com.grpc.accounts.service.client.LoansFeignClient;
import com.grpc.accounts.service.grpc.BankServiceProtoImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final AccountsRepository accountsRepository;

    private final CustomerRepository customerRepository;

    private final CardsFeignClient cardsFeignClient;

    private final LoansFeignClient loansFeignClient;

    private final BankServiceProtoImpl bankServiceProto;

    /**
     * @param mobileNumber - mobile number
     * @return Customer details
     */
    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
        var customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));
        var accounts = accountsRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString()));

        var customersDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customersDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        var loansDto = loansFeignClient.fetchLoanDetails(mobileNumber);
        customersDetailsDto.setLoansDto(loansDto.getBody());

        var carsDto = cardsFeignClient.fetchCardDetails(mobileNumber);
        customersDetailsDto.setCardsDto(carsDto.getBody());
        return customersDetailsDto;
    }

    @Override
    public CustomerDetailsDto fetchCustomerDetailsProto(String mobileNumber) {
        var customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));
        var accounts = accountsRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString()));

        var customersDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customersDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        Bank.LoanDto loansInfo = bankServiceProto.getLoansInfo(mobileNumber);
        customersDetailsDto.setLoansDto(BankMapper.mapToLoansDto(loansInfo));

//        Bank.CardsDto cardsInfo = bankServiceProto.getCardsInfo(mobileNumber);
//        customersDetailsDto.setCardsDto(BankMapper.mapToCardsDto(cardsInfo));

        return customersDetailsDto;
    }
}
