package ch03.operator;

public class Confirm33 {
    public static void main(String[] args) {
        int pencils = 534;
        int students = 30;
        // 학생 한 명이 가지는 연필 수: 몫
        int pencilsPerStudent = pencils / students;
        System.out.println(pencilsPerStudent);

        // 남은 연필 수: 나머지
        int pencilsLeft = pencils % students;
        System.out.println(pencilsLeft);
    }
}
