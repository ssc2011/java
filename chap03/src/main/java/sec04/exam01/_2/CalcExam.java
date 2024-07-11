package sec04.exam01._2;

public class CalcExam{
    public static void main(String[] args) {
        Calc calc1 = new Calc();
        Calc calc2 = new Calc();

        calc1.color="빨강";
        calc2.color="파랑";

        System.out.println(calc1.pi);

        System.out.println(Calc.pi);
    }
}
