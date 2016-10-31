package pa1pal.anyreader.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import pa1pal.anyreader.R;
import pa1pal.anyreader.model.News;

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

    private News news;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        final Intent intent = this.getIntent();
        news = (new Gson()).fromJson(intent.getStringExtra("list"), News.class);
        setUpDetails(news);
    }

    @Override
    public void setUpDetails(News news) {

        Picasso.with(this)
                .load(news.getThumb())
                .into(flagImage);

        newsTitle.setText(news.getTitle());
        newsTime.setText(news.getPublishedDate());
        newsAuthor.setText(getString(R.string.by)+news.getAuthor());
        newsDetails.setText(news.getBody());
    }

}
