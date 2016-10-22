package pa1pal.anyreader.ui.main;

import java.util.List;

import pa1pal.anyreader.R;
import pa1pal.anyreader.data.DataManager;
import pa1pal.anyreader.data.News;
import pa1pal.anyreader.ui.base.BasePresenter;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by aosp on 19/10/16.
 */

public class MainPresenter extends BasePresenter<MainContract.View>
    implements MainContract.Presenter{

    private final DataManager mDataManager;
    private final CompositeSubscription mSubscriptions;

    public MainPresenter(DataManager dataManager) {
        this.mDataManager = dataManager;
        mSubscriptions = new CompositeSubscription();
    }

    @Override
    public void attachView(MainContract.View mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void loadEvent() {
        checkViewAttached();
        getMvpView().showProgressbar(true);
        mSubscriptions.add(mDataManager.getNews()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<List<News>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getMvpView().showProgressbar(false);
                        getMvpView().showError(R.string.error_occurred_to_load_events);
                    }

                    @Override
                    public void onNext(List<News> news) {
                        getMvpView().showProgressbar(false);
                        getMvpView().showNews(news);
                    }
                })
        );
    }
}
