public class Palindrome {
    /** Convert a string word into a deque of character. */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> wordDeque =  new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            wordDeque.addLast(currentChar);
        }
        return wordDeque;
    }

    /** Returns ture if the given word is a palindrome. */
    public boolean isPalindrome(String word) {
        Deque<Character> wordDeque = wordToDeque(word);
        return isPalindrome(wordDeque);
    }

    /** The helper method of isPalindrome(). */
    private boolean isPalindrome(Deque<Character> wordDeque) {
        int length = wordDeque.size();  //the length of the word

        if (length == 1) {  //only one character in the word, true
            return true;
        } else {
            if (length == 0) {    //only two character in the word, check whether they are equal
                return true;
            } else {
                char front = wordDeque.removeFirst();
                char back = wordDeque.removeLast();
                if (front == back) {   //if these two character are the same, recursion
                    return isPalindrome(wordDeque);
                } else {
                    return false;
                }
            }
        }
    }

    /** Overload the method isPalindrome() with a new parameter cc.*/
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> wordDeque = wordToDeque(word);
        return isPalindrome(wordDeque, cc);
    }

    /** The helper method of the overloaded function isPalindrome(). */
    private boolean isPalindrome(Deque<Character> wordDeque, CharacterComparator cc) {
        int length = wordDeque.size();  //the length of the word

        if (length == 1) {
            return true;
        } else {
            if (length == 0) {
                return true;
            } else {
                char front = wordDeque.removeFirst();
                char back = wordDeque.removeLast();
                if (cc.equalChars(front, back)) {
                    return isPalindrome(wordDeque, cc);
                } else {
                    return false;
                }
            }
        }
    }
}
