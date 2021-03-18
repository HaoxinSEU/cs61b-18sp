import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator cc = new OffByOne();
    static CharacterComparator ccN = new OffByN(5);

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertFalse(palindrome.isPalindrome("racebar"));

        assertFalse(palindrome.isPalindrome("racecar", cc));
        assertFalse(palindrome.isPalindrome("noon", cc));
        assertTrue(palindrome.isPalindrome("a", cc));
        assertTrue(palindrome.isPalindrome("bhjga", cc));
        assertTrue(palindrome.isPalindrome("ekfgld", cc));

        assertFalse(palindrome.isPalindrome("racecar", ccN));
        assertFalse(palindrome.isPalindrome("noon", ccN));
        assertTrue(palindrome.isPalindrome("a", ccN));
        assertTrue(palindrome.isPalindrome("bhjmg", ccN));
        assertTrue(palindrome.isPalindrome("ekfapj", ccN));

    }
}
