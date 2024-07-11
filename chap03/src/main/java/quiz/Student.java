package quiz;

public class Student {
    //값
    //이름,나이,주소,성별,전공
    String name;
    int age;
    String addr;
    int gender;
    String major;
    //행동
    //공부,식사,수면,게임
    int intel;
    int stress;
    int hp;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name +
                ", age=" + age +
                ", addr='" + addr +
                ", gender=" + gender +
                ", major='" + major +
                ", intel=" + intel +
                ", stress=" + stress +
                ", hp=" + hp +
                ", hungry=" + hungry +
                '}';
    }

    int hungry;

    int study(String subject) {
        System.out.println(subject + "를 공부함");
        intel += 5;
        stress += 10;
        hp--;
        hungry++;
        return intel;
    }
    int study(int hour){
        stress += 5;
        return stress;
    }


    void sleep(){
        stress -= 5;
        hp++;
    }

    int doGame(String title,int hour){
        System.out.println(title+"시작!!!"+hour+"시간만 하자");
        //방어코딩
        //hour가 0이하인 경우 다시 입력요청
        //난이도 1 : 시간당 한번씩 "한번만 더하자" 출력
        //난이도 2 : 30분에 한번씩 출력 syso두번 ㄴㄴ
        //2시간 이하 - 오늘 좀 안되네 그만하자. 스트레스 + 5
        //4시간 이하 - 간단하게 한게임 했다. 스트레스 - 10
        //4시간 초과 - 오늘 신났다! 스트레스 - 20

        if(hour>0&&hour<=2){
            System.out.println("오늘 좀 안되네 그만하자");
            stress+=5;
        }else if(hour<=4){
            System.out.println("간단하게 한게임했다");
            stress-=10;
        }else {
            System.out.println("오늘 신났다!");
            stress-=20;
        }
        study(title);
        stress -= 5;
        hungry ++;

        return stress;
    }

    /* 생성자 */
    //이름과 나이를 입력받지 않으면 생성 못하게 만들기
    //나이는 중요하지않아서 이름 있어도 생성할 수 있게 만들기
    //단, 두번째 생성자에서는 이름과 나이를 전달받는 생성자 호출하기

    Student(String name,int age){
        this.name = name;
        this.age = age;
    }
    Student(String name){
        this(name,0);
    }
}
