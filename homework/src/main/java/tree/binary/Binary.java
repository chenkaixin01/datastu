package tree.binary;

import util.Node;

import java.util.List;

public interface Binary {
    /**
     * 向二叉树中加入元素
     * @param key：元素
     */
    void add(Integer key);

    /**
     * 删除元素
     * @param key 键值
     * @return 是否删除成功
     */
    boolean remove(Integer key);

    /**
     *
     * @return 输出二叉树的大小
     */
    int getSize();

    /**
     * 二叉树是否为空
     * @return boolean值
     */
    boolean isEmpty();

    /**
     *
     * @return 返回根节点
     */
    Node getRoot();

    /**
     *
     * @return 返回树高
     */
    int getHeight();

    /**
     * 查找某个元素
     * @param key 查找元素的键
     * @return 返回一个节点
     */
    Node findByKey(Integer key);

    /**
     * 前序遍历
     * @return 返回按顺序存储的List
     */
    List<Integer> preOrder();

    /**
     * 中序遍历
     * @return 返回按顺序存储的List
     */
    List<Integer> inOrder();

    /**
     * 后序遍历
     * @return 返回按顺序存储的List
     */
    List<Integer> postOrder();

    /**
     * 层序遍历
     * @return 返回按顺序存储的List
     */
    List<Integer> levelOrder();
}
