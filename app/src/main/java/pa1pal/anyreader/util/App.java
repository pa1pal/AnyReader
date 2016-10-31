package pa1pal.anyreader.util;

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

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .dataModule(new DataModule("https://dl.dropboxusercontent.com/"))
                .build();
    }

    public static AppComponent getAppComponent() {
        return mAppComponent;
    }

}
