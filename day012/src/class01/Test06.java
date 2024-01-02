package class01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person p = (Person) o;
        return Objects.equals(name, p.name);
    }
}

public class Test06 {
    public static void main(String[] args) throws Exception {
        Person p1 = new Person("홍길동");
        Person p2 = new Person("홍길동");

        // 두 객체의 해시 코드
        System.out.println(p1.hashCode()); // 460141958
        System.out.println(p2.hashCode()); // 1163157884

        // 해시코드가 달라도, equals를 재정의 했기 때문에 동등함
        System.out.println(p1.equals(p2)); // true

        // 리스트를 생성하고 두 객체 데이터를 추가한다.
        List<Person> peopleList = new ArrayList<>();
        peopleList.add(p1);
        peopleList.add(p2);
        
        Set<Person> peopleSet = new HashSet<>();
        peopleSet.add(p1);
        peopleSet.add(p2);
        
        // 그리고 리스트의 길이를 출력한다.
        System.out.println(peopleList.size()); // 2
        System.out.println(peopleSet.size());
        
        
    }
}
