package source.ch09_extends_interface.simple;

public class Parent {
    private String name;
    private int age;

    public Parent() {
    }

    public Parent(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void hello(){
        System.out.println("어른인 " + name + "입니다");
    }

    //기본적으로 모든 클래스는 보이지는 않지만 Object 클래스를 상속받고 있다.
    //toString() 메소드는 Object 클래스 내에 선언되어 있다.
    @Override
    public String toString() {
        return "Parent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
