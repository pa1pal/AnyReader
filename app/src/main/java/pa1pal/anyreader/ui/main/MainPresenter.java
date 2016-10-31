package pa1pal.anyreader.ui.main;

import android.content.Context;

import java.util.List;

import pa1pal.anyreader.injection.DataManager;
import pa1pal.anyreader.model.News;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by pa1pal on 19/10/16.
 */

public class MainPresenter implements MainContract.Presenter {

    private static final String TAG = MainPresenter.class.getSimpleName();
    private Subscription subscription;
    private MainContract.View view;
    private DataManager dataManager;
    private MainAdapter mainAdapter;
    private Context context;

    public MainPresenter(DataManager dataManager, MainContract.View view){
        this.dataManager = dataManager;
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void loadPost() {
        subscription = dataManager.getNews()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<News>>() {
                    @Override
                    public void onCompleted() {
                       view.showComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.toString());
                    }

                    @Override
                    public void onNext(List<News> events) {
                        view.setUpAdapter(events);
                    }
                });

    }

    @Override
    public void subscribe() {
        loadPost();
    }

    @Override
    public void unsubscribe() {
        if (subscription != null && subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }
    }
}
