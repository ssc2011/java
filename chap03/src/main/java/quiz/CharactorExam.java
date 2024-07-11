package quiz;

import java.util.Scanner;

public class CharactorExam {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice;
        boolean turn=true;
        boolean run=true;
        Charactor charactor1 = new Charactor();
        Charactor charactor2 = new Charactor();

        System.out.println("캐릭터2가 캐릭터2에게 싸움을 걸어왔다! 캐릭터1 먼저 시작!!!");
        while(run) {
            if(turn) { //캐릭터1의 턴
                System.out.println("────────────────────────────");
                System.out.println("캐릭터1 의 선택");
                System.out.println(" 1.상대방 공격!   2.체력 회복! ");
                choice = scan.nextInt();
                if (choice == 1) {
                    charactor1.attackPower = (int) (Math.random() * 20)+1; // 캐릭터1의 공격력 1~20 랜덤 지정
                    charactor2.attack(charactor1.attackPower); //캐릭터2에게 공격 -> 캐릭터2의 체력을 깎음
                    System.out.println("캐릭터2의 남은 체력 : "+charactor2.health);
                } else if (choice == 2) {
                    int random = (int) (Math.random() * 5)+1; // 1~5 랜덤하게 힐
                    charactor1.heal(random);
                    System.out.println("힐!!!");
                    System.out.println("캐릭터1의 남은 체력 : "+charactor1.health);
                }
                turn=false;
            }else{ //캐릭터2의 턴
                System.out.println("────────────────────────────");
                System.out.println("캐릭터2 의 선택");
                System.out.println(" 1.상대방 공격!   2.체력 회복! ");
                choice = scan.nextInt();
                if (choice == 1) {
                    charactor2.attackPower = (int) (Math.random() * 20)+1; // 캐릭터2의 공격력 1~20 랜덤 지정
                    charactor1.attack(charactor2.attackPower); //캐릭터1에게 공격 -> 캐릭터1의 체력을 깎음
                    System.out.println("캐릭터1의 남은 체력 : "+charactor1.health);
                } else if (choice == 2) {
                    int random = (int) (Math.random() * 5)+1; // 1~5 랜덤하게 힐
                    charactor2.heal(random);
                    System.out.println("힐!!!");
                    System.out.println("캐릭터2의 남은 체력 : "+charactor2.health);
                }
                turn=true;
            }
            if(charactor1.health<=0) {
                System.out.println("캐릭터2의 승리!");
                run=false;
            }
            if(charactor2.health<=0) {
                System.out.println("캐릭터2의 승리!");
                run=false;
            }

        }



    }
}
