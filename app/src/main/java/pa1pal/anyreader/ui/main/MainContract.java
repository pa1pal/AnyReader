package pa1pal.anyreader.ui.main;

import pa1pal.anyreader.ui.base.BasePresenter;
import pa1pal.anyreader.ui.base.BaseView;

/**
 * Created by aosp on 19/10/16.
 */

public class MainContract {
    interface View extends BaseView<Presenter> {

        void setUpRecyclerView();

        //void showPosts(List<Post> posts);


        //void showProgressbar(boolean show);
    }

    interface Presenter extends BasePresenter{
        void loadPost();

    }
}
