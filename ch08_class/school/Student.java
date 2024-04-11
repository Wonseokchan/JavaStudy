package source.ch08_class.school;

import source.ch08_class.common.MyUtil;

public class Student {
    //캡슐화
    //1. 필드변수의 접근제어자를 private로 설정
    //public : 서로 다른 폴더에서도 접근 및 사용 가능
    // (default) : 접근제어자를 생략하면, 같은 폴더에서만 접근 및 사용 가능
    // protected : 디폴트와 같음
    // private : 현재 클래스 내에서만 접근 및 사용 가능
    private String name;    /* 학생이름 */
    private int kor;        /* 국어점수 */
    private int eng;        /* 영어점수 */
    private int math;       /* 수학점수 */
    private double avg;    /* 평균(소수 첫째자리까지) */

    //기본 생성자
    public Student(){

    }

    //풀 생성자
    public Student(String name, int kor, int eng, int math, double avg) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        calAvg();
    }

    public Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        calAvg();
    }

    //우리가 만든 메소드 위치
    //평균을 계산하여 필드변수에 반영하는 메소드
    //다른 클래스에서 이 메소드를 쓸 일이 없음
    //다른 클래스에서 안쓰면 그만
    //근데도 이런 상황에서는 메소드의 접근제어자를 private로 설정해준다.
    private void calAvg(){
        this.avg = (this.kor + this.eng + this.math) / 3.0;
        this.avg = MyUtil.myRound(avg, 2);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", kor=" + kor +
                ", eng=" + eng +
                ", math=" + math +
                ", avg=" + avg +
                '}';
    }

    //캡슐화 두번째 작업
    //각 필드변수에 대한 Getter, Setter를 만든다
    //[Alt + Insert] 에 Getter, Setter 선택

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }
}
