package sec04.exam01.override;

public class 제육 extends Food{
    제육(){
        System.out.println("제육 생성자 실행");
        this.name = "제육";
        this.price = 6000;
        this.recipe = "돼지고기 앞다리";
        this.type = "한식";
    }
}
