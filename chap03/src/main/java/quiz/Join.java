package quiz;

public class Join {
    String id;
    String pw;

    Join(String id, String pw){
        this.id=id;
        this.pw=pw;
    }

    boolean login(String id,String pw){
        if(this.id.equals(id) && this.pw.equals(pw)){
            System.out.println("메인페이지");
            return true;
        }else{
            System.out.println("로그인 화면으로 돌아감");
            return false;
        }
    }
}
