/* Created by 3935415 Abdullah Adam on 2020/09/25
 * www.github.com/anneKsiy
 * Tests for CsvUtilities.java class and Graph.java class
 */
import java.util.ArrayList;
import java.util.List;

public class TestDriver {
    public static void main(String[] args) {
//        Graph graph = new Graph(4);
//
//        graph.addEdge(0, 1);
//        graph.addEdge(0, 2);
//        graph.addEdge(1, 2);
//        graph.addEdge(2, 0);
//        graph.addEdge(2, 3);
//        graph.addEdge(3, 3);


        List<School> schools = CsvUtilities.csvToArray("Soweto.csv");
        List<School> newSchoolArr = new ArrayList<>(); // creating a new ArrayList of School Objects
        // adding the schools from the ArrayList<School> schools to newSchoolArr excluding the headings
        for (int i = 1; i < schools.size(); i++) {
            newSchoolArr.add(schools.get(i));
        }
        SortingUtilities.quickSortSchool(newSchoolArr, 0, newSchoolArr.size() - 1); // sorting the newSchoolArr alphabetically using Quick Sort
        List<School> filteredSchools = Graph.filteredGenerator(newSchoolArr);
        System.out.println(filteredSchools.size());
        System.out.println();
        SortingUtilities.quickSortSchool(filteredSchools, 0, filteredSchools.size() - 1);
        for (School s : filteredSchools) {
            System.out.println(s);
        }
    }
}