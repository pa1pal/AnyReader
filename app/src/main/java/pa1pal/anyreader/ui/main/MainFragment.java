package pa1pal.anyreader.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import pa1pal.anyreader.App;
import pa1pal.anyreader.R;
import pa1pal.anyreader.injection.DataManager;
import pa1pal.anyreader.model.News;
import pa1pal.anyreader.ui.interfaces.ItemClickCallback;
import pa1pal.anyreader.util.RecyclerItemClickListner;

public class MainFragment extends Fragment
        implements RecyclerItemClickListner.OnItemClickListener, MainContract.View, SwipeRefreshLayout.OnRefreshListener{

    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.rvNews)
    RecyclerView recyclerViewGrid;

    @Inject
    DataManager dataManager;

    private News news;
    MainAdapter mainAdapter;
    MainContract.Presenter mainPresenter;

    View rootView;
    List<News> list;

    public static final int GRID_LAYOUT_COUNT = 2;

    public static MainFragment newInstance() {
        Bundle arguments = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().inject(this);
        list= new ArrayList<>();
        mainAdapter = new MainAdapter();
        mainPresenter = new MainPresenter(dataManager, this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, rootView);
        swipeRefreshLayout.setOnRefreshListener(this);
        mainPresenter.subscribe();
        setUpRecyclerView();
        mainPresenter.loadPost();
        return rootView;
    }

    @Override
    public void setUpRecyclerView() {

        //final LinearLayoutManager layoutManager = new GridLayoutManager(getActivity(),
          //      GRID_LAYOUT_COUNT);
        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(GRID_LAYOUT_COUNT, StaggeredGridLayoutManager.VERTICAL);
        recyclerViewGrid.setLayoutManager(layoutManager);
        recyclerViewGrid.addOnItemTouchListener(new RecyclerItemClickListner(getActivity(), this));
        recyclerViewGrid.setItemAnimator(new DefaultItemAnimator());

        //Setting the Equal column spacing
//        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(getActivity(),
//                R.dimen.item_offset);
//        recyclerViewGrid.addItemDecoration(itemDecoration);

        recyclerViewGrid.setAdapter(mainAdapter);

    }

    @Override
    public void showError(String message) {
        Toast.makeText(getContext(), "Error loading post", Toast.LENGTH_SHORT).show();
        if (swipeRefreshLayout != null)
            swipeRefreshLayout.post(new Runnable() {
                @Override
                public void run() {
                    swipeRefreshLayout.setRefreshing(false);
                }
            });
    }

    @Override
    public void showComplete() {
        Toast.makeText(getContext(), "Completed loading", Toast.LENGTH_SHORT).show();

        if (swipeRefreshLayout != null)
            swipeRefreshLayout.post(new Runnable() {
                @Override
                public void run() {
                    swipeRefreshLayout.setRefreshing(false);
                }
            });
    }

    @Override
    public void setUpAdapter(List<News> list) {
        mainAdapter.setNews(list);
        this.list = list;
    }

    @Override
    public void onItemClick(View childView, int position) {
        ((ItemClickCallback) getActivity()).onItemSelected(list.get(position));
//        Intent detailsIntent = new Intent(getActivity(), DetailsActivity.class);
//        detailsIntent.putExtra("position", position);
//        detailsIntent.putExtra("list", (new Gson()).toJson(list));
        //Bundle bundle = new Bundle();
        //bundle.putParcelableArrayList();
        //bundle.putInt("position", position);
        //bundle.putParcelableArrayList("list", (ArrayList<? extends Parcelable>) list);
        //detailsIntent.putParcelableArrayListExtra("list", (ArrayList<? extends Parcelable>) list);
        //detailsIntent.putExtra("position", position);
        //detailsIntent.putExtra("list", (Serializable) list);
        //detailsIntent.putExtras(bundle);
        //detailsIntent.putExtras("bundle", bundle);
        //startActivity(detailsIntent);
    }

    @Override
    public void onItemLongPress(View childView, int position) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mainPresenter.unsubscribe();
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mainPresenter = presenter;
    }

    @Override
    public void onRefresh() {
        mainPresenter.loadPost();
    }
}