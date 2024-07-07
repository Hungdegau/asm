package vn.funix.FX00000.java.ASM02;

import java.util.*;


public class Asm2 {
    static final Bank bank = new Bank();

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);



//        List<Account> lstAcc1 = new ArrayList<>();
//        List<Account> lstAcc2 = new ArrayList<>();
//        Account acc1 = new Account("123456", 60000);
//        Account acc2 = new Account("123457", 70000);
//        lstAcc1.add(acc1);
//        lstAcc2.add(acc2);
//
//        Customer cus1 = new Customer("dat", "036200003856", lstAcc1);
//        Customer cus2 = new Customer("hung", "036200003956", lstAcc2);
//
//        lstCustomer.add(cus1);
//        lstCustomer.add(cus2);

        boolean cont = true;
        do {
            System.out.println("+-------+--------------------------+----------+");
            System.out.println("|Ngan hang so | FX20486@v2.0.0                |");
            System.out.println("+-------+--------------------------+----------+");
            System.out.println("| 1. Them khach hang                          |");
            System.out.println("| 2. Them tai khoan cho khach hang            |");
            System.out.println("| 3. Hien thi danh sach khach hang            |");
            System.out.println("| 4. Tim theo CCCD                            |");
            System.out.println("| 5. Tim theo ten khach hang                  |");
            System.out.println("| 0. Thoat                                    |");
            System.out.println("+-------+--------------------------+----------+");
            System.out.print("Chuc nang: ");

            int chucNang = scanner.nextInt();
            scanner.nextLine();

            switch (chucNang){
                case 1:
                    System.out.print("Nhập tên khách hàng: ");
                    String name = scanner.nextLine();

                    System.out.print("Nhập số CCCD: ");
                    String customerId = scanner.nextLine();
                    while(customerId.length() != 12 || !isNumeric(customerId)){
                        System.out.println("So CCCD khong hop le.\n Vui long nhap lai hoac ‘No’ de thoat:");
                        customerId = scanner.nextLine();
                        if ("No".equals(customerId)) break;
                    }

                    List<Account> accounts = new ArrayList<>();

                    Customer customer = new Customer(name, customerId, accounts);
                    bank.getCustomers().add(customer);

                    System.out.println("Đã thêm khách hàng "+ customerId +"vào danh sách");
                    break;
                case 2:
                    String cccd2;

                    System.out.print("Nhập CCCD khach hang: ");
                    cccd2 = scanner.nextLine();

                    while(cccd2.length() != 12 || !isNumeric(cccd2)) {
                        System.out.print("So CCCD khong hop le.\n Vui long nhap lai hoac ‘No’ de thoat: ");
                        cccd2 = scanner.nextLine();
                        if ("No".equals(cccd2)) break;
                    }

                    if(bank.getCustomers().isEmpty()){
                        System.out.println("Dữ liệu trống");
                        break;
                    } else {
                        boolean checkCus = false;
                        for(int i = 0; i < bank.getCustomers().size(); i++){
                            if(cccd2.equals(bank.getCustomers().get(i).getCustomerId())){
                                break;
                            }else if(i + 1 == bank.getCustomers().size()){
                                checkCus = true;
                            }
                            while (checkCus){
                                System.out.print("CCCD không tồn tại , yêu cầu nhập lại: ");
                                cccd2 = scanner.nextLine();
                                checkCus = false;
                                i = -1;
                            }
                        }
                    }

                    while(true){

                        System.out.print("Nhập mã STK gồm 6 chữ số: ");
                        String accountNumber = scanner.nextLine();
                        if(accountNumber.length() != 6 || !isNumeric(accountNumber)){
                            System.out.print("Mã STK không hợp lệ. \n Vui lòng nhập lại");
                            continue;
                        }

                        for(int i = 0; i < bank.getCustomers().size(); i++){
                            if(cccd2.equals(bank.getCustomers().get(i).getCustomerId())){
                                if(!bank.getCustomers().get(i).getAccounts().isEmpty()){
                                    for(int j = 0; j < bank.getCustomers().get(i).getAccounts().size(); j++){
                                        while (accountNumber.contains(bank.getCustomers().get(i).getAccounts().get(j).getAccountNumber())){
                                            System.out.print("Tài khoản đã tồn tại, yêu cầu nhập lại: ");
                                            accountNumber = scanner.nextLine();
                                        }
                                        System.out.print("Nhập số dư: ");
                                        double balance = Integer.parseInt(scanner.nextLine());
                                        if (balance < 50000) {
                                            System.out.print("Số dư không được nhỏ hơn 50,000 VNĐ. Vui lòng nhập lại: ");
                                            continue;
                                        }

                                        Account account = new Account(accountNumber, balance);
                                        bank.getCustomers().get(i).addAccount(account);

                                        break;
                                    }
                                }else {
                                    System.out.print("Nhập số dư: ");
                                    double balance = Integer.parseInt(scanner.nextLine());
                                    if (balance < 50000) {
                                        System.out.print("Số dư không được nhỏ hơn 50,000 VNĐ. Vui lòng nhập lại: ");
                                        continue;
                                    }
                                    Account account = new Account(accountNumber, balance);
                                    bank.getCustomers().get(i).addAccount(account);
                                    break;
                                }
                            }
                        }
                        break;
                    }
                    break;
                case 3:
                    Customer cus = new Customer();
                    System.out.println(cus.displayInformation(bank.getCustomers()));
                    break;
                case 4:
                    System.out.print("Nhập Căn Cước Công Dân để tìm kiếm: ");
                    String cccd3 = scanner.nextLine();
                    Customer cus1 = Customer.searchCustomerId(cccd3);
                    if(cus1 != null){
                        System.out.println(cus1.displayInformation(bank.getCustomers()));
                    }else {
                        System.out.println("Không tìm thấy khách hàng với số CCCD đã nhập!");
                    }

                    break;
                case 5:
                    System.out.print("Nhập tên khách hàng: ");
                    String name1 = scanner.nextLine();
                    Customer cus2 = Customer.searchName(name1);
                    if(cus2 != null){
                        System.out.println(cus2.displayInformation(bank.getCustomers()));
                    }else {
                        System.out.println("Không tìm thấy khách hàng với số tên đã nhập!");
                    }
                    break;
                case 0:
                    System.out.println("Hen gap lai .....");
                    System.exit(chucNang);
                    break;
                default:
                    System.out.println("Yeu cau nhap lai");
                    break;
            }

        } while (cont);
    }
    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}
