package com.example.fragmentchangelistenerdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("");
        this.fragmentManager = getSupportFragmentManager();
        this.fragmentManager.addOnBackStackChangedListener(this);
    }

    public void fragment1(View view) {
        // Add the new tab fragment
        this.fragmentManager.beginTransaction()
                .replace(R.id.container, Fragment1.newInstance(),"fragment1 title")
                .addToBackStack(null)
                .commit();
    }


    public void fragment2(View view) {
        // Add the new tab fragment
        this.fragmentManager.beginTransaction()
                .replace(R.id.container, Fragment2.newInstance(),"fragment2 title")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackStackChanged() {

        Toast.makeText(this, "Fragment changed", Toast.LENGTH_SHORT).show();
        List<Fragment> fragments = this.fragmentManager.getFragments();
        if(fragments.size() > 0)
        {
            Fragment mCurrentFragment = fragments.get(fragments.size() - 1);
            setTitle(mCurrentFragment.getTag());
        }
        else
        {
            setTitle("");
        }

    }
}
