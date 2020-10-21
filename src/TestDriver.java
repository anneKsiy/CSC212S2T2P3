/* Created by 3935415 Abdullah Adam on 2020/09/25
 * www.github.com/anneKsiy
 * Tests for CsvUtilities.java class and Graph.java class
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDriver {
    public static void main(String[] args) {
        List<School> schools = CsvUtilities.csvToArray("Soweto.csv");
        List<School> newSchoolArr = new ArrayList<>(); // creating a new ArrayList of School Objects
        // adding the schools from the ArrayList<School> schools to newSchoolArr excluding the headings
        for (int i = 1; i < schools.size(); i++) {
            newSchoolArr.add(schools.get(i));
        }
        SortingUtilities.quickSortSchool(newSchoolArr, 0, newSchoolArr.size() - 1); // sorting the newSchoolArr alphabetically using Quick Sort
        Graph schoolsGraph = new Graph(newSchoolArr);
        int[][] matrix = Graph.graphGenerator(schoolsGraph, newSchoolArr);
        schoolsGraph.printGraph(newSchoolArr);

//        for (int i = 0; i < newSchoolArr.size(); i++) {
//            for (int j = 0; j < newSchoolArr.size(); j++) {
//                System.out.println(i + " " + matrix[i][j]);
//            }
//        }
        System.out.println(Arrays.deepToString(matrix));
        System.out.println();
        ShortestPath sp = new ShortestPath();
        int[] output = sp.dijkstra(matrix, 78);
        System.out.println("From: " + newSchoolArr.get(78) + " to: " + newSchoolArr.get(36) + " is " + output[36] + " Km");
        System.out.println("From: " + newSchoolArr.get(78) + " to: " + newSchoolArr.get(63) + " is " + output[63] + " Km");
        output = sp.dijkstra(matrix, 123);
        System.out.println("From: " + newSchoolArr.get(123) + " to: " + newSchoolArr.get(130) + " is " + output[130] + " Km");
        System.out.println("From: " + newSchoolArr.get(123) + " to: " + newSchoolArr.get(105) + " is " + output[105] + " Km");
        output = sp.dijkstra(matrix,60);
        System.out.println("From: " + newSchoolArr.get(60) + " to: " + newSchoolArr.get(100) + " is " + output[100] + " Km");
        System.out.println("From: " + newSchoolArr.get(60) + " to: " + newSchoolArr.get(33) + " is " + output[33] + " Km");
    }
}