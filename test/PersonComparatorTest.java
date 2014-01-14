import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static junit.framework.Assert.assertEquals;

@SuppressWarnings("unchecked")
public class PersonComparatorTest {
    public static List addPeopleToList(Person... persons) {
        List<Person> people = new ArrayList<Person>();
        Collections.addAll(people, persons);
        return people;
    }

    Person swamiji = new Person("Swamiji", 3);
    Person kunal = new Person("Kunal", 50);
    Person digvijay = new Person("Digvijay", 35);

    @Test
    public void test_comparator_of_person_with_of_name() {
        List<Person> people = addPeopleToList(digvijay, kunal, swamiji);
        Collections.sort(people);
        String actual;
        String expected;
        expected = people.get(0).getName();
        actual = "Digvijay";
        assertEquals(expected, actual);
        expected = people.get(1).getName();
        actual = "Kunal";
        assertEquals(expected, actual);
        expected = people.get(2).getName();
        actual = "Swamiji";
        assertEquals(expected, actual);
    }

    @Test
    public void test_comparator_of_person_with_age() {
        List<Person> people = addPeopleToList(digvijay, kunal, swamiji);
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getAge() - p2.getAge();
            }
        });
        String actual;
        String expected;
        actual = "Swamiji";
        expected = people.get(0).getName();
        assertEquals(expected, actual);
        actual = "Digvijay";
        expected = people.get(1).getName();
        assertEquals(expected, actual);
        actual = "Kunal";
        expected = people.get(2).getName();
        assertEquals(expected, actual);
    }

    @Test
    public void test_comparator_of_person_with_length_of_name() {
        List<Person> people = addPeopleToList(digvijay, kunal, swamiji);
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getName().length() - p2.getName().length();
            }
        });
        String actual;
        String expected;
        expected = people.get(0).getName();
        actual = "Kunal";
        assertEquals(expected, actual);
        expected = people.get(1).getName();
        actual = "Swamiji";
        assertEquals(expected, actual);
        expected = people.get(2).getName();
        actual = "Digvijay";
        assertEquals(expected, actual);
    }

    @Test
    public void test_comparator_of_person_with_length_of_name_in_reverse() {
        List<Person> people = addPeopleToList(digvijay, kunal, swamiji);
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p2.getName().length() - p1.getName().length();
            }
        });
        String actual;
        String expected;
        expected = people.get(0).getName();
        actual = "Digvijay";
        assertEquals(expected, actual);
        expected = people.get(1).getName();
        actual = "Swamiji";
        assertEquals(expected, actual);
        expected = people.get(2).getName();
        actual = "Kunal";
        assertEquals(expected, actual);
    }
}
