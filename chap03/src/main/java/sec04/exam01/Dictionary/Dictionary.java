package sec04.exam01.Dictionary;

public class Dictionary {
    String[] words = {"사랑","우정"};

    int translate(String word){
        for(int i=0;i<words.length;i++){
            if(words[i].equals(word)){
                return i;
            }
        }
        return -1;
    }
}
