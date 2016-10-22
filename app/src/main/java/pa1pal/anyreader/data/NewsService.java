package pa1pal.anyreader.data;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * User: pa1pal
 * Date: 10/22/16
 */
public interface NewsService {
    @GET("u/231329/xyzreader_data/data.json")
    Observable<List<News>> getNews();
}
