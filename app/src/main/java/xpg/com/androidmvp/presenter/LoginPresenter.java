package xpg.com.androidmvp.presenter;

import android.os.Handler;

import xpg.com.androidmvp.model.OnloginListener;
import xpg.com.androidmvp.model.User;
import xpg.com.androidmvp.model.UserBiz;
import xpg.com.androidmvp.model.iUserBiz;
import xpg.com.androidmvp.view.IView;

/**
 * Created by Administrator on 2016/9/4.
 * 
 * 用于 model和view的交互
 */
public class LoginPresenter {
    
    private iUserBiz userBiz;
    private IView view;
    private Handler mHandler = new Handler();

    public LoginPresenter(IView view) {
        this.view = view;
        this.userBiz = new UserBiz();
    }
    
    public void doLogin(){
        view.showDialog();
        userBiz.dologin(view.getUsername(), view.getPassword(), new OnloginListener() {
            @Override
            public void onSuccessed(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        view.toMainActivity(user);
                        view.hideDialog();
                    }
                });
            }

            @Override
            public void onFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        view.showFailedActivity();
                        view.hideDialog();
                    }
                });
            }
        });
    }
    
}
