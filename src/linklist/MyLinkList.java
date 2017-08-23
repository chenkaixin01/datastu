package linklist;
/**
 * 
 * @author chenkaixin
 *
 */
public interface MyLinkList {
    /**
     * 往单链表中添加数据
     * @param data 加入的数据
     */
    public void add(int data);
    /**
     * 根据索引删除数据
     * @param index 索引
     * @return
     */
    public boolean delete(int index);
    /**
     * 在索引指向的节点后插入数据
     * @param index 索引
     * @param data 数据
     * @return
     */
    public boolean insert(int index,int data);
/**
 * 查询链表中的所有数据
 */
    public void selectAll();
    /**
     * 根据索引查询数据
     * @param index
     */
    public void selectIndex(int index);
    /**
     * 链表的长度
     */
    public void length();
    
}
