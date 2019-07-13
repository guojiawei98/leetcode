package offer;

public class ReplaceSpaceDemo {
    public String replaceSpace(StringBuffer str) {
        String s = str.toString();
        return s.replace(" ","%20");
    }
}
