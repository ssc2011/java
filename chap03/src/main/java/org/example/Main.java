package org.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int a = 1;
        int b = 0;

        //1 1 2 3 5 8 13 21 34
        for(int i = 1; i <= 10; i++){

            if(i%2==1){
                a=a+b;
                System.out.println(a); //a=1
            }else{
                b=a+b; // b= 1
                System.out.println(b);
            }

        }
 //1
    }
}