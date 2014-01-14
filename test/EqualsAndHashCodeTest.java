import org.junit.Test;

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
}