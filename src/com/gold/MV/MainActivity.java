package com.gold.MV;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{

    private Fragment fragment1;
    private Fragment fragment2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button button = (Button)findViewById(R.id.but);
        button.setOnClickListener(this);

        privateMethod();
    }

    private void privateMethod() {

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentT, fragment1);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.animator.jump_top, R.animator.jump_bottom);
//        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        if (!fragment2.isVisible())
            fragmentTransaction.add(R.id.fragmentT, fragment2);
        else {
            fragmentTransaction.remove(fragment2);
        }

//        if (fragment1.isVisible()) {
//            fragmentTransaction.replace(R.id.fragmentT, fragment2);
//        } else {
//            fragmentTransaction.replace(R.id.fragmentT, fragment1);
//        }

//        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
