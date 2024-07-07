package vn.funix.FX00000.java.ASM02;

import java.text.DecimalFormat;

public class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){

        this.balance = balance;
    }
    public String getAccountNumber(){

        return accountNumber;
    }
    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }
    public boolean isPremiumAccount() {
        if (this.balance >= 10000000) {
            return true; // Tài khoản là Premium nếu số dư lớn hơn hoặc bằng 10,000,000 VNĐ
        } else {
            return false; // Tài khoản không phải là Premium nếu số dư nhỏ hơn 10,000,000 VNĐ
        }
    }


    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return "Account Number| " + accountNumber + ",Balance: "+ formatter.format(balance) + "VNĐ";
    }
}
