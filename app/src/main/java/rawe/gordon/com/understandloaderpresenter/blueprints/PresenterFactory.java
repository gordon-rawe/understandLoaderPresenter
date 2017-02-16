package rawe.gordon.com.understandloaderpresenter.blueprints;

/**
 * Created by gordon on 16/02/2017.
 */

public interface PresenterFactory<T extends BasePresenter> {
    T create();
}
