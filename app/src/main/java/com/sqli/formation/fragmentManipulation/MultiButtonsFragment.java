package com.sqli.formation.fragmentManipulation;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sqli.formation.R;

/**
 * Created by ysmagghe on 20/02/2018.
 */

public class MultiButtonsFragment extends Fragment{
    public static final String TAG = "MultiButtonsFragment";

    private View mRootview;

    private Button mBtnChangecolor;

    private IChangeColor mIChangecolor;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mIChangecolor = (IChangeColor) context;
        }catch (ClassCastException e){
            Log.e(TAG, "Activity dosen't implement the expected interface");
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRootview = inflater.inflate(R.layout.fragment_multi_buttons,container, false);

        return mRootview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mBtnChangecolor = mRootview.findViewById(R.id.btn_1);
        mBtnChangecolor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (mIChangecolor != null){
                    mIChangecolor.OnColorChange();
                }
            }
        });
    }
}
