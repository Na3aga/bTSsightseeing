package whitechurchapplication.sig.mvp.view.splash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import whitechurchapplication.sig.R;
import whitechurchapplication.sig.mvp.presenter.SplashContract;

public class SplashActivity extends AppCompatActivity implements SplashContract.SplashView {

    private SplashContract.SplashPresenter mSplashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getLocation();
    }

    public void getLocation() {
       mSplashPresenter.startSync();
    }

    @Override
    public void ShowMessage(String massage) {

    }

    @Override
    public void setView(SplashActivity splashActivity) {

    }
}

