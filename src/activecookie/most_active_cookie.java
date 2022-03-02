package activecookie;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class most_active_cookie {
    public static void main(String[] args) {
        if (args.length != 3 ) {
            System.err.println("Bad Arguments: ./most_active_cookie <path> <time_zone> <date>");
            return;
        }

        CSVReader cookieCSV = new CSVReader(args[0]);
        HashSet<Cookie> sortedCookies = new HashSet<Cookie>();

        try {
            cookieCSV.initReader();
            String currentLine;
            while ((currentLine = cookieCSV.readLine()) != null) {
                if (CookieExtract.getDate(currentLine).equals(args[2])) {
                    sortedCookies.add(new Cookie(currentLine));
                }
            }
            cookieCSV.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        Iterator<Cookie> sortedCookiesIt = sortedCookies.iterator();

        int maxOccurence = 0;
        ArrayList<Cookie> finalCookies = new ArrayList<>();
        while (sortedCookiesIt.hasNext()) {
            Cookie cookieCheck = sortedCookiesIt.next();
            if (cookieCheck.getOccurences() == maxOccurence) {
                finalCookies.add(cookieCheck);
            }
            else if (cookieCheck.getOccurences() > maxOccurence) {
                maxOccurence = cookieCheck.getOccurences();
                finalCookies.clear();
                finalCookies.add(cookieCheck);
            }
        }

        for (Cookie c: finalCookies) {
            System.out.println(c.getCookieHash());
        }

    }
}
