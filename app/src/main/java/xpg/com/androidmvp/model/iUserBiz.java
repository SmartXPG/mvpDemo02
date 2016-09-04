package xpg.com.androidmvp.model;

/**
 * Created by Administrator on 2016/9/4.
 */
public interface iUserBiz {
    
    void dologin(String username,String password,OnloginListener listener);
}
