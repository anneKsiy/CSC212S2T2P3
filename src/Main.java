/* Created by 3935415 Abdullah Adam on 2020/09/25
 * www.github.com/anneKsiy
 * Main class containing psvm to complete project spec
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
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
        ShortestPath sp = new ShortestPath();
        int[] output = sp.dijkstra(matrix, 78);
        String[] source = {newSchoolArr.get(78).getName(),
                newSchoolArr.get(78).getName(),
                newSchoolArr.get(123).getName(),
                newSchoolArr.get(123).getName(),
                newSchoolArr.get(60).getName(),
                newSchoolArr.get(60).getName()
        };
        String[] destination = {newSchoolArr.get(36).getName(),
                newSchoolArr.get(63).getName(),
                newSchoolArr.get(130).getName(),
                newSchoolArr.get(105).getName(),
                newSchoolArr.get(100).getName(),
                newSchoolArr.get(33).getName()
        };
        System.out.println("From: " + newSchoolArr.get(78) + " to: " + newSchoolArr.get(36) + " is " + output[36] + " Km");
        int val1 = output[36];
        System.out.println("From: " + newSchoolArr.get(78) + " to: " + newSchoolArr.get(63) + " is " + output[63] + " Km");
        int val2 = output[63];
        output = sp.dijkstra(matrix, 123);
        System.out.println("From: " + newSchoolArr.get(123) + " to: " + newSchoolArr.get(130) + " is " + output[130] + " Km");
        int val3 = output[130];
        System.out.println("From: " + newSchoolArr.get(123) + " to: " + newSchoolArr.get(105) + " is " + output[105] + " Km");
        int val4 = output[105];
        output = sp.dijkstra(matrix,60);
        System.out.println("From: " + newSchoolArr.get(60) + " to: " + newSchoolArr.get(100) + " is " + output[100] + " Km");
        int val5 = output[100];
        System.out.println("From: " + newSchoolArr.get(60) + " to: " + newSchoolArr.get(33) + " is " + output[33] + " Km");
        int val6 = output[33];
        int[] values = {val1, val2, val3, val4, val5, val6};
        CsvUtilities.generateCSV("Output.txt", source, destination, values);
    }
}
