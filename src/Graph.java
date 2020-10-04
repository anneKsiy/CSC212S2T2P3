/* Created by 3935415 Abdullah Adam on 2020/09/25
 * www.github.com/anneKsiy
 * Class which contains the Graph structure as well as the following methods:
 * void addEdge(int v, int w)
 * ArrayList<Integer> breadthFirstSearch(int s)
 * ArrayList<Integer> depthFirstSearch(int v)
 * void depthFirstSearchUtil(int v, boolean visited[], ArrayList<Integer> traversalPath)
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Created by 3935415 Abdullah Adam on 2020/09/19
 * www.github.com/anneKsiy
 * Class which parses the CSV File into a 2-dimensional array
 */
public class Graph {
    private List<School> V; // Vertices
    public LinkedList<Edge> adj[]; // Adjacency Lists
    private int size;

    // Constructor
    Graph(List<School> v) {
        V = v;
        adj = new LinkedList[v.size()];
        for (int i = 0; i < v.size(); i++)
            adj[i] = new LinkedList<>();
        int size = v.size();
    }

    static class Edge {
        School source;
        School destination;
        double weight;

        public Edge(School source, School destination, double weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    // Method to get the edge weight between Schools
    void createFiltered(School a, School b) {
        if (Math.sqrt(Math.pow(Float.parseFloat(a.getLng()), 2) * Math.pow(Float.parseFloat(a.getLat()), 2)) % 6 ==
            School.getNameLength(b) % 6 && Math.sqrt(Math.pow(Float.parseFloat(a.getLng()), 2) * Math.pow(Float.parseFloat(a.getLat()), 2)) % 6 ==
            Float.parseFloat(b.getRating())) {

        }
    }

    static List<School> filteredGenerator(List<School> s) {
        List<School> newSchoolList = new ArrayList<>();
        for (int i = 0; i < s.size(); i++) {
            for (int j = 0; j < s.size(); j++) {
                if (Math.floor(Math.sqrt(Math.pow(Double.parseDouble(s.get(i).getLat()), 2) * Math.pow(Double.parseDouble(s.get(i).getLng()), 2)) % 6) ==
                        s.get(j).getName().length() % 6 &&
                        Math.floor(Math.sqrt(Math.pow(Double.parseDouble(s.get(i).getLat()), 2) * Math.pow(Double.parseDouble(s.get(i).getLng()), 2)) % 6) ==
                        Double.parseDouble(s.get(j).getRating())) {
                    if (!newSchoolList.contains(s.get(i))) {
                        newSchoolList.add(s.get(i));
                    }
                    if (!newSchoolList.contains(s.get(j))) {
                        newSchoolList.add(s.get(j));
                    }
                }
            }
        }
            return newSchoolList;
        }

    // Method to determine the distance between 2 Schools using their longitude and latitude
    static double distanceCalculator(School a, School b) {
        double radius = 6371 * 1000;
        double latA = Double.parseDouble(a.getLat());
        double latB = Double.parseDouble(b.getLat());
        double lngA = Double.parseDouble(a.getLng());
        double lngB = Double.parseDouble(a.getLng());
        double dLat = (latB - latA) * Math.PI / 180;
        double dLng = (lngB - lngA) * Math.PI / 180;
        double val = Math.sin(dLat/2) * Math.sin(dLat/2) + Math.sin(dLng/2) * Math.sin(dLng/2) * Math.cos(latA) * Math.cos(latB);
        double ang = 2 * Math.atan2(Math.sqrt(val), Math.sqrt(1-val));
        return Math.floor(radius * ang);
    }

    // Method to add edge into the graph
    void addEdge(List<School> schools, School v, School w) {
        double weight = distanceCalculator(v, w);
        Edge edge = new Edge(v, w, weight);
        adj[schools.indexOf(v)].add(edge);
    }

    // Method to pretty print graph
    public void printGraph(List<School> schools) {
        for (int i = 0; i < V.size(); i++) {
            LinkedList<Edge> list = adj[i];
            for (int j = 0; j < list.size(); j++) {
                System.out.println("Vertex: " + i + " which is School: " + schools.get(i) + " is connected to: " +
                        list.get(j).destination + " with weight " + list.get(j).weight);
            }
        }
    }
}
