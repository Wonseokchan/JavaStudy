package source.ch09_extends_interface.simple;

public class Child extends Parent{

    public Child() {
    }

    public Child(String name, int age) {
        //super는 부모 객체를 의미(this는 자기 자신 객체)
        //this() 는 자기 자신 객체의 생성자
        //super() 는 부모 객체의 생성자
        super(name, age);
    }

    //Override 오버라이딩은 부모가 가진 메소드를 자식 클래스에서 재정의한다는 뜻
    @Override
    public void hello() {
        // Parent를 상속받은 Child에서도 private에는 접근할 수 없다
        //System.out.println("어린이 " + name + "입니다");
        //System.out.println("어린이 " + super.name + "입니다"); //위와 같음

        System.out.println("어린이 " + getName() + "입니다");
        //System.out.println("어린이 " + super.getName() + "입니다"); //위와 같음

    }


}
