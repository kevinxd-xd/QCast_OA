package activecookie;

public class Cookie {
    String cookieHash;
    String cookieDate;
    String cookieTime;
    int occurences;

    public Cookie(String inputCookie) {
        this.cookieHash = CookieExtract.getCookieHash(inputCookie);
        this.cookieDate = CookieExtract.getDate(inputCookie);
        this.cookieTime = CookieExtract.getTime(inputCookie);
        this.occurences = 0;
    }

    @Override
    public boolean equals(Object arg1) {
        if ((arg1 instanceof Cookie && ((Cookie) arg1).getCookieHash().equals(this.cookieHash))) {
            ((Cookie) arg1).occurences++;
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return cookieHash.hashCode();
    }

    public String getCookieHash() {
        return this.cookieHash;
    }

    public int getOccurences() {
        return this.occurences;
    }
}
