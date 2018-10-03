package listener;

import entity.User;
import util.SessionUtil;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;

/**
 * Created by Lembre on 2018.5.8
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

    private int userNumber = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        userNumber++;
        se.getSession().getServletContext().setAttribute("userNumber", userNumber);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        userNumber--;
        se.getSession().getServletContext().setAttribute("userNumber", userNumber);

        ArrayList<User> userList = null;
        userList = (ArrayList<User>) se.getSession().getServletContext().getAttribute("useList");
        if(SessionUtil.getUserBySessionId(userList, se.getSession().getId())!= null)
        {
            userList.remove(SessionUtil.getUserBySessionId(userList,se.getSession().getId()));
        }
    }
}
/*1.先 使用MyHttpSessionListener 接口 HttpSessionListener
每次新建一个session 获取sessionId 统计在线人数
2.MyServletRequestListener 接口 ServletRequestListener
每打开一个页面 即创建
通过request获取ip地址 创建时间 保存在userList
3.SessionUtil 判断两个sessionId是否相同
4.将userList保存在ServletContext（application）*/
