package onion.poc.domain.model;

public interface AccountTransferService {
    boolean transfer(double amount, BankAccount from, BankAccount to);
}
