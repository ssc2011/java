package sec02.exam01.exam06;

public class ChildExam {
    public static void main(String[] args) {
        Child child = new Child();
        child.method1("차일드");
        System.out.println("Child의 field1 : "+ child.field1);

        System.out.println("-------------------------------------------");
        Parent parent = new Child();
        parent.method1("부모"); //child의 method1 실행
        System.out.println("parent의 field1 : "+ parent.field1); //부모의 필드가 출력됨. 왜? 필드는 오버라이드 되지 않기 때문

        System.out.println("-------------------------------------------");

        Child child2 = (Child) parent; //부모타입에서 자식타입으로 타입변환을 할때는 (Child)를 생략할 수 없음
        System.out.println("child2의 field1 : "+ child2.field1);
        System.out.println("-------------------------------------------");

        Parent p1 = new Child();
        Parent p2 = new Child101();

        boolean isChild = p2 instanceof Child; // p2가 Child의 인스턴스인지 확인
        if(isChild){
            Child c2 = (Child) p2; // 에러난다는 표시는 없지만 컴파일하면 에러남. p2는 Child101이기 때문
        }
        Child c = (Child) p1;


    }
}
