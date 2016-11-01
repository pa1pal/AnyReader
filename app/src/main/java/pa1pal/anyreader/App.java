package pa1pal.anyreader;

import android.app.Application;

import pa1pal.anyreader.injection.component.AppComponent;
import pa1pal.anyreader.injection.component.DaggerAppComponent;
import pa1pal.anyreader.injection.module.AppModule;
import pa1pal.anyreader.injection.module.DataModule;

/**
 * User: pa1pal
 * Date: 10/31/16
 */
public class App extends Application{
    private static AppComponent mAppComponent;

    private static App mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .dataModule(new DataModule("https://gist.githubusercontent.com/"))
                .build();
    }

    public static synchronized App getInstance() {
        return mInstance;
    }


    public static AppComponent getAppComponent() {
        return mAppComponent;
    }

}
