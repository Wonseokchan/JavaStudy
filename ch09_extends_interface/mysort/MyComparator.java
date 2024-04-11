package source.ch09_extends_interface.mysort;

import source.ch08_class.school.Student;

public interface MyComparator<T> {
    boolean myCompare(T left, T right);
}
