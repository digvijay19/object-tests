import org.junit.Test;

import java.util.HashMap;

import static junit.framework.Assert.assertEquals;

public class EqualsAndHashCodeTest {
    @Test
    public void test_two_persons_are_different_when_name_and_age_is_same() throws Exception {
        Person p1 = new Person("Digvijay", 19);
        Person p2 = new Person("Dubeji", 17);
        boolean actual = p1.equals(p2);
        assertEquals(false, actual);
    }

    @Test
    public void test_two_persons_are_equal_when_name_and_age_is_same() throws Exception {
        Person p1 = new Person("Digvijay", 19);
        Person p2 = new Person("Digvijay", 19);
        boolean actual = p1.equals(p2);
        assertEquals(true, actual);
    }

    @Test
    public void test_two_persons_same_hashcode_when_name_and_age_is_same() throws Exception {
        Person p1 = new Person("Digvijay", 19);
        Person p2 = new Person("Digvijay", 19);
        boolean actual = p1.hashCode() == p2.hashCode();
        assertEquals(true, actual);
    }

    @Test
    public void test_two_persons_do_not_have_same_hashcode_when_name_is_different() throws Exception {
        Person p1 = new Person("Dig", 19);
        Person p2 = new Person("Digvijay", 19);
        boolean actual = p1.hashCode() == p2.hashCode();
        assertEquals(false, actual);
    }

    @Test
    public void test_two_persons_do_not_have_same_hashcode_when_age_is_different() throws Exception {
        Person p1 = new Person("Digvijay", 19);
        Person p2 = new Person("Digvijay", 20);
        boolean actual = p1.hashCode() == p2.hashCode();
        assertEquals(false, actual);
    }

    @Test
    public void test_two_person_have_same_hashcode_when_both_have_same_reference() throws Exception {
        Person p1 = new Person("Digvijay", 19);
        Person p2 = p1;
        boolean actual = p1.hashCode() == p2.hashCode();
        assertEquals(true, actual);
    }

    @Test
    public void test_two_person_are_equal_when_both_have_same_reference() throws Exception {
        Person p1 = new Person("Digvijay", 19);
        Person p2 = p1;
        boolean actual = p1.equals(p2);
        assertEquals(true, actual);
    }

    @Test
    public void test_two_Wrong_persons_are_not_equal_even_when_name_and_age_is_same() throws Exception {
        WrongPerson p1 = new WrongPerson("Digvijay", 20);
        WrongPerson p2 = new WrongPerson("Digvijay", 20);
        boolean actual = p1.equals(p2);
        assertEquals(false, actual);
    }

    @Test
    public void test_two_Wrong_persons_are_not_equal_when_name_and_age_is_not_same() throws Exception {
        WrongPerson p1 = new WrongPerson("Dubeji", 17);
        WrongPerson p2 = new WrongPerson("Digvijay", 19);
        boolean actual = p1.equals(p2);
        assertEquals(false, actual);
    }

    @Test
    public void test_two_Wrong_persons_have_different_hashcode_even_when_name_and_age_is_same() throws Exception {
        WrongPerson p1 = new WrongPerson("Digvijay", 19);
        WrongPerson p2 = new WrongPerson("Digvijay", 19);
        boolean actual = p1.hashCode() == p2.hashCode();
        assertEquals(false, actual);
    }

    @Test
    public void test_two_Wrong_persons_have_different_hashcode_when_name_and_age_is_different() throws Exception {
        WrongPerson p1 = new WrongPerson("Digvijay", 19);
        WrongPerson p2 = new WrongPerson("Dig", 29);
        boolean actual = p1.hashCode() == p2.hashCode();
        assertEquals(false, actual);
    }

    //-----------------hashmap test--------------------------

    Person digvijay = new Person("Digvijay", 19);
    Person digvijay1 = new Person("Digvijay", 19);
    WrongPerson guru = new WrongPerson("Guru", 22);
    WrongPerson guru1 = new WrongPerson("Guru", 22);

    @Test
    public void test_insert_in_hashmap_overwrites_duplicate_data_using_equals_and_hashcode() {
        HashMap<Person, Person> map1 = new HashMap<Person, Person>();
        map1.put(digvijay, digvijay);
        map1.put(digvijay1, digvijay1);
        int actual = map1.size();
        assertEquals(1, actual);
    }

    @Test
    public void test_inserts_same_person_when_wrong_implementation_of_equals() {
        HashMap<WrongPerson, WrongPerson> people = new HashMap<WrongPerson, WrongPerson>();
        people.put(guru, guru);
        people.put(guru1, guru1);
        int actual = people.size();
        assertEquals(2, actual);
    }
}