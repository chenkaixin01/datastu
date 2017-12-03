package queue.wiring;

import util.Coordinate;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[][] matrix =
                {
                        {"0","0","1","0","0","0","0"},
                        {"0","0","1","1","0","0","0"},
                        {"0","A","0","0","1","0","0"},
                        {"0","0","0","1","1","B","0"},
                        {"1","0","0","0","1","0","0"},
                        {"1","1","1","0","0","0","0"},
                        {"1","1","1","0","0","0","0"}

                };
        MatrixWiring wiring = new MatrixWiring();
        List<Coordinate> answer = wiring.findPath(matrix);
        for (Coordinate coordinate:answer) {
            System.out.print(coordinate.toString());
        }
    }
}
