package tree.binary;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Binary bnryTree = new BinaryImpl();
        StringBuilder strBuf = new StringBuilder ();
        Scanner input = new Scanner(System.in);
        System.out.println("--------输入数字，输入-1结束————————");
        int key;
        while (true){
            key = input.nextInt();
            if(key<0){
                break;
            }
            bnryTree.add(key);
            strBuf.append(key);
            strBuf.append(",");
        }
        System.out.println("————————————————————————插入二叉树的数据————————————————————————");
        System.out.println(strBuf.toString());
        List<Integer> preList = bnryTree.preOrder();
        System.out.println("——————————————————————————前序遍历输出——————————————————————————");
        for (Integer pre:preList) {
            System.out.print(pre+",");
        }
        System.out.print("\n");

        List<Integer> inList = bnryTree.inOrder();
        System.out.println("——————————————————————————中序遍历输出——————————————————————————");
        for (Integer in:inList) {
            System.out.print(in+",");
        }
        System.out.println("\n");
        List<Integer> postList = bnryTree.postOrder();
        System.out.println("——————————————————————————后序遍历输出——————————————————————————");
        for (Integer post:postList) {
            System.out.print(post+",");
        }
        System.out.println("\n");
        List<Integer> levelList = bnryTree.levelOrder();
        System.out.println("——————————————————————————层次遍历输出——————————————————————————");
        for (Integer level:levelList) {
            System.out.print(level+",");
        }
        System.out.println("\n");
    }
}
