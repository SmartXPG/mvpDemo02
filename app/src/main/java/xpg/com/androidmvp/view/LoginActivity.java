package xpg.com.androidmvp.view;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import xpg.com.androidmvp.R;
import xpg.com.androidmvp.model.User;
import xpg.com.androidmvp.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements IView {

    private EditText email;
    private EditText pwsd;
    private Button loginBtn;
    private ProgressBar progressBar;
    private LoginPresenter loginPresenter;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (loginPresenter == null) {
            loginPresenter = new LoginPresenter(this);
        }
        initViews();
        initListener();
    }

    private void initListener() {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (loginPresenter != null)
                    loginPresenter.doLogin();
            }
        });
    }

    private void initViews() {
        email = (EditText) findViewById(R.id.email);
        pwsd = (EditText) findViewById(R.id.password);
        loginBtn = (Button) findViewById(R.id.email_sign_in_button);
        progressBar = (ProgressBar) findViewById(R.id.login_progress);
//        dialog = new ProgressDialog(this, ProgressDialog.STYLE_SPINNER);
//        dialog.setTitle("登录中");
    }

    @Override
    public String getUsername() {
        return email.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return pwsd.getText().toString().trim();
    }

    @Override
    public void showDialog() {
        progressBar.setVisibility(View.VISIBLE);
//        if (dialog != null)
//            dialog.show();
    }

    @Override
    public void hideDialog() {
        progressBar.setVisibility(View.GONE);
//        if (dialog != null && dialog.isShowing())
//            dialog.dismiss();
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, "跳转到首页", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedActivity() {
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
    }
}
