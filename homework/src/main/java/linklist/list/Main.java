package linklist.list;

import linklist.list.LinkList;
import linklist.list.LinkListImpl;

public class Main {
    public static void main(String[] args) {
        LinkList<Character> my = new LinkListImpl();
        my.add('g');
        my.add('3');
        my.add('8');
        my.add('6');
        my.add('1');
        my.add('6');
        my.selectAll();
        my.length();
        System.out.println("=====================================");
        System.out.printf("插入操作之后");
        my.insert(3, 'p');
        my.selectAll();
        my.length();
        System.out.println("++++++++++++++++++");
        System.out.printf("删除之后");
        my.delete(3);
        my.selectAll();
        my.length();
        // my.selectIndex(4);
    }
}
