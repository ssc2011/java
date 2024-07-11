package sec03.exam01;

public class Car {
    String name;
    String color;
    int cc;
    //생성자 :  new 할 때 무조건 실행되는 메소드의 일종
    //생성자를 적지않으면 기본 생성자가 자동으로 만들어짐 -> Car(){}

    //생성자 사용 이유 :
    // 1.귀찮으니까 무조건 실행하게 만들어둠
    // 2.생성을 위한 필수값 관리 : 필수값이 없으면 생성못하게 막음

    Car(){
        this("회색",1000); //this : 다른 생성자 호출
        name="자동차";
//        System.out.println(name);

//        color="gray";
//        cc=1000;
    }

    Car(String color2,int cc2){
        color=color2;
        cc=cc2;
        System.out.println("color = " + color);
        System.out.println("cc = " + cc);

    }

    void print(){
        System.out.println("color = " + color);
        System.out.println("cc = " + cc);
    }
}
