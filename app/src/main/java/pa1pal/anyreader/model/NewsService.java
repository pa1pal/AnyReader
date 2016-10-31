package pa1pal.anyreader.model;

import java.util.List;

import rx.Observable;

/**
 * User: pa1pal
 * Date: 10/30/16
 */
public interface NewsService {
    Observable<List<News>> getPost();
}
