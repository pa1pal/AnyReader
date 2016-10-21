package pa1pal.anyreader.ui.main;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import pa1pal.anyreader.R;
import pa1pal.anyreader.ui.base.ARBaseFragment;
import pa1pal.anyreader.ui.util.ItemOffsetDecoration;
import pa1pal.anyreader.ui.util.RecyclerItemClickListner;

public class MainActivityFragment extends ARBaseFragment
implements RecyclerItemClickListner.OnItemClickListener, MainContract.View{

    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.rvNews)
    RecyclerView recyclerViewGrid;

    MainAdapter mainAdapter;
    MainPresenter mainPresenter;
    View rootView;

    public static final int GRID_LAYOUT_COUNT = 2;

    public static MainActivityFragment newInstance() {
        Bundle arguments = new Bundle();
        MainActivityFragment fragment = new MainActivityFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainAdapter = new MainAdapter(getActivity());
        mainPresenter = new MainPresenter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, rootView);
        mainPresenter.attachView(this);
        setUpRecyclerView();
        return rootView;
    }

    @Override
    public void setUpRecyclerView() {

        final LinearLayoutManager layoutManager = new GridLayoutManager(getActivity(),
                GRID_LAYOUT_COUNT);
        recyclerViewGrid.setLayoutManager(layoutManager);
        recyclerViewGrid.addOnItemTouchListener(new RecyclerItemClickListner(getActivity(), this));
        recyclerViewGrid.setItemAnimator(new DefaultItemAnimator());

        //Setting the Equal column spacing
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(getActivity(),
                R.dimen.item_offset);
        recyclerViewGrid.addItemDecoration(itemDecoration);

        recyclerViewGrid.setAdapter(mainAdapter);

        mainPresenter.loadEvent();

    }

    @Override
    public void showProgressbar(boolean show) {
        swipeRefreshLayout.setRefreshing(show);
    }

    @Override
    public void onItemClick(View childView, int position) {

    }

    @Override
    public void onItemLongPress(View childView, int position) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mainPresenter.detachView();
    }
}
