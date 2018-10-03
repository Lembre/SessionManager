package util;

import entity.User;

import java.util.ArrayList;

/**
 * Created by Lembre on 2018.5.8
 */
public class SessionUtil {
    //将增加在线人数的方法封装成一个独立的类，方法是静态的，方便直接调用
    public static Object getUserBySessionId(ArrayList<User> userList,String sessionIdString) {
        for (int i = 0; i < userList.size() ; i++) {
            User user = userList.get(i);
            if (user.getSessionIdString().equals(sessionIdString))
            {
                return user;
            }
        }
        return null;
    }
}
