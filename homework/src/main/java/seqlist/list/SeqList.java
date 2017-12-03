package seqlist.list;

public interface SeqList<T> {
    /**
     * 清空顺序表
     * @return 返回一个空的数组
     */
    public abstract T[] enptyList();
    /**
     * 往顺序表中添加数据
     */
    public abstract void add(T t);

    /**
     * 在顺序表中第i个元素后插入一个元素
     * @return  加入成功返回加入元素后的以数组返回顺序表内的元素
     */
    public abstract T[] insertData(int i, T t);
    /**
     * 从顺序表中删除第i个元素
     * @return  删除后返回被删除元素
     */
    public abstract T deleteData(int i);
    /**
     * 查询顺序表内所有数据，以集合存储
     * @return 返回以数组返回顺序表内的元素
     */
    public abstract T[] selectAll();
    /**
     * 根据下标找元素
     * @return 一个元素
     */
    public abstract T selectData(int i);
    /**
     * 根据元素找到元素的位置
     * @return int
     */
    public abstract int selectIndex(T t);
    /**
     * 根据下标将该元素替换为参数元素
     * @return 返回被替换元素
     */
    public abstract T replaceData(int i, T t);
    /**
     * 顺序表的实际长度
     * @return int
     */
    public abstract int lenthList();
}
