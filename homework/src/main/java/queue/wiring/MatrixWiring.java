package queue.wiring;

import queue.myqueue.LinkQueue;
import queue.myqueue.Node;
import util.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class MatrixWiring {
    public List<Coordinate> findPath(String[][] matrix){
        List<Coordinate> answer = new ArrayList<Coordinate>();
        boolean isFindStart = true;
        int y ;
        int x ;
        LinkQueue<Coordinate> queue = new LinkQueue<Coordinate>();
        Node<Coordinate>[][] nodeMatrix = new Node[matrix.length][matrix[1].length];
        Coordinate coordinate;
        Coordinate tmpCoordinate;
        Node<Coordinate> node;
        Node<Coordinate> tmpNode;

        findOrigin(matrix, isFindStart, 0, 0, queue, nodeMatrix);

        while(true){
            coordinate = queue.deQueue();
            x = coordinate.getxCoordinate();
            y = coordinate.getyCoordinate();
             node = nodeMatrix[y][x];
             if("B".equals(matrix[y][x])){
                 Node<Coordinate> tmp = nodeMatrix[y][x];
                 while (tmp!=null){
                     answer.add(tmp.getValue());
                     tmp=tmp.getFather();
                 }
                 return answer;
             }
            if(x-1>=0&&matrix[y][x-1]!="1"){
                findWay(y, x-1, queue, nodeMatrix, nodeMatrix[y][x]);
            }
            if(y-1>=0&&matrix[y-1][x]!="1"){
                findWay(y-1, x, queue, nodeMatrix, nodeMatrix[y][x]);
            }
            if(y+1<matrix.length&&matrix[y+1][x]!="1"){
                findWay(y+1, x, queue, nodeMatrix, nodeMatrix[y][x]);
            }
            if(x+1<matrix.length&&matrix[y][x+1]!="1"){
                findWay(y, x+1, queue, nodeMatrix, nodeMatrix[y][x]);
            }
        }
    }

    private void findWay(int y, int x, LinkQueue<Coordinate> queue, Node<Coordinate>[][] nodeMatrix, Node<Coordinate> node) {
        Coordinate tmpCoordinate;
        Node<Coordinate> tmpNode;
        tmpCoordinate = new Coordinate(x,y);
        tmpNode = new Node<Coordinate>(tmpCoordinate);
        tmpNode.setLabel(node.getLabel()+1);
        tmpNode.setFather(node);
        if (nodeMatrix[y][x]==null){
            queue.enQueue(tmpCoordinate);
            nodeMatrix[y][x] = tmpNode;
        }else{
            if(tmpNode.getLabel()< nodeMatrix[y][x].getLabel()){
                nodeMatrix[y][x] = tmpNode;
                queue.enQueue(tmpCoordinate);
            }
        }
    }

    private void findOrigin(String[][] matrix, boolean isFindStart, int y, int x, LinkQueue<Coordinate> queue, Node<Coordinate>[][] nodeMatrix) {
        while(isFindStart&&y<matrix.length){
            if(x>=matrix[y].length){
                x=0;
            }
            while(isFindStart&&x<matrix[y].length){
                if("A".equals(matrix[y][x])){
                    isFindStart=false;
                }
                if (isFindStart){
                    x++;
                }
            }
            if (isFindStart){
                y++;
            }
        }
        Coordinate coordinate = new Coordinate(x,y);
        queue.enQueue(coordinate);
        nodeMatrix[y][x] = new Node<Coordinate>(coordinate);
        nodeMatrix[y][x].setLabel(0);

    }


}
