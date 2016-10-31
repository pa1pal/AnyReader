package pa1pal.anyreader.ui.detail;

import java.util.List;

import pa1pal.anyreader.model.News;
import pa1pal.anyreader.ui.base.BasePresenter;
import pa1pal.anyreader.ui.base.BaseView;

/**
 * User: pa1pal
 * Date: 10/31/16
 */
public class DetailsContract {

    interface View extends BaseView<Presenter> {

        void showError(String message);

        void setUpDetails(List<News> list);
    }

    interface Presenter extends BasePresenter {

    }

}
