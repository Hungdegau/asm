package vn.funix.FX00000.java.ASM01;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ASM01 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean cont = true;
        do {
            System.out.println("+-------+--------------------------+----------+");
            System.out.println("|Ngan hang so | FX20486@v1.0.0                |");
            System.out.println("+-------+--------------------------+----------+");
            System.out.println("| 1. Nhap CCCD                                |");
            System.out.println("| 0. Thoat                                    |");
            System.out.println("+-------+--------------------------+----------+");
            System.out.println("Chuc nang: ");

            int chucNang = scanner.nextInt();

            switch (chucNang){
                case 1:
                    boolean check = false;

                    String cccd = displayCCCD();
                    if (cccd.length() == 12 && isNumeric(cccd)){
                        check = true;
                    }
                    if (check){
                            boolean conts = true;
                            do{
                                System.out.println("| 1. Kiểm tra nơi sinh");
                                System.out.println("| 2. Kiểm tra năm sinh , giới tính");
                                System.out.println("| 3. Kiểm tra số ngẫu nhiên");
                                System.out.println("| 0. thoát");
                                System.out.println("Chọn chức năng: ");

                                int chucNang2 = scanner.nextInt();

                                switch (chucNang2){

                                    case 1:
                                        String[][] maTinh = dataMaTinh();
                                        String thanhPho = "";
                                        for(int i = 0;i < maTinh.length; i++){
                                            if(maTinh[i][0].equals(cccd.substring(0, 3))){
                                                thanhPho = maTinh[i][1];
                                                break;
                                            }
                                        }
                                        System.out.println("Nơi sinh: " + thanhPho);
                                        break;

                                    case 2:
                                        String genderAndAge = displayGenderAndAge(cccd);
                                        System.out.println(genderAndAge);
                                        break;
                                    case 3:
                                        System.out.println("Số ngẫu nhiên: "+cccd.substring(6));
                                        break;
                                }}
                            while (conts);

                        cont = false;
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

    public static String displayCCCD(){
        Random random = new Random();
        int min = 100;
        int max = 999;
        int value = random.nextInt((max - min) + 1) + min;

        System.out.println("Nhap ma xac thuc: "+ value);
        int maXacThuc = scanner.nextInt();
//                System.out.println(maXacThuc);

        while (maXacThuc != value){
            System.out.println("Ma xac thuc khong dung. Vui long thu lai..");
            maXacThuc = scanner.nextInt();
            if (maXacThuc == value) break;
        }
        scanner.nextLine();
        System.out.println("Vui long nhap vao so CCCD :");
        String cccd = scanner.nextLine();

        while(cccd.length() != 12 || !isNumeric(cccd)){
            System.out.println("So CCCD khong hop le.\n Vui long nhap lai hoac ‘No’ de thoat:");
            cccd = scanner.nextLine();
            if ("No".equals(cccd)) break;
        }
        return cccd;
    }

    public static String[][] dataMaTinh(){

        String[][] maTinh =  {
                {"001", "Hà Nội"},{"002", "Hà Giang"},{"004", "Cao Bằng"},
                {"006", "Bắc Kạn"},{"008", "Tuyên Quang"},{"010", "Lào Cai"},{"011", "Điện Biên"},
                {"012", "Lai Châu"},{"014", "Sơn La"},{"015", "Yên Bái"},{"017", "Hoà Bình"},
                {"019", "Thái Nguyên"},{"020", "Lạng Sơn"},{"022", "Quảng Ninh"},
                {"024", "Bắc Giang"},{"025", "Phú Thọ"},{"026", "Vĩnh Phúc"},
                {"027", "Bắc Ninh"},{"030", "Hải Dương"},{"031", "Hải Phòng"},
                {"033", "Hưng Yên"},{"034", "Thái Bình"},{"035", "Hà Nam"},
                {"036", "Nam Định"},{"037", "Ninh Bình"},{"038", "Thanh Hoá"},
                {"040", "Nghệ An"},{"042", "Hà Tĩnh"},{"044", "Quảng Bình"},
                {"045", "Quảng Trị"},{"046", "Thừa Thiên Huế"},{"048", "Đà Nẵng"},
                {"049", "Quảng Nam"},{"051", "Quảng Ngãi"},{"052", "Bình Định"},
                {"054", "Phú Yên"},{"056", "Khánh Hoà"},{"058", "Ninh Thuận"},
                {"060", "Bình Thuận"},{"062", "Kon Tum"},{"064", "Gia Lai"},
                {"066", "Đắk Lắk"},{"067", "Đắk Nông"},{"068", "Lâm Đồng"},
                {"070", "Bình Phước"},{"072", "Tây Ninh"},{"074", "Bình Dương"},
                {"075", "Đồng Nai"},{"077", "Bà Rịa - Vũng Tàu"},{"079", "Hồ Chí Minh"},
                {"080", "Long An"},{"082", "Tiền Giang"},{"083", "Bến Tre"},
                {"084", "Trà Vinh"},{"086", "Vĩnh Long"},{"087", "Đồng Tháp"},
                {"089", "An Giang"},{"091", "Kiên Giang"},{"092", "Cần Thơ"},
                {"093", "Hậu Giang"},{"094", "Sóc Trăng"},{"095", "Bạc Liêu"},{"096", "Cà Mau"}
        };
        return maTinh;
    }

    public static String displayGenderAndAge(String cccd){
        String genderAndAge = "";
        String gender = "";
        char keyGender = cccd.charAt(3); // Lấy ký tự thứ 4 của CCCD là giới tính
        int genderCode = Character.getNumericValue(keyGender);
        if(genderCode % 2 == 0){
            gender = "Nam";
        } else {
            gender = "Nữ";
        };
        int century = 0; // Mã thế kỷ
        String birthYear = cccd.substring(4, 6);  // Lấy năm sinh từ CCCD
        if(genderCode == 0 || genderCode == 1){
            century = 20;
        }else if(genderCode == 2 || genderCode == 3){
            century = 21;
        } else if(genderCode == 4 || genderCode == 5){
            century = 23;
        } else if(genderCode == 6 || genderCode == 7){
            century = 24;
        } else if(genderCode == 8 || genderCode == 9){
            century = 25;
        }
        String age = "";
        switch (century) {
            case 20:
                age = "19" + birthYear ;
                break;
            case 21:
                age = "20" + birthYear;
                break;
            case 22:
                age = "21" + birthYear;
                break;
            case 23:
                age = "22" + birthYear;
                break;
            case 24:
                age = "23" + birthYear;
                break;
            default:
                century = 0;
        }

        genderAndAge = "Giới Tính: "+ gender +" | Năm Sinh: "+ age;

        return genderAndAge;
    }


    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

}
