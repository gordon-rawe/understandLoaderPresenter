package rawe.gordon.com.understandloaderpresenter.homepage;

import rawe.gordon.com.understandloaderpresenter.blueprints.BasePresenter;
import rawe.gordon.com.understandloaderpresenter.blueprints.BaseView;

/**
 * Created by gordon on 16/02/2017.
 */

public class HomeUnit {
    public interface View extends BaseView<Presenter> {
        void show(String msg);
    }

    public interface Presenter extends BasePresenter {

    }
}
