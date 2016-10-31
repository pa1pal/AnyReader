package pa1pal.anyreader.ui.detail;

import android.app.Activity;
import android.os.Bundle;
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
public class DetailsActivity extends Activity implements DetailsContract.View{

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
        //Intent detailsIntent = new Intent(this, DetailsActivity.class);
        Bundle bundle = getIntent().getExtras();
        position = bundle.getInt("position", 0);
        //list = getIntent().getExtras().getParcelableArrayList("list");
        list = bundle.getParcelableArrayList("list");
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