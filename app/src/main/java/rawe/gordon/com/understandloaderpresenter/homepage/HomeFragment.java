package rawe.gordon.com.understandloaderpresenter.homepage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import rawe.gordon.com.understandloaderpresenter.R;
import rawe.gordon.com.understandloaderpresenter.blueprints.PresenterLoader;

/**
 * Created by gordon on 16/02/2017.
 */

public class HomeFragment extends Fragment implements HomeUnit.View, LoaderManager.LoaderCallbacks<HomeUnit.Presenter> {

    public static final int HOME_LOADER_ID = 0x0001;

    private TextView centerView;
    private HomeUnit.Presenter presenter;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLoaderManager().initLoader(HOME_LOADER_ID, null, this);
    }

    @Override
    public void setPresenter(HomeUnit.Presenter presenter) {
        this.presenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.layout_fragment_home, container, false);
        centerView = (TextView) root.findViewById(R.id.center_text);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void show(String msg) {
        centerView.setText(msg);
    }

    @Override
    public Loader<HomeUnit.Presenter> onCreateLoader(int id, Bundle args) {
        return new PresenterLoader<>(getContext(), new PresenterFactoryHome());
    }

    @Override
    public void onLoadFinished(Loader<HomeUnit.Presenter> loader, HomeUnit.Presenter data) {
        this.presenter = data;
    }

    @Override
    public void onLoaderReset(Loader<HomeUnit.Presenter> loader) {
        presenter = null;
    }
}
