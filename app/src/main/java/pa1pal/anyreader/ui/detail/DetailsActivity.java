package pa1pal.anyreader.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
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

    private List<News> list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        int position = 0;
        list = new ArrayList<>();
        final Intent intent = this.getIntent();
        //Intent detailsIntent = new Intent(this, DetailsActivity.class);
        //Bundle bundle = getIntent().getExtras();
        //position = intent.getExtras.("position");
        //list = getIntent().getExtras().getParcelableArrayList("list");
        if (intent!= null) {
            position = intent.getIntExtra("position", 0);
            list = intent.getParcelableArrayListExtra("list");
        }
        //list = (List<News>) getIntent().getSerializableExtra("list");

        //assert list != null;
        newsDetails.setText(list.get(position).getBody());
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void setUpDetails(List<News> list) {

    }

    @Override
    public void setPresenter(DetailsContract.Presenter presenter) {

    }
}
