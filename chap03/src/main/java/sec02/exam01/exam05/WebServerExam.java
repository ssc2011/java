package sec02.exam01.exam05;

public class WebServerExam {
    public static void main(String[] args) {

        //초기화
        Naver naver = new Naver();
        naver.setNaverController(new NaverController());

        WebServer ws = new WebServer();
        String html = ws.run("get",naver);

        System.out.println(html);
    }
}
