package pa1pal.anyreader.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pa1pal.anyreader.R;
import pa1pal.anyreader.model.News;
import pa1pal.anyreader.util.ImageLoaderHelper;

/**
 * User: pa1pal
 * Date: 10/31/16
 */
public class DetailsActivity extends AppCompatActivity implements DetailsContract.View{

    @BindView(R.id.flagimage)
    ImageView flagImage;

    @BindView(R.id.newstitle)
    TextView newsTitle;

    @BindView(R.id.newstime)
    TextView newsTime;

    @BindView(R.id.newsauthor)
    TextView newsAuthor;

    @BindView(R.id.newsdetails)
    TextView newsDetails;

    ImageLoader imageLoader;
    private News news;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        imageLoader = ImageLoaderHelper.getInstance(this).getImageLoader();
        //getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_share_white_24dp);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Intent intent = this.getIntent();
        news = (new Gson()).fromJson(intent.getStringExtra("list"), News.class);
        setUpDetails(news);
    }

    @OnClick(R.id.share)
    public void Share() {
        startActivity(Intent.createChooser(ShareCompat.IntentBuilder.from(this)
                .setType("text/plain")
                .setText("Some sample text")
                .getIntent(), getString(R.string.action_share)));
    }

    @Override
    public void setUpDetails(News news) {
        imageLoader.get(news.getThumb(), ImageLoader.getImageListener(flagImage, R.mipmap.ic_launcher, R.mipmap.ic_error_outline_black_24dp));
        newsTitle.setText(news.getTitle());
        newsTime.setText(news.getPublishedDate());
        newsAuthor.setText(getString(R.string.by)+news.getAuthor());
        newsDetails.setText(news.getBody());
    }

}
