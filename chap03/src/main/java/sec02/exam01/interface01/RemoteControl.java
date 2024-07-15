package sec02.exam01.interface01;

public interface RemoteControl {
    //상수 = static final
    public static final int MAX_VOLUME = 100;
    int MIN_VOLUME = 0; //public static final 생략 가능


    // public abstract 생략가능
    public abstract void turnOn();
    void turnOff();
    void setVolume(int volume);
}
