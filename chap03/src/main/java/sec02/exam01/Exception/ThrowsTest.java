package sec02.exam01.Exception;

public class ThrowsTest {

    void method2(String name) throws ClassNotFoundException {
        Class clazz = Class.forName(name);
    }

    void method1(){
        try {
            method2("java.lang.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void throwException() {
        System.out.println("출력은 아무거나");
        throw new NumberFormatException("글씨");
    }

    void human(int e) throws HumanException{
        System.out.println("human 실행 : e : "+ e);
        if(e < 5) {
            throw new HumanException("EC05"); //에러를 발생시켜서 HumanException에 떠넘김
        } else if(e > 10) {
            throw new HumanException("EC10"); //에러를 발생시켜서 HumanException에 떠넘김
        } else {
            System.out.println("5이상 10이하로 정상입니다");
        }
    }
}