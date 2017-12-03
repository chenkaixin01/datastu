package tree.heap;

import java.util.List;

public interface MinHeap {

    /**
     * 往最小堆中插入元素
     * @param value 值
     * @return 返回是否成功
     */
    boolean insert(int value );

    /**
     * 删除元素
     * @param value 元素
     * @return 返回是否成功
     */
    boolean remove(int value);

    /**
     * 删除最小的
     * @return 返回是否成功
     */
    boolean removeMin();

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
     * 查找某个
     * @param key 键
     * @return 值
     */
    int selectByKey(int key);

    /**
     * 查询全部
     * @return 装有所有元素的List
     */
    List<Integer> selectAll();
}
