package pa1pal.anyreader.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import pa1pal.anyreader.R;
import pa1pal.anyreader.model.News;
import pa1pal.anyreader.util.DynamicHeightNetworkImageView;
import pa1pal.anyreader.util.ImageLoaderHelper;

/**
 * Created by pa1pal on 19/10/16.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<News> list;
    ImageLoader imageLoader;

    @Inject
    public MainAdapter(){
        list = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.author.setText("by "+list.get(position).getAuthor());

        imageLoader = ImageLoaderHelper.getInstance(holder.itemView.getContext()).getImageLoader();
        holder.newsImage.setImageUrl(list.get(position).getThumb(), imageLoader);
        holder.newsImage.setAspectRatio(list.get(position).getAspectRatio());

    }

    public void setNews(List<News> news) {
        list = news;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.newsImage)
        DynamicHeightNetworkImageView newsImage;

        @BindView(R.id.title)
        TextView title;

        @BindView(R.id.author)
        TextView author;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}