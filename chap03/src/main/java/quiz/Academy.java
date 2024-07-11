package quiz;

public class Academy {
    /*
        학원생Student 배열[10]
        학원이름 : "천안" 또는 "수원"

        생성자
        학원이름 필수

        join(학원생) : 필드에 등록
        viewList() : 등록된 학원생들의 이름과 나이출력
     */

    Student[] array = new Student[10];
    String academyName;
    int cnt=0;

    Academy(String academyName){
        this.academyName=academyName;
    }

    void join(Student s){
        if(cnt>9){
            System.out.println("학원에 자리가 없음");
        }else{
            array[cnt] = s;
            cnt++;
        }

    }

    void viewList(){
        System.out.println("───────────────────────────  ");
        System.out.println("학원이름 : "+ academyName);
        for(int i=0;i<cnt;i++){
            System.out.println(array[i].name+" "+array[i].age);
        }
    }


}
