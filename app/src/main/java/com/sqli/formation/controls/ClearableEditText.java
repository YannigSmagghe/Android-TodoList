package com.sqli.formation.controls;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.sqli.formation.R;

/**
 * Created by ysmagghe on 20/02/2018.
 */

public class ClearableEditText extends ConstraintLayout {


    private View mRootView;
    private EditText mCurrentText;

    public ClearableEditText(Context context) {
        super(context);
        initView(context);
    }

    public ClearableEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }


    public ClearableEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context){
        mRootView  = LayoutInflater.from(context).inflate(R.layout.clearable_edit_text_layout,this);

        mCurrentText = mRootView.findViewById(R.id.et_content_text);

        ImageView imageViewClear = mRootView.findViewById(R.id.image_view_clear);

        imageViewClear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentText.setText("");
            }
        });
    }

    public void setOnEditorActionListener(TextView.OnEditorActionListener onEditorActionListener){
        mCurrentText.setOnEditorActionListener(onEditorActionListener);
    }

    public Editable getText(){
        return mCurrentText.getText();
    }

    public void setText(CharSequence text){
        mCurrentText.setText(text);
    }
}
