package sec04.exam01.override;

public class Computer extends Calc{
    @Override
    double areaCircle(double radius) {
        System.out.println("Computer의 areaCircle실행");
        return Math.PI * radius * radius;
    }

    void method(){
        super.areaCircle(5); //부모의 메소드 호출
    }

}
