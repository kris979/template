package questions;

/*
given a string with repeating characters (i.e. "aaabbc") write an alogrithm that will compress given string
to a character followed by a number of times it appears in a string. is a copressed string is not smaller than original
then return original.
 */
public class Compressor {

    public String compress(String input) {
        StringBuilder compressed = new StringBuilder();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            count++;
            //keep counting until we reach end of a string or next char is different
            if (i + 1 >= input.length() || input.charAt(i) != input.charAt(i + 1)) {
                compressed.append(input.charAt(i));
                compressed.append(count);
                count=0;
            }
        }
        return compressed.length() < input.length() ? compressed.toString() : input;
    }
}
