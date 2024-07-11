package sec03.exam01;

public class MemberJoinExam {
    public static void main(String[] args) {
        //아이디,비밀번호는 필수
        //주소 입력하기 싫으면 null입력
        //나이 입력하기 싫으면 -1 입력
        //성별 입력하기 싫으면 -1 입력
        Calc member = new Calc();
        member.join("id","pw","주소",20,1);

        member.join("아이디","1234");
    }
}
