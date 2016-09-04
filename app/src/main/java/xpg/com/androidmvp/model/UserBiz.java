package xpg.com.androidmvp.model;

/**
 * Created by Administrator on 2016/9/4.
 */
public class UserBiz implements iUserBiz {
    //模拟登录耗时操作
    @Override
    public void dologin(final String username, final String password, final OnloginListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("gxp".equals(username) && "123".equals(password)) {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    listener.onSuccessed(user);
                } else {
                    listener.onFailed();
                }
            }
        }).start();
    }
}
