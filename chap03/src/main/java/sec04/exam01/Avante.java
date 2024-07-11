package sec04.exam01;

public class Avante extends Car{

    Avante(){
        
    }
    @Override
    void drive(){
        System.out.println("아반떼 붕붕~!");
    }

    @Override
    int accel(int press){
        System.out.println(press+"만큼 아반떼 가속!");
        return press*3;
    }

    @Override
    int breaking(int press){
        System.out.println(press+"만큼 아반떼 정지!");
        return press*3;
    }
}
