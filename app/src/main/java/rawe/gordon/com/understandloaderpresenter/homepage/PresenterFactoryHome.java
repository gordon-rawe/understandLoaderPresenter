package rawe.gordon.com.understandloaderpresenter.homepage;

import rawe.gordon.com.understandloaderpresenter.blueprints.PresenterFactory;

/**
 * Created by gordon on 16/02/2017.
 */

public class PresenterFactoryHome implements PresenterFactory<HomeUnit.Presenter> {
    @Override
    public HomeUnit.Presenter create() {
        return new HomePresenter();
    }
}
