package quiz;

public class TvExam {
    public static void main(String[] args) {
        Tv tv = new Tv();
        tv.downVolume(); //전원이 꺼져 있으므로 동작하지 않음
        tv.power(); //전원 켜기

        tv.upVolume();
        tv.downVolume();
        tv.setChannel(60);
        tv.output();
        tv.power(); //전원 끄기
    }
}
