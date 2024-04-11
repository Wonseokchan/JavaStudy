package ch03.operator;

public class IncreamentExample {
    public static void main(String[] args) {
        int x = 10;
        int y = 10;
        int z = ++x + ++y;
        System.out.println(z); // x: 11, y: 11, z: 22
        z = ++x + y++;
        System.out.println(z); // x: 12, y: 12, z: 23
        z = x++ + ++y;
        System.out.println(z); // x: 13, y: 13, z: 25
        z = x++ + y++;
        System.out.println(z); // x: 14, y: 14, z: 26
    }
}
