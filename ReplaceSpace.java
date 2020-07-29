package java_0729;

public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        int newLength = str.length() + 2 * count;
        int oldEnd = str.length() - 1;
        int newEnd = newLength - 1;
        str.setLength(newLength);
        while (oldEnd < newEnd) {
            if (str.charAt(oldEnd) == ' ') {
                str.setCharAt(newEnd--, '0');
                str.setCharAt(newEnd--, '2');
                str.setCharAt(newEnd--, '%');
                oldEnd--;
            } else {
                str.setCharAt(newEnd--, str.charAt(oldEnd));
                oldEnd--;
            }
        }
        return str.toString();
    }
}
