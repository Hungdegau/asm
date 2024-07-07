package vn.funix.FX00000.java.ASM02;

public class User {
    private String name;
    private String customerId;

    public User(){
    }

    public User(String name,String customerId){
        this.name = name;
        this.customerId = customerId;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getCustomerId(){
        return customerId;
    }

    private boolean isValidCustomerId(String customerId){
        return customerId.matches("\\d{12}");
    }
    public void setCustomerId(String customerId){
        if(isValidCustomerId(customerId)){
            this.customerId = customerId;
        }else{
            System.out.println("Invalid customerId. Please enter a valid 12-digit number");
        }
    }



}
