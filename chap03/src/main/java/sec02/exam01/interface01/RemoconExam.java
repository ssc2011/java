package sec02.exam01.interface01;

import java.util.*;

public class RemoconExam {
    public static void main(String[] args) {
        RemoteControl tv = new Tv();
        Audio audio = new Audio();
        RemoteControl audio2 = audio;

        tv.turnOn();

        tv.setVolume(15);
        audio.setVolume(150);

        List list = new ArrayList();
    }
}
