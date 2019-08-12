import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class I_Subset {
    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums,
                            int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
//            System.out.println(i + " -> " + tempList);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
//            System.out.println("remove " + i + " -> " + tempList);
        }
    }

    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
            if(nums == null || nums.length == 0)
              return result;
            Arrays.sort(nums);
        subsetsWithDupHelper(nums, new ArrayList<>(), result, 0);
            return result;
    }

    private static void subsetsWithDupHelper(int[] nums, List<Integer> currentList,
                                             List<List<Integer>> result, int start) {
        result.add(new ArrayList<>(currentList));
        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i - 1])
                continue;
            currentList.add(nums[i]);
            subsetsWithDupHelper(nums, currentList, result, i + 1);
            currentList.remove(currentList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[] {1, 2, 3}));
        System.out.println(subsets(new int[] {1, 3, 2, 3}));
        System.out.println(subsetsWithDup(new int[] {1, 3, 2, 3}));
    }
}
