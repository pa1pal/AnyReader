package pa1pal.anyreader.ui.interfaces;

import java.util.List;

import pa1pal.anyreader.model.News;

/**
 * User: pa1pal
 * Date: 10/31/16
 */
public interface ItemClickCallback {
    void onItemSelected(List<News> news, int position);
}
