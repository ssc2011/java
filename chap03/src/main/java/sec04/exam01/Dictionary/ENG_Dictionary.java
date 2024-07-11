package sec04.exam01.Dictionary;

public class ENG_Dictionary extends Dictionary {
    String[] childWords={"love", "friendship"};

    String translate_(String word){
        int num = super.translate(word);
        return childWords[num];
    }
}
