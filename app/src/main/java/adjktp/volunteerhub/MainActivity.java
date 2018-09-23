package adjktp.volunteerhub;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import adjktp.volunteerhub.Adapters.FragmentAdapter;

public class MainActivity extends AppCompatActivity {


    private ViewPager mViewPager;
    private FragmentAdapter mFragmentAdapter;
    private TabLayout mTabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mFragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mFragmentAdapter);

        mTabLayout = findViewById(R.id.nav_bar);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setIcon(getDrawable(R.drawable.ic_home_black_24dp));
        mTabLayout.getTabAt(1).setIcon(getDrawable(R.drawable.ic_search_black_24dp));
        mTabLayout.getTabAt(2).setIcon(getDrawable(R.drawable.ic_account_circle_black_24dp));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
//                    tab.setIcon(getDrawable(R.drawable.ic_home_black_48dp));
                } else if (tab.getPosition() == 1){
//                    tab.setIcon(getDrawable(R.drawable.ic_account_circle_black_48dp));
                } else {
//                    tab.setIcon(getDrawable(R.drawable.ic_account_circle_black_48dp));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
//                    tab.setIcon(getDrawable(R.drawable.ic_outline_home_48px));
                } else if (tab.getPosition() == 1){
//                    tab.setIcon(getDrawable(R.drawable.ic_outline_account_circle_48px));
                } else {
//                    tab.setIcon(getDrawable(R.drawable.ic_outline_account_circle_48px));
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mViewPager.setCurrentItem(1);


    }




}
