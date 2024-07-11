package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /*
        1. 생산하려는 커피의 종류를 선택할 수 있게 해주세요
        2. 커피의 종류에 따라 상세 종류를 선택할 수 있게 해주세요.
        3. 필요한 경우 더 상세한 내용을 선택할 수 있게 해주세요. 필요없을 경우 생략 가능합니다.
        4. 각각 선택할 메뉴 표시에 가격이 정해져 있다면 가격도 같이 표시해 주세요
        5. 선택한 내용을 확인할 수 있게 출력해 주세요.
        6. 언제나 처음 단계로 돌아갈 수 있는 기능이 필요합니다.
        7. 언제나 종료할 수 있는 기능이 필요합니다.
     */
    static Scanner scan = new Scanner(System.in);
    static String menu_name = ""; //메뉴명
    static String takeout_option = ""; //포장유무
    static String hot_or_iced = ""; //뜨거운 or 차가운
    static String ice_cube = "";//각얼음 or 간얼음
    static String shot_plus = "";//샷추가 유무
    static int count = 0; //갯수
    static int price = 0; //메뉴 가격
    static int total_price = 0; //총 가격
    static String order = "";
    static ArrayList<String> orders = new ArrayList<>(); //메뉴,옵션,가격 등을 담을 배열리스트

    static boolean run = true;

        public static void main(String[] args) {

            while (run) {
                System.out.println("\t\t\t\t\t\t ┌────────────────────┐\t");
                System.out.println("\t\t\t\t\t\t │      휴먼 커피    \t  │");
                System.out.println("\t\t\t\t\t\t └────────────────────┘\t");
                TakeOut();
            }
    
        }
    
        static void TakeOut() {
            System.out.println("\t\t\t---------------------------------------------------");
            System.out.println("\t\t\t1. 매장에서 먹어요 │  2. 포장해서 갈래요 │  3. 시스템 종료");
            System.out.println("\t\t\t---------------------------------------------------");
            int i = scan.nextInt();
            if (i == 1) {
                takeout_option = "X"; //매장
            } else if (i == 2) {
                takeout_option = "O"; //포장
            }else if(i == 3) {
                run = false;
                System.out.println("시스템을 종료합니다.");
                System.exit(0);
            }
            Menu();
        }
    
        static void Menu() {
            System.out.println("\t┌────────────────────────────── M E N U ────────────────────────────────┐\t");
            System.out.println("\t│\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t│");
            System.out.println("\t│    1.아메리카노(₩1,500)\t2.원조커피(₩1,500)\t3.카페모카(₩2,000)     \t│");
            System.out.println("\t│\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t│");
            System.out.println("\t│    4.카페라떼(₩2,000)\t\t5.연유라떼(₩2,500)\t6.바닐라라떼(₩2,500)    \t│");
            System.out.println("\t│\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t│");
            System.out.println("\t│        \t\t\t0.처음으로\t\t\t9.시스템 종료  \t\t\t\t\t│");
            System.out.println("\t│\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t│");
            System.out.println("\t└───────────────────────────────────────────────────────────────────────┘\t");
            int menu = scan.nextInt();
            switch (menu) {
                case 1:
                    menu_name = "아메리카노";
                    price = 1500;
                    break;
                case 2:
                    menu_name = "원조커피";
                    price = 1500;
                    break;
                case 3:
                    menu_name = "카페모카";
                    price = 2000;
                    break;
                case 4:
                    menu_name = "카페라떼";
                    price = 2000;
                    break;
                case 5:
                    menu_name = "연유라떼";
                    price = 2500;
                    break;
                case 6:
                    menu_name = "바닐라라떼";
                    price = 2500;
                    break;
                case 9:
                    run = false;
                    System.out.println("\t시스템을 종료합니다.");
                    System.exit(0);
                default:
                    TakeOut();
                    break;
            }
            Option();
        }

    static void Option() {
        int i;
        System.out.println("\t1.HOT\t2.ICED\t3.처음으로\t4.시스템종료");
        i = scan.nextInt();
        if (i == 1) {
            hot_or_iced = "HOT";
        } else if (i == 2) {
            hot_or_iced = "ICED";
        } else if (i == 3) {
            TakeOut();
        }else if(i == 4) {
            System.exit(0);
        }

        if (hot_or_iced.equals("ICED")) {
            System.out.println("\t1.각얼음\t2.간얼음\t3.처음으로\t4.시스템종료");
            i = scan.nextInt();
            if (i == 1) {
                ice_cube = "각얼음";
            } else if (i == 2) {
                ice_cube = "간얼음";
            }else if (i == 3) {
                TakeOut();
            }else if(i == 4) {
                System.exit(0);
            }
        }

        System.out.println("\t\t샷추가(₩500) \n\t1.추가\t2.추가안함\t3.처음으로\t4.시스템종료");
        i = scan.nextInt();
        if (i == 1) {
            shot_plus = "샷추가";
            price += 500;
        } else if (i == 2) {
            shot_plus = "샷추가안함";
        }else if (i == 3) {
            TakeOut();
        }else if(i == 4) {
            System.exit(0);
        }
        System.out.println("\t수량을 입력해주세요");
        count = scan.nextInt();
        price *= count;

        total_price += price; //총 가격 계산

        if (hot_or_iced.equals("HOT")) {
            order = menu_name + "\t" + hot_or_iced + "\t" + shot_plus + "\t" + "₩" + price;
        } else {
            order = menu_name + "\t" + hot_or_iced + "\t" + ice_cube + "\t" + shot_plus + "\t" + "₩" + price;
        }
        orders.add(order);

        System.out.println("\t더 주문하시겠습니까?\t1.예\t2.아니오");
        i = scan.nextInt();
        if (i == 1) {
            Menu();
        } else {
            Cart();
        }
    }

    static void Cart() {
        int cnt =1;
        System.out.println("\t\t================= 영 수 증 ==================");
        for (String order : orders) {
            System.out.println("\t\t"+cnt+".\t"+order);
            cnt++;
        }

        System.out.println("\n\t\t\t\t\t\t총가격 : ₩"+total_price);
        System.out.println("\t\t============================================");
        run = false;
    }

}
