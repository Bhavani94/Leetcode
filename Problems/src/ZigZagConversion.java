import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        if(s.isEmpty())
            return new String();
        if (numRows == 1)
            return s;
        int row = 0;
        int len = s.length();
        int dir = 1;
        List<StringBuilder> sb = new ArrayList<>(Math.min(numRows, s.length()));

        for (int i = 0; i < Math.min(numRows, s.length()); i++){
            sb.add(new StringBuilder());
        }

        for (int i = 0; i < len; i++){
            sb.get(row).append(s.charAt(i));
            row = row + dir;
            if (row == 0 && dir == -1)
                dir = 1;
            else if(row == numRows-1 && dir == 1)
                dir = -1;
        }

        StringBuilder ans = new StringBuilder();
        for(int i = 0; i<sb.size(); i++)
            ans.append(sb.get(i));
        return ans.toString();

    }

    public static void main(String[] args) {
        String st = "ABCDEFGHIJKLMNO";
        System.out.println(convert(st, 4));
    }
}
