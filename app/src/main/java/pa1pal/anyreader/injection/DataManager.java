package pa1pal.anyreader.injection;

import java.util.List;

import javax.inject.Inject;

import pa1pal.anyreader.model.News;
import pa1pal.anyreader.model.NewsService;
import pa1pal.anyreader.util.App;
import retrofit2.Retrofit;
import rx.Observable;

/**
 * User: pa1pal
 * Date: 10/30/16
 */
public class DataManager {

    @Inject
    Retrofit retrofit;

    @Inject
    public DataManager(){
        App.getAppComponent().inject(this);
    }

    public Observable<List<News>> getNews() {
        return retrofit.create(NewsService.class).getPost();
    }
}

