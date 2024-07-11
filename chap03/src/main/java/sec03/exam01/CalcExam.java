package sec03.exam01;

public class CalcExam {
    public static void main(String[] args) {
        powerOn();

        Calc calc = new Calc();
        calc.powerOff();

        calc.execute();
        calc.println("abc");
        calc.avg(4,50);
    }
    static void powerOn(){
        System.out.println("Power on");
    }


}
