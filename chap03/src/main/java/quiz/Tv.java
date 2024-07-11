package quiz;

public class Tv {
    int volume;
    int channel;
    boolean power;
    Tv(){
        volume = 5;
        channel = 10;
        power = false;
    }
    void upVolume(){
        if(!power){
            System.out.println("전원이 꺼져 있습니다");
        }else{
            if(volume == 10){
                System.out.println("최대볼륨 입니다");
            }else{
                this.volume++;
            }
        }

    }
    void downVolume(){
        if(!power){
            System.out.println("전원이 꺼져 있습니다");
        }else{
            if(volume == 0){
                System.out.println("최소볼륨 입니다");
            }else{
                this.volume--;
            }
        }

    }
    void power(){
        if(!power) {
            System.out.println("Power On");
            this.power = true;
        }else{
            System.out.println("Power Off");
            this.power = false;
        }
    }


    void setChannel(int channel) {
        this.channel = channel;
    }

    void output(){ //정보 전부 출력
        System.out.println("volume = " + volume);
        System.out.println("channel = " + channel);
        System.out.println("power = " + power);
    }
}
