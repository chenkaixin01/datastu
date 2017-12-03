package queue.myqueue;

public class Main {
    public static void main(String[] args) {
        SeqQueue<Character> queue = new SeqQueueImpl<Character>(5);
        System.out.println("判断队空：" + queue.isEmpty());
        System.out.println("出队：" + queue.deQueue() == null);
        System.out.println("入队：" + queue.enQueue('A'));
        System.out.println("入队：" + queue.enQueue('B'));
        System.out.println("入队：" + queue.enQueue('C'));
        System.out.println("入队：" + queue.enQueue('D'));
        System.out.println("入队：" + queue.enQueue('E'));
        System.out.println("入队：" + queue.enQueue('F'));
        System.out.println("判队满：" + queue.isFill());
        System.out.println("取队头：" + queue.peep());
        System.out.println("元素个数：" + queue.length());

    }
}
