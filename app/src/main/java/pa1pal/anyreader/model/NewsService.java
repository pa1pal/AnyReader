package pa1pal.anyreader.model;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * User: pa1pal
 * Date: 10/30/16
 */
public interface NewsService {
    @GET("u/231329/xyzreader_data/data.json")
    Observable<List<News>> getPost();
}
