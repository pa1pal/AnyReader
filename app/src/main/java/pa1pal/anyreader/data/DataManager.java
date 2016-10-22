package pa1pal.anyreader.data;

import java.util.List;

import javax.inject.Singleton;

import pa1pal.anyreader.data.remote.BaseApiManager;
import rx.Observable;

/**
 * Created by Rajan Maurya on 08/09/16.
 */
@Singleton
public class DataManager {

    private final BaseApiManager mBaseApiManager;

    public DataManager( BaseApiManager baseApiManager) {
        mBaseApiManager = baseApiManager;
    }

    public Observable<List<News>> getNews() {
        return mBaseApiManager.getNewsApi().getNews();
    }
}
