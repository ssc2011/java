package sec02.exam01.exam03;

public class Dog extends Animal {
    @Override
    void sound(){
        System.out.println("멍멍");
    }

    void walk(){
        System.out.println("강아지 산책");
    }
}
