package vn.funix.FX00000.java.ASM02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Bank {
    private String id;
    private List<Customer> customers;



    public Bank(){
        this.id = String.valueOf(UUID.randomUUID());
        this.customers = new ArrayList<>();
    }

//    private String generateRandomId(){
//        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//        StringBuilder sb = new StringBuilder();
//        Random rand = new Random();
//        for(int i = 0; i < 6;i++){
//            sb.append(chars.charAt(rand.nextInt(chars.length())));
//        }
//        return sb.toString();
//    }
    public void addCustomer(Customer newCustomer){
        if(!isCustomerExisted(newCustomer.getCustomerId())){
            customers.add(newCustomer);
        }
    }
    public boolean isCustomerExisted(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return true;
            }
        }
        return false;
    }
    public List<Customer> getCustomers() {
        return customers;
    }

}
