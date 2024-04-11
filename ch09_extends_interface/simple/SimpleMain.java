package source.ch09_extends_interface.simple;

public class SimpleMain {
    public static void main(String[] args) {
        Parent miseon = new Parent("봉미선",27);
        System.out.println(miseon);
        miseon.hello();
        Child jjanggu = new Child();
        System.out.println(jjanggu);

        //기본적으로 자식 클래스는 부모 클래스의 필드 변수와 메소드를 가지고 있다.
        //jjanggu.name = "짱구";
        jjanggu.setName("짱구");
        //jjanggu.age = 5;
        jjanggu.setAge(5);

        System.out.println(jjanggu);
        jjanggu.hello();

        Child jjangah = new Child("짱아", 2);
        System.out.println(jjangah);
        jjangah.hello();

        // 다형성
        //기본적으로 자식 개체는 부모 개체로 형변환하여 담을 수 있다.
        Parent jjang = new Child("짱", 10);
        Object hyeongman = new Parent("신형만", 30);

        jjang.hello();

    }
}
