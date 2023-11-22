import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlProcessor {

    public static String processUrl(String url) {
        if (url.startsWith("http://")) {
            url = "https://" + url.substring(7);
        }

        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(url);
        StringBuffer buffer = new StringBuffer();
        int digitSum = 0;
        while (matcher.find()) {
            int digit = Integer.parseInt(matcher.group());
            digitSum += digit;
        }
        matcher.reset();
        while (matcher.find()) {
            matcher.appendReplacement(buffer, String.valueOf(digitSum));
        }
        matcher.appendTail(buffer);
        url = buffer.toString();

        Pattern dotComPattern = Pattern.compile("([^/]+)\\.com");
        Matcher dotComMatcher = dotComPattern.matcher(url);
        if (dotComMatcher.find()) {
            String beforeDotCom = dotComMatcher.group(1);
            char lastLetter = beforeDotCom.charAt(beforeDotCom.length() - 2);
            url = url + "/" + lastLetter;
        }

        return url;
    }

    public static void main(String[] args) {
        String[] urls = {
                "http://kahoot.com/1/2/3",
                "https://testing.com/20/30",
                "http://testing.com/1/orders/2"
        };

        for (String url : urls) {
            System.out.println("Input: " + url);
            System.out.println("Output: " + processUrl(url));
            System.out.println();
        }
    }
}
