package whitechurchapplication.sig.mvp.view.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import whitechurchapplication.sig.R;
import whitechurchapplication.sig.mvp.presenter.SplashContract;
import whitechurchapplication.sig.mvp.presenter.SplashPresenterImpl;
import whitechurchapplication.sig.mvp.view.main.MainActivity;

import static whitechurchapplication.sig.R.id.imageView;

public class SplashActivity extends AppCompatActivity implements SplashContract.SplashView {

    private SplashContract.SplashPresenter mSplashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        this.mSplashPresenter = new SplashPresenterImpl(this);
        mSplashPresenter.setView(this);
        getLocation();


    }

    public void getLocation() {
        if(mSplashPresenter != null)
        mSplashPresenter.startSync();

    }

    @Override
    public void ShowMessage(String massage) {

    }

    @Override
    public void dataWasSaved() {
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
    }

    @Override
    public void setView(SplashActivity splashActivity) {

    }

    @Override
    protected void onDestroy() {
        if(mSplashPresenter != null)
            mSplashPresenter.setView(null);
        super.onDestroy();
    }
}

