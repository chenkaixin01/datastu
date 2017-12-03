package stack.mystack;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
    private Node<T> top;
    private int size = 0;

    /**
     * @return 返回栈的大小
     */
    public int getSize() {
        return this.size;
    }

    /**
     * @return 判断是否为空
     */
    public boolean isEmpty() {
        return this.top != null;
    }

    /**
     * 入栈
     *
     * @param value 值
     */
    public boolean push(T value) {
        Node<T> newNode = new Node<T>(value);
        if (this.top == null) {
            top = newNode;
            this.size++;
            return true;
        }
        newNode.next = top;
        top = newNode;
        this.size++;
        return true;
    }

    /**
     * 获取栈元素，出栈
     *
     * @return 栈顶元素
     */
    public T pop() {
        if (top == null) {
            return null;
        }
        Node<T> tem = top;
        top = tem.next;
        this.size--;
        return tem.value;

    }

    /**
     * 获取栈元素，不出栈
     *
     * @return 节点
     */
    public Node<T> peek() {

        return top;

    }

    /**
     * 全部出栈
     */
    public void selectAll(){
        T tem;
        while(true){
            tem = pop();
            if(tem == null){
                break;
            }
            System.out.print(tem);
        }
    }


    public List<T> readAll(){
        Node<T> tem = top;
        List<T> list= new ArrayList<T>();
        if(top==null){
            return null;
        }

        while (tem!=null){
            list.add(tem.value);
            tem = tem.next;
        }
        return list;
    }
}
