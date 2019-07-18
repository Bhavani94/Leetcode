import java.util.*;

public class HashMapSort {
    protected class Batch {
        private int id;
        private List<Student> students;
        private int score;

        public Batch(int id, List<Student> students) {
            this.id = id;
            this.students = students;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }

    protected class Student {
        private int id;
        private int rank;

        public Student(int id, int rank) {
            this.id = id;
            this.rank = rank;
        }
    }

    public Map<Batch, List<Student>> sortBatchByRank(List<Batch> batches) {
        Map<Batch, List<Student>> map = new LinkedHashMap<>();
        for(Batch batch : batches) {
            int sum = sumStudentRanks(batch.students);
            batch.setScore(sum);
        }

        Collections.sort(batches, (o1, o2) -> o2.getScore() - o1.getScore());
        System.out.println(batches);

        batches.forEach(batch -> map.put(batch, batch.students));

        return map;
    }

    public int sumStudentRanks(List<Student> students) {
        int sum = 0;
        for(Student student : students) {
            sum +=student.rank;
        }
        return sum;
    }

    private List<Student> createStudentList(int[][] data) {
        List<Student> students = new ArrayList<>();
        for (int[] curr : data) {
            students.add(new Student(curr[0], curr[1]));
        }
        return students;
    }

    private List<Batch> createBatchList() {
        List<Batch> batches = new ArrayList<>();
        batches.add(new Batch(1, createStudentList(new int[][]{{1, 1}, {2, 3}, {3, 2}})));
        batches.add(new Batch(2, createStudentList(new int[][]{{10, 3}, {11, 2}, {12, 2}, {13, 1}})));
        batches.add(new Batch(3, createStudentList(new int[][]{{20, 3}, {21, 2}, {22, 2}})));
        return batches;
    }

    public static void main(String[] args) {
        HashMapSort s1 = new HashMapSort();
        System.out.println(s1.sortBatchByRank(s1.createBatchList()));
    }
}
