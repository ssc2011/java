package sec02.exam01.exam03;

public class DriverExam {
    public static void main(String[] args) {

        Driver driver = new Driver();

        Avante avante = new Avante();
        Car car = (Car)avante;
        // 위 두줄과 같은 코드임 Car car = new Avante();

        driver.run(car);

        Spark spark = new Spark();
        driver.run(spark);
    }
}
