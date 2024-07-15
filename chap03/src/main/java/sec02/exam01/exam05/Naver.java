package sec02.exam01.exam05;

public class Naver {


    NaverController naverController;

    void setNaverController(NaverController naverController) {
        this.naverController = naverController;
    }

    String doService(String method){ //method : get or post
        String html = null;

        if("get".equals(method)){
           html = this.naverController.doGet();
        }
        return html;
    }

}
