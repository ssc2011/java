package sec03.exam01;

public class Calc {

    void powerOff(){
        System.out.println("power off");
    }

    void execute(){
        double result = avg(7,10);
        println("실행결과 : "+result);
    }
    String execute(int a,int b){
        double result = avg(a,b);
        println("실행결과 : "+result);
        return null;
    }
    double avg(int a, int b){
        double sum = plus(a,b);
        double result = sum/2;
        return result;
    }
    int plus(int x, int y){
        int result = x+y;
        return result;
    }
    double plus(double x, double y){
        double result = x+y;
        return result;
    }

    void println(String msg){
        System.out.println(msg);
    }

    /*
      오버로딩
      1.System.out.println 처럼 전달인자를 신경쓰지 않게 하기 위함
      2. 전달인자가 너무 많고 기본값을 입력하는 경우가 빈번할때 전달인자를 줄이는 목적으로도 사용함
   */
    void join(String id,String pw,String address,int age,int gender){
        System.out.println("id = " + id);
        System.out.println("pw = " + pw);
        System.out.println("address = " + address);
        System.out.println("age = " + age);
        System.out.println("gender = " + gender);
    }

    void join (String id, String pw){
        join(id,pw,null,-1,-1);
    }
}
