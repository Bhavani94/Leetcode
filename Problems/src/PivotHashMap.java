import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PivotHashMap {
    public HashMap<String, List<String>> pivotMap(Map<String, String> map) {
        HashMap<String, List<String>> revMap = new HashMap<>();
        List<String> list;
        for(String key : map.keySet()) {
            String value = map.get(key);
            list = revMap.getOrDefault(value, new ArrayList<>());
            list.add(key);
            revMap.put(value, list);
        }
        return revMap;
    }
    public static void main(String[] argv) {
        PivotHashMap p = new PivotHashMap();
        HashMap<String, String> map = new HashMap<>();
        map.put("1","one");
        map.put("2","two");
        map.put("3","three");
        map.put("4","four");
        map.put("5","four");
        System.out.println(p.pivotMap(map));
    }
}
