package sec04.exam01.override;

public class Food {
    String name;
    int price;
    String recipe;
    String type;


    Food(){
        System.out.println("Food 생성자 실행");
    }

    int eat(){
        System.out.println(this.name + "먹는다");
        return (int)(Math.random()*5)+1;
    }
    int order(int money){
        int change =0;
        if(money<this.price){
            System.out.println("금액부족 주문취소");
            return 0;
        }else{
            System.out.println(this.name + "주문한다");
            change = money-this.price;
        }
        return change;
    }
    String cook(int master){
        if(master>7){
            return "기가맥히게 잘됨";
        }else if(master>4){
            return "먹을만 함";
        }else{
            return "나 혼자먹음";
        }

    }
}
