import java.util.HashSet;
import java.util.Set;

public class NumUniqueEmails {
    public static int numUniqueEmails(String[] emails) {
        Set<String> sb = new HashSet<>();
        for(String s : emails){
            int first = s.indexOf('@');
            String email1 = s.substring(0, first);
            String email2 = s.substring(first, s.length()-1);
            email1 = email1.replace(".", "");
            if(email1.contains("+"))
                email1 = email1.substring(0, email1.indexOf("+"));
            sb.add(email1+email2);
        }
    return sb.size();
    }

    public static void main(String[] args) {
        System.out.println(numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));
    }
}
