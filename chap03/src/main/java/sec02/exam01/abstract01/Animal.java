package sec02.exam01.abstract01;

//new로 선언 못함
public abstract class Animal {
    String kind;
    void breathe(){
        System.out.println("숨쉬어~");
    }

    //추상메소드
    //상속받은 애들이 구현하도록 유도
    abstract void sound();
}
