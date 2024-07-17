package sec02.exam01.exam07;

public class MemberDTO {
    String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[name=" + name + ", age=" + age + "]";
    }
}
