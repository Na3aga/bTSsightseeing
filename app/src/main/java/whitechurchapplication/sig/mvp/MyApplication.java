package whitechurchapplication.sig.mvp;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

public class MyApplication extends Application {

    Context context;

    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        LeakCanary.install(this);
    }

    public Context getApplicationContext(){
        return context;
    }


    public static RefWatcher getRefWatcher(Context context) {
        MyApplication application = (MyApplication) context;
        return application.refWatcher;
    }

}

