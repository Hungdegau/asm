package vn.funix.FX00000.java.ASM02;

import java.util.ArrayList;
import java.util.List;

import static vn.funix.FX00000.java.ASM02.Asm2.bank;

public class Customer extends User {
    private List<Account> accounts = new ArrayList<>();

    public Customer(){
    }
    public Customer(String name, String customerId, List<Account> accounts) {
        super(name, customerId);
        this.accounts = accounts;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public boolean isPremiumAccount() {
        for (Account account : accounts) {
            if (account.isPremiumAccount()) {
                return true; // Nếu có ít nhất một tài khoản là Premium, khách hàng là Premium
            }
        }
        return false; // Nếu không có tài khoản nào là Premium, khách hàng không phải là Premium
    }

    public void addAccount(Account newAccount) {
        accounts.add(newAccount);
    }

    public double getBalance(List<Account> account) {
        double totalBalance = 0;
        for (Account acc : account) {
            totalBalance += acc.getBalance();
        }
        return totalBalance;
    }

    public static  Customer searchCustomerId(String cccd3){
        for(Customer kh : bank.getCustomers()){
            if(kh.getCustomerId().equals(cccd3)){
                return kh;
            }
        }
        return null;
    }

    public static Customer searchName(String name1){
        for(Customer kh1 : bank.getCustomers()){
            if(kh1.getName().equals(name1)){
                return kh1;
            }
        }
        return null;
    }

    public  StringBuilder displayInformation(List<Customer> lstCustomer) {
        int dem = 1;
        StringBuilder sb = new StringBuilder();
        for (Customer customer : lstCustomer) {
            sb.append(customer.getCustomerId()).append(" | ").append(customer.getName()).append(" | ").append(customer.isPremiumAccount() ? "Premium" : "Normal").append(" | ").append(this.getBalance(customer.getAccounts())).append("\n");
            for (Account acc : customer.getAccounts()){
                sb.append(dem).append("       ").append(acc.getAccountNumber()).append("  |  ").append(acc.getBalance()).append("\n");
                dem++;
            }
            dem = 1;
        }
        return sb;
    }
}



