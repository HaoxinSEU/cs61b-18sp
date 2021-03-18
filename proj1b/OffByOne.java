public class OffByOne implements CharacterComparator{
    /** Returns true only when the two characters are different by one.
     *  e.g. equalChars('a', 'b') = true; equalChars('d', 'c') = true.
     */
    @Override
    public boolean equalChars(char x, char y){
        return (((x - y) == 1) || ((x - y) == -1));
    }
}
