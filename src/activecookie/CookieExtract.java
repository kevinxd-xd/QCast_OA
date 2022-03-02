package activecookie;

/**
 * CookieExtract is a utility class that allows us to parse different parts of the cookie string.
 */
public class CookieExtract {
    public static String getCookieHash(String cookie) {
        return cookie.split(",")[0];
    }
    public static String getDate(String cookie) {
        return cookie.split(",")[1].split("T")[0];
    }
    public static String getTime(String cookie) {
        return cookie.split(",")[1].split("T")[1];
    }
}
