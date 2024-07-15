package sec02.exam01.interface01;

public class Tv implements RemoteControl {
    int volume;

    @Override
    public void turnOn() {
        System.out.println("TV on");
    }

    @Override
    public void turnOff() {
        System.out.println("TV off");

    }

    @Override
    public void setVolume(int volume) {
        if(volume >RemoteControl.MAX_VOLUME){
            volume = RemoteControl.MAX_VOLUME;
        }else if(volume <RemoteControl.MIN_VOLUME){
            volume = RemoteControl.MIN_VOLUME;
        }
        this.volume = volume;

        System.out.println("TV현재볼륨 : "+this.volume);
    }

}