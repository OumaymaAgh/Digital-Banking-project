package org.sid.ebankingbackend.service;

import org.sid.ebankingbackend.dtos.*;
import org.sid.ebankingbackend.entities.BankAccount;
import org.sid.ebankingbackend.entities.CurrentAccount;
import org.sid.ebankingbackend.entities.Customer;
import org.sid.ebankingbackend.entities.SavingAccount;
import org.sid.ebankingbackend.exceptions.BalanceNotSufficentException;
import org.sid.ebankingbackend.exceptions.BankAccountNotFoundException;
import org.sid.ebankingbackend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {
    //Ajouter un client
    CustomerDTO saveCustomer(CustomerDTO customerDTO);

    //Ajouter un compte Current
    CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;

    //Ajouter un compte Saving
    SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;

    //Consulter une liste des clients
    List<CustomerDTO> listCustomer();

    //Consulter un compte
    BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;

    //Creer un debit
    void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficentException;

    //Creer un credit
    void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;

    //Effectuer un virement
    void transfer(String accountIdSource, String accountIdDestination, double amount) throws BankAccountNotFoundException, BalanceNotSufficentException;

    List<BankAccountDTO>bankAccountsList();

    CustomerDTO getCustomer(Long customerId) throws  CustomerNotFoundException;

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long customerId);

    List<AccountOperationDTO> accountHistory(String accountId);

    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;
}
