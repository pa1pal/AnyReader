package pa1pal.anyreader.injection.component;

import javax.inject.Singleton;

import dagger.Component;
import pa1pal.anyreader.injection.DataManager;
import pa1pal.anyreader.injection.module.AppModule;
import pa1pal.anyreader.injection.module.DataModule;
import pa1pal.anyreader.ui.main.MainActivity;
import pa1pal.anyreader.ui.main.MainActivityFragment;

/**
 * User: pa1pal
 * Date: 10/22/16
 */

@Singleton
@Component(modules = {AppModule.class, DataModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
    void inject(MainActivityFragment activityFragment);
    void inject(DataManager dataManager);
}
