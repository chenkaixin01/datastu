package tree.heap;

import util.Node;

import java.util.List;

public interface MinHeap<T> {

    /**
     * 往最小堆中插入元素
     * @param value 值
     * @return 返回是否成功
     */
    boolean insert(int key,T value );

    /**
     * 删除元素
     * @param key 键，权值
     * @return 返回是否成功
     */
    boolean removeByKey(int key);

    /**
     * 根据键获取值
     * @param key 键
     * @return 值
     */
    List<T> getValueByKey(int key);

    /**
     * 根据键获取实体
     * @param key 键
     * @return 实体
     */
    List<Node<T>> getEntryByKey(int key);

    /**
     * 取出堆顶，并删除
     * @return 值
     */
    T popTopValue();

    /**
     * 取出堆顶实体Node<T>,并删除
     * @return Node
     */
    Node<T> popTopEntry();

    /**
     * 取出堆顶的值，不删除
     * @return 值
     */
    T getTopVlue();

    /**
     * 取出堆顶的实体
     * @return 实体
     */
    Node<T> getTopEntry();

    /**
     * 判断是否为null；
     * @return 返回是否为空
     */
    boolean isEmpty();

    /**
     *
     * @return 堆中现有的元素的数目
     */
    int getLength();

    /**
     * 查询全部值
     * @return 装有所有元素的List
     */
    List<T> selectAll();
}
