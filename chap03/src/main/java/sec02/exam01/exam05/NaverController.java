package sec02.exam01.exam05;

import java.util.ArrayList;

public class NaverController {
    NaverService naverService;

    NaverController(){
        this.naverService = new NaverService();
    }

    void setNaverService(NaverService naverService) {
        this.naverService = naverService;
    }

    String doGet(){
        String html = "";
        html+= "<div>";

        ArrayList list =  naverService.getEMP();
        String table = list.toString(); //ArrayList를 String 으로 변환
        html+=table;

        html+= "</div>";

        return html;
    }
}
