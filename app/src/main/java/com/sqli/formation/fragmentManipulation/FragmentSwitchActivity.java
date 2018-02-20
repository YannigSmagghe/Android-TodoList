package com.sqli.formation.fragmentManipulation;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sqli.formation.R;

/**
 * Created by ysmagghe on 20/02/2018.
 */

public class FragmentSwitchActivity extends AppCompatActivity implements IChangeColor{

    private FragmentManager mFragmentManager;
    private Button mBtnChangefragment;
    private ConstraintLayout mLayoutFooter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fragment_switch);

        mFragmentManager = getSupportFragmentManager();

        mBtnChangefragment = findViewById(R.id.btn_switch_fragment);

        mLayoutFooter = findViewById(R.id.footer);

        initBehaviour();
        displayButtonFragment();
    }

    private void initBehaviour() {
        mBtnChangefragment.setOnClickListener (new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                displaySwitchFragment();
            }
        });

    }


    private void displayButtonFragment() {
        android.support.v4.app.FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.add(R.id.header, new MultiButtonsFragment(),MultiButtonsFragment.TAG);
        transaction.commit();
    }

    private void displaySwitchFragment(){
        android.support.v4.app.Fragment buttonsFragment = mFragmentManager.findFragmentByTag(MultiButtonsFragment.TAG);

        if (buttonsFragment != null) {
            android.support.v4.app.FragmentTransaction transaction = mFragmentManager.beginTransaction();
            transaction.add(R.id.footer,new MultiSwitchFragment());
            transaction.commit();
        }
    }


    @Override
    public void OnColorChange() {
        mLayoutFooter.setBackgroundColor(ContextCompat.getColor(FragmentSwitchActivity.this,R.color.colorChange));
        Toast.makeText(this,R.string.color_change_toast,Toast.LENGTH_LONG).show();
    }
}
