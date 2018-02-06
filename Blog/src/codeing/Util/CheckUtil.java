package codeing.Util;

public class CheckUtil {

    /**
     *
     * @param args
     * @return
     */
    public static boolean checkNulls(String... args) {
        if (args.length == 0) {
            return true;
        }
        for (String str : args) {
            if (isNullOrEmpty(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNullOrEmpty(String input) {
        return input == null;
    }

}
