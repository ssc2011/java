package sec02.exam01.exam06;

public class Parent {
    public String field1 ="Parent의 field1";

    public void method1(String field1){
        System.out.println("Parent의 method1 실행");
        this.field1 = field1;

    }
}
