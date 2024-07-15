package sec02.exam01.exam03;

//대리기사
public class Driver {

//    void run(Avante avante){
//        System.out.println("전달인자로 아반떼만 받음");
//        avante.drive();
//    }
//
//    void run(Spark spark){
//        System.out.println("전달인자로 스파크만 받음");
//        spark.drive();
//    }

    void run(Car car){
        System.out.println("전달인자로 Car만 받음");
        car.drive();
    }
}
