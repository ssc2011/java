package quiz;

//import sec01.exam01.Student;

public class JoinExam {
    public static void main(String[] args) {
        Join join = new Join("가입id","가입pw");
        join.login("틀린id","틀린pw"); //로그인 실패
        join.login("가입id","가입pw"); //로그인 성공
    }

//    public static class StudentExam {
//        public static void main(String[] args) {
//            sec01.exam01.Student s1 = new sec01.exam01.Student();
//            sec01.exam01.Student s2 = new Student();
//
//        }
//    }
}
