package sec02.exam01.abstract01;

public class AnimalExam {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound();
        dog.breathe();

        Animal a = dog;
        a.sound();
    }
}
