import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class StringTests {
    @Test
    public void test_two_string_literals_are_not_equal_when_they_are_different() throws Exception {
        String a = "Digvijay";
        String b = "Dubeji";
        boolean actual = a.equals(b);
        assertEquals(actual,false);
    }

    @Test
    public void test_two_string_literals_are_equal_when_they_are_same() throws Exception {
        String a = "Digvijay";
        String b = "Digvijay";
        boolean actual = a.equals(b);
        assertEquals(actual,true);
    }

    @Test
    public void test_two_string_Objects_are_equal_when_they_are_same() throws Exception {
        String a = new String("Digvijay");
        String b = new String("Digvijay");
        boolean actual = a.equals(b);
        assertEquals(actual,true);
    }

    @Test
    public void test_two_string_Objects_are_not_equal_when_they_are_not_same() throws Exception {
        String a = new String("Digvijay");
        String b = new String("Dubeji");
        boolean actual = a.equals(b);
        assertEquals(actual,false);
    }
}
