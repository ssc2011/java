package quiz;

public class StudentExam {
    public static void main(String[] args) {

//        System.out.println(s1.name); //String은 null로 초기화
//        System.out.println(s1.age); //int는 0으로 초기화

//        s1.name="이름";
//        s1.age=18;
//        s1.addr="주소";
//        s1.gender=1;
//        s1.major="컴공";


//        int intel = s1.study("자바 클래스");
//        System.out.println("공부했더니 지식 : " + intel);
//
//        System.out.println(s1); //toString 호출
//        System.out.println(s1.toString());//윗줄이랑 같은거 ㅇㅇ
//
//        view(s1);
        Student s1 = new Student("서수찬",26);
        Student s2 = new Student("박경민",29);
        Student s3 = new Student("강희연",25);

        Academy academy1 = new Academy("천안");
        Academy academy2 = new Academy("수원");

        academy1.join(s1);
        academy1.join(s2);
        academy1.viewList();

        academy2.join(s3);
        academy2.viewList();
    }

    static void view(Student s){
//        String str= s.toString();
        int stress = s.doGame("오버워치",2);
        System.out.println("이 학생의 스트레스 수치는 : " + stress);

    }

}
