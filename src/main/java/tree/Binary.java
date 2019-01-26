package tree;

import java.util.List;

public interface Binary {
    void add(Integer obj);
    boolean remove(Integer obj);
    int getSize();
    boolean isEmpty();
    Node getRoot();
    int getHeight();
    Node find(Integer e);
    List<Integer> preOrder();
    List<Integer> inOrder();
    List<Integer> postOrder();
    List<Integer> levelOrder();
}
