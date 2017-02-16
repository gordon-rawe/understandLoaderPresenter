package rawe.gordon.com.understandloaderpresenter.blueprints;

import android.content.Context;
import android.support.v4.content.Loader;


/**
 * Created by gordon on 16/02/2017.
 */

public class PresenterLoader<T extends BasePresenter> extends Loader<T> {

    private T presenter;
    private PresenterFactory<T> presenterFactory;

    /**
     * Stores away the application context associated with context.
     * Since Loaders can be used across multiple activities it's dangerous to
     * store the context directly; always use {@link #getContext()} to retrieve
     * the Loader's Context, don't use the constructor argument directly.
     * The Context returned by {@link #getContext} is safe to use across
     * Activity instances.
     *
     * @param context used to retrieve the application context.
     */
    public PresenterLoader(Context context, PresenterFactory<T> presenterFactory) {
        super(context);
        this.presenterFactory = presenterFactory;
    }

    @Override
    protected void onStartLoading() {
        /** if presenter exists return it*/
        if (presenter != null) {
            deliverResult(presenter);
            return;
        }
        /** if presenter doesn't exist force load to create one*/
        forceLoad();
    }

    @Override
    protected void onForceLoad() {
        /** force to create one presenter */
        presenter = presenterFactory.create();
        deliverResult(presenter);
    }

    @Override
    protected void onReset() {
        presenter.handleDestroy();
        presenter = null;
    }
}
