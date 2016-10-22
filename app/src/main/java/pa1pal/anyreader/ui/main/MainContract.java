package pa1pal.anyreader.ui.main;

import java.util.List;

import pa1pal.anyreader.data.News;
import pa1pal.anyreader.ui.base.MvpView;

/**
 * Created by aosp on 19/10/16.
 */

public class MainContract {
    interface View extends MvpView {

        void setUpRecyclerView();

        void showNews(List<News> news);

        void showError(int errorMessage);

        void showProgressbar(boolean show);
    }

    interface Presenter {
        void loadEvent();

    }
}
