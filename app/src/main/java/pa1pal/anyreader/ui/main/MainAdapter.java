package pa1pal.anyreader.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pa1pal.anyreader.R;
import pa1pal.anyreader.model.News;

/**
 * Created by pa1pal on 19/10/16.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<News> list;

    public MainAdapter(List<News> news){
        this.list = news;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //String uri = "@drawable/ic";  // where myresource (without the extension) is the file

      //  holder.newsImage.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic));
        Picasso.with(holder.itemView.getContext())
                .load(list.get(position).getThumb())
                .into(holder.newsImage);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.newsImage)
        ImageView newsImage;
        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}
