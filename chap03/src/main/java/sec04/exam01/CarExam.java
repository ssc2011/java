package sec04.exam01;

public class CarExam extends Car {

    public static void main(String[] args) {
        Avante car1 = new Avante();

        car1.drive();
        int speed = car1.accel(4);
        System.out.println("현재속도 : "+speed);

        speed = car1.breaking(4);
        System.out.println("현재 감속도 : "+speed);


    }

}
