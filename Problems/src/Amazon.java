import java.util.*;

public class Amazon {
// 23280666979011

    public static List<String> orderedJunctionBoxes(int numberOfBoxes, List<String> boxList) {
        if(numberOfBoxes == 0 || numberOfBoxes == 1) {
            return boxList;
        }

        Collections.sort(boxList, (s1, s2) -> {
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if(!isDigit1 && !isDigit2) {
                int comp = split1[1].compareTo(split2[1]);
                if(comp != 0) {
                    return comp;
                }
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });

        return boxList;
    }
    public static List<String> orderedJunctionBoxes1(int numberOfBoxes, List<String> boxList) {
        LinkedList<String> ans = new LinkedList<>();
        Queue<String> pq = new PriorityQueue<>((s1, s2) -> {
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s2.split(" ", 2);
            int comp = split2[1].compareTo(split1[1]);
            if(comp != 0) {
                return comp;
            }
            return split2[0].compareTo(split1[0]);
        });

        for(String box : boxList) {
            String[] sp = box.split(" ", 2);
            if(Character.isDigit(sp[1].charAt(0))) {
                ans.add(box);
            } else {
                pq.add(box);
            }
        }

        while(!pq.isEmpty()) {
            ans.addFirst(pq.poll());
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("mi2 jog mid pet");
        input.add("wz3 34 54 398");
        input.add("a1 alps cow bar");
        input.add("a1 alps cow car");
        input.add("x4 45 21 7");
        System.out.println(orderedJunctionBoxes(4, input));
        System.out.println(orderedJunctionBoxes1(4, input));
    }
}
