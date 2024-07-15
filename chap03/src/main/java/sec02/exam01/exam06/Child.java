package sec02.exam01.exam06;

public class Child extends Parent{

    public String field1 = "Child의 field1";

    @Override
    public void method1(String field1){
        System.out.println("Child의 method1 실행");
        this.field1 = field1;

    }
}
