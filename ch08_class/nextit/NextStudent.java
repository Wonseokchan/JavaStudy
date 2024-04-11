package source.ch08_class.nextit;

import source.ch08_class.common.MyUtil;

public class NextStudent {
    //이름, 나이, 레벨, 경험치( = 객체의 상태 )
    //객체가 가지는 상태를 필드변수로 선언
    String name;    //학생의 이름
    int age;        //학생의 나이
    int level;      //학생의 레벨( 기본값은 1 )
    int exp;        //학생의 경험치(경험치가 100이 되면 레벨업)


    //파라미터를 입력받지 않는 기본 생성자는 클래스 내에 보이지 않더라도 기본적으로 존재한다/
    public NextStudent() {

    }

    //기본 생성자가 아닌 다른 생성자를 별도로 만들어주는 경우 보이지 않지만 존재했던 기본 생성자는 사라진다.(=사용불가)
    //만약 기본 생성자도 필요하다면 따로 만들어주어야 한다.

    //파라미터로 필드변수 값을 입력받는 생성자 만들기
    //[Alt + Insert] 후 Constructor 선택
    public NextStudent(String name, int age, int level, int exp) {
        //this는 NextStudent로부터 생성된 각 객체를 의미
        //현재 객체의 필드변수에 생성자의 파라미터로 들어온 값 부여
        this.name = name;
        this.age = age;
        this.level = level;
        this.exp = exp;
    }

    public NextStudent(String name, int age) {
//        this.name = name;
//        this.age = age;
//        //기본값 설정 두번째 방법
//        this.level = 1;
//        this.exp = 0;
        //this() 는 해당 객체의 생성자를 의미
        this(name, age, 1, 0);
    }

    //[Alt + Insert] 후 toString 선택
    @Override
    public String toString() {
        return "NextStudent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", level=" + level +
                ", exp=" + exp +
                '}';
    }

    //하루가 지남에 대한 메소드
    public void oneDayAfter(){
        exp += MyUtil.makeRandom(20, 50);
        if (exp >= 100) {
            level += 1;
            exp -= 100;
        }
    }
}
