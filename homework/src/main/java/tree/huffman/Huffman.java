package tree.huffman;

import tree.heap.MinHeap;
import util.Node;

import java.util.Map;

public interface Huffman<T> {

    /**
     * 传入键值对，初始化哈夫曼树
     * @param key: 以键值作为哈夫曼树的权值
     * @param value: 值
     */
    void putForest(int key,T value);

    /**
     * 取得哈夫曼树
     * @return 哈夫曼树
     */
    Node<T> getHuffmanTree();

}
