public class OffByN implements CharacterComparator{
    private int diff;

    /** Set the different between two chars to be n. */
    public OffByN(int n) {
        diff = n;
    }

    /** Returns true only when the two characters are different by diff. */
    @Override
    public boolean equalChars(char x, char y) {
        return (((x - y) == diff) || ((y - x) == diff));
    }
}
