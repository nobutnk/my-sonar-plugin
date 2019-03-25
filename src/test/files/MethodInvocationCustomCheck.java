import java.util.List;
import java.util.ArrayList;

class MyClass {
    void    foo2(int value) {
        SubClass sc = new SubClass();
        List<String> testList = null;
        sc.setList(testList); // Noncompliant
    } 
    int     foo3(int value) {
        SubClass sc = new SubClass();
        List<String> testList = new ArrayList<>();
        sc.setList(testList); // Noncompliant
    }
    int     foo4(int value) {
        SubClass sc = new SubClass();
        String test = "test";
        sc.setStr(test);
    }
}

class SubClass {
    List<String> stringList;
    String str;
    void setList(List<String> stringList) { this.stringList = stringList; }
    void setStr(String str) { this.str = str; }
}