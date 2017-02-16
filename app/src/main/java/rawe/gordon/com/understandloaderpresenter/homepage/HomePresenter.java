package rawe.gordon.com.understandloaderpresenter.homepage;

/**
 * Created by gordon on 16/02/2017.
 */

public class HomePresenter implements HomeUnit.Presenter {

    protected HomeUnit.View homeView;

    public void setHomeView(HomeUnit.View homeView) {
        this.homeView = homeView;
    }

    @Override
    public void start() {
        homeView.show("shit happened...");
    }

    @Override
    public void handleDestroy() {

    }
}
