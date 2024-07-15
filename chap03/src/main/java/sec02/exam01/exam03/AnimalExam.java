package sec02.exam01.exam03;

public class AnimalExam {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();

        // dog = cat  -> 타입이 달라서 불가능함

        Animal aDog = new Dog();
        Animal aCat = new Cat();

        //타입이 같이 때문에 가능함
        //aDog = aCat;

        aDog.sound();
        aCat.sound();

        Animal animal = new Animal();
        animal.sound();
    }
}
