package queue.myqueue;

import java.util.List;

public interface SeqQueue<T> {

    /**
     * 判断队列是否为空
     */
    boolean isEmpty();
    /**
     * 判断队列是否已满
     * @return
     */
    boolean isFill();

    /**
     * 入队
     */
    boolean enQueue(T value);

    /**
     * 出队
     */
    T deQueue();

    /**
     * 查询队头，
     */
    T peep();

    /**
     * 全部出队
     */
    List<T> deQueueAll();

    /**
     * 查询全部队内元素
     */
    List<T> selectAll();

    /**
     * 查询队长
     */
    int length();
}
