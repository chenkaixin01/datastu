package stack.maze;

import stack.mystack.Node;
import stack.mystack.Stack;
import util.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    
    public List<List<Coordinate>> answerMaze(String[][] maze){
        List<List<Coordinate>> answers = new ArrayList<List<Coordinate>>();
        Stack<Coordinate> stack = new Stack<Coordinate>();

        int x=0;
        int y=0;
        solving(answers,stack,x,y,maze);
        return answers;
    }

    /**
     * 递归寻找路径的过程
     * @param answers ：解的集合
     * @param stack ：使用的特性解，并得到解后存入list
     * @param x ：X坐标
     * @param y ：Y坐标
     * @param maze：迷宫
     */
    private void solving(List<List<Coordinate>> answers,  Stack<Coordinate> stack, int x, int y, String[][] maze) {
      //深度优先遍历时当新产生的坐标已经存在栈中，则说明这个点已经经过，所以回退一层，避免死循环
        Coordinate newCoordinate =  new Coordinate(x,y);
        Node<Coordinate> tmp = stack.peek();
        while (tmp!=null){
            if(tmp.getValue().equals(newCoordinate)){
                return;
            }
            tmp=tmp.getNext();
        }

        stack.push(new Coordinate(x,y));
//       当找到"B"时成功找到一条路径存入结果集合
        if("B".equals(maze[y][x])){
            answers.add(stack.readAll());
            stack.pop();
            return;
        }
//       向4个方向探索
        if((x-1)>=0&& !maze[y][x - 1].equals ("1")){
            solving(answers,stack,x-1,y,maze);
        }
        if(x+1<maze[1].length&& !maze[y][x + 1].equals ("1")){
            solving(answers,stack,x+1,y,maze);
        }
        if((y-1)>0&& !maze[y - 1][x].equals ("1")){
            solving(answers,stack,x,y-1,maze);
        }
        if(y+1<maze.length&&maze[y+1][x]!="1"){
            solving(answers,stack,x,y+1,maze);
        }
//      这一层递归结束要出栈一个
        stack.pop();
    }
}
