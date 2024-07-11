package sec04.exam01;

public class Car {
    String brand;
    String color;
    Car(){

    }


    void drive(){
        System.out.println("운전을 시작합니다");
    }

    int accel(int press){
        System.out.println(press+"만큼 가속");
        return press*2;
    }

    int breaking(int press){
        System.out.println(press+"만큼 정지");
        return press*2;
    }
}
















