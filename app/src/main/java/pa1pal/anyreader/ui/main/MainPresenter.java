package pa1pal.anyreader.ui.main;

import rx.Subscription;

/**
 * Created by aosp on 19/10/16.
 */

public class MainPresenter implements MainContract.Presenter {

    private static final String TAG = MainPresenter.class.getSimpleName();
    private Subscription subscription;
    private MainContract.View view;

    public MainPresenter(MainContract.View view){
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void loadPost() {

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
