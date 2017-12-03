package stack.maze;

import util.Coordinate;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[][] maze =
                {
                        {"A","1","1","0","0","0","0"},
                        {"0","0","1","1","0","0","0"},
                        {"1","0","0","0","1","0","B"},
                        {"0","0","0","1","1","0","1"},
                        {"1","0","0","0","1","0","1"},
                        {"1","1","1","0","0","0","0"},
                        {"1","1","1","1","1","0","0"}
                };
        Maze ansMaze = new Maze();
        List<List<Coordinate>> answers = ansMaze.answerMaze(maze);
        System.out.println(answers.size());
        for (List<Coordinate> answer:answers) {
                for (Coordinate coordinate: answer) {
                    System.out.printf(coordinate.toString());
                }
            System.out.print("\n");
        }
    }
}
