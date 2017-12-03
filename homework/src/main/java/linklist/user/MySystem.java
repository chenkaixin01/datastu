package linklist.user;

import linklist.list.LinkList;
import linklist.list.LinkListImpl;

import java.util.List;

public class MySystem {
    LinkList<User> list = new LinkListImpl<User>();
    private boolean login(User user){

        return list.add(user);
    }
    private boolean logout(User user){
        List<User> users = list.selectAll();
        int i = 0;
        for (User user1: users) {
            if(user1.equals(user)){
                list.delete(i);
                return true;
            }
            i++;
        }
        return false;
    }
}
