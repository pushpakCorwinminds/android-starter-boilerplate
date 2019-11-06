package com.githumainDashboard.githubcode.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.githumainDashboard.githubcode.Fragments.LoginFragment;
import com.githumainDashboard.githubcode.Fragments.RegistrationFragment;
import com.githumainDashboard.githubcode.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class loginRegisrationActivity extends AppCompatActivity {
    private TabLayout tabLayout1;
    private ViewPager viewPager1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_regisration);

        tabLayout1=findViewById(R.id.tabs);
        viewPager1=findViewById(R.id.viewPager);

        setUpViewPager(viewPager1);
        tabLayout1.setupWithViewPager(viewPager1);
    }
    private void setUpViewPager(ViewPager viewPager){
        ViewPagerAdapter viewPagerAdapter= new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new LoginFragment(),"Login");
        viewPagerAdapter.addFragment(new RegistrationFragment(),"Registration");
        viewPager.setAdapter(viewPagerAdapter);
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList= new ArrayList<>();
        private final List<String> mFragmentTitleList= new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int i) {
            return mFragmentList.get(i);
        }

        @Override
        public int getCount() {
            return mFragmentTitleList.size();
        }
        // set Title of Fragment
        public void addFragment(Fragment fragment,String title){
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

    }
}
