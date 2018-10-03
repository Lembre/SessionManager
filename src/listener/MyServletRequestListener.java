package listener;

import entity.User;
import util.SessionUtil;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Lembre on 2018.5.8
 */
@WebListener
public class MyServletRequestListener implements ServletRequestListener {

    //在线用户表List
    private ArrayList<User> userList;

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {

        userList = (ArrayList<User>)sre.getServletContext().getAttribute("userList");

        if(userList == null)
        {
            userList = new ArrayList<User>();
        }

        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        String sessionIdString = request.getSession().getId();

        if(SessionUtil.getUserBySessionId(userList,sessionIdString) == null)
        {
            User user = new User();
            user.setSessionIdString(sessionIdString);
            user.setFirstTimeString(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            user.setIpString(request.getRemoteAddr());
            userList.add(user);
        }
        sre.getServletContext().setAttribute("userList",userList);
    }

}
/*监听器是Servlet规范中一种特殊类
监听器总结： 一监听器分类 在Servlet规范中定义了多种类型的监听器，它们用于监听的事件源分别为
SerlvetConext,HttpSession和ServletRequest这三个域对象。 Servlet规范针对这三个对象上的操作，
又把这多种类型的监听器划分为三种类型： 1>监听三个域对象创建和销毁的事件监听器 2>监听域对象中属性的增加和删除的事件监听器
 3>监听绑定到HttpSession域中的某个对象的状态的时间监听器。*/

/*感知型监听器（2个）属于第三种：监听自己何时被帮到session上，何时解绑；何时被钝化，何时被活化(序列化到某个存储设置中)。
 注意：这种监听器不需要注册。某个javabean实现这些接口后就可以监听何时被绑定、解绑或被激活或钝化。
  HttpSessionBindingListener：实现该接口的类，能检测自己何时被Httpsession绑定和
  解绑 HttpSessionActivationListener：实现该接口的类(要求些javabean必须是实现了Serializable接口的)，
  能监测自己何时随着HttpSession一起激活和钝化。*/
