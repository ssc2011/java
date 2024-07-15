package sec02.exam01.exam02;

public class Exam {
    public static void main(String[] args) {
        C c = new C();

        //부모 타입으로 형변환
        B b = (B)c;

        A a = (A)b;

        a=c;

        // A a1 = (A)( (B) new C() ); 를 생략해서 작성한 것임
        A a1 = new C();


        A a2 = new B2();

        //타입이 같으므로 가능함
        a1 = a2;
    }
}
