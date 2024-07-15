package sec02.exam01.exam05;

import java.util.ArrayList;

public class NaverService {
    NaverDAO naverDAO;

    NaverService(){
        this.naverDAO = new NaverDAO();
    }

    void setNaverDAO(NaverDAO naverDAO) {
        this.naverDAO = naverDAO;
    }

    ArrayList getEMP(){
        System.out.println("서비스의 getEMP 실행");
        return naverDAO.selectEmp();
    }
}
