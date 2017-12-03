package stack.mystack;

public class Main {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<Character>();
        System.out.println("判栈空：" + stack.isEmpty());
        boolean b = (stack.pop() != null);
        System.out.println("出栈：" + b);
        System.out.println("入栈：" + stack.push('A'));
        System.out.println("入栈：" + stack.push('B'));
        System.out.println("入栈：" + stack.push('C'));
        System.out.println("入栈：" + stack.push('D'));
        System.out.println("入栈：" + stack.push('E'));
        System.out.printf("取栈顶元素：" + stack.peek());
        System.out.print("连续出栈：" );
        stack.selectAll();
    }
}
