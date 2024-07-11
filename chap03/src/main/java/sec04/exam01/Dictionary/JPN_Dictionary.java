package sec04.exam01.Dictionary;

public class JPN_Dictionary extends Dictionary {

    String[] childWords={"아이시떼루", "요조우"};

    String translate_(String word){
        int num = super.translate(word);
        return childWords[num];
    }
}
