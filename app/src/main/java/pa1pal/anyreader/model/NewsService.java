package pa1pal.anyreader.model;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * User: pa1pal
 * Date: 10/30/16
 */
public interface NewsService {
    @GET("pa1pal/ee8d54cc5b35c7747fc5e6256f2788a8/raw/2d6ac627e55e55087e8e774abd632cd8441c1482/data.json")
    Observable<List<News>> getPost();
}
