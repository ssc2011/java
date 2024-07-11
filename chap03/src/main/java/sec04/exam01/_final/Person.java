package sec04.exam01._final;

import java.util.Scanner;

public class Person {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num=sc.nextInt();
        int a = 65;
        for(int i=0;i<num;i++){
            for(int j=0;j<=i;j++){
                System.out.printf("%c",a); //A 1번, B 2번, C 3번 출력하는 반복문
            }
            a++;
            for(int j=a;j<a+num-i-1;j++){ //j=66 j<66+6-0
                System.out.printf("%c",j);
            }
            System.out.println();
        }
//        for(int i=0;i<num;i++){
//            System.out.print("*");
//        }
//        System.out.println();
//        for(int i=0;i<num-2;i++){
//            System.out.print("*");
//            for(int j=0;j<num-2;j++){
//                System.out.print(" ");
//            }
//            System.out.println("*");
//        }
//        for(int i=0;i<num;i++){
//            System.out.print("*");
//        }
    }
}
