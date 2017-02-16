package rawe.gordon.com.understandloaderpresenter.homepage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import rawe.gordon.com.understandloaderpresenter.ActivityUtils;
import rawe.gordon.com.understandloaderpresenter.R;

public class HomeActivity extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HomeFragment statisticsFragment = (HomeFragment) getSupportFragmentManager()
                .findFragmentById(R.id.contentFrame);
        if (statisticsFragment == null) {
            statisticsFragment = HomeFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    statisticsFragment, R.id.contentFrame);
        }
    }
}
