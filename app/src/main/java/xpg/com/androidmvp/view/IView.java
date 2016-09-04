package xpg.com.androidmvp.view;

import xpg.com.androidmvp.model.User;

/**
 * Created by Administrator on 2016/9/4.
 */
public interface IView {
    
    String getUsername();
    String getPassword();
    void showDialog();
    void hideDialog();
    void toMainActivity(User user);
    void showFailedActivity();
}
