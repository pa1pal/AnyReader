package pa1pal.anyreader.ui.main;

import java.util.List;

import pa1pal.anyreader.model.News;
import pa1pal.anyreader.ui.base.BasePresenter;
import pa1pal.anyreader.ui.base.BaseView;

/**
 * Created by aosp on 19/10/16.
 */

public class MainContract {
    interface View extends BaseView<Presenter> {

        void setUpRecyclerView();

        void showError(String message);
        //void showPosts(List<Post> posts);
        void showComplete();

        void setUpAdapter(List<News> list);
        //void showProgressbar(boolean show);
    }

    interface Presenter extends BasePresenter{
        void loadPost();

    }
}
