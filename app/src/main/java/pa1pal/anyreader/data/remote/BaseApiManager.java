package pa1pal.anyreader.data.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import pa1pal.anyreader.data.NewsService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * User: pa1pal
 * Date: 10/22/16
 */
public class BaseApiManager {
    public static final String END_POINT = "https://dl.dropboxusercontent.com/";

    private static Retrofit mRetrofit;
    private static NewsService eventApi;

    public BaseApiManager() {
        createService();
    }

    public static void init() {
        eventApi = createApi(NewsService.class);
    }

    private static <T> T createApi(Class<T> clazz) {
        return mRetrofit.create(clazz);
    }

    OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build();

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            .create();

    private void createService() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(END_POINT)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
        init();
    }

    public NewsService getNewsApi() {
        return eventApi;
    }
}
