package com.sqli.formation.listManipulation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.ListView;
import android.widget.TextView;

import com.sqli.formation.R;
import com.sqli.formation.adapters.TaskAdapater;
import com.sqli.formation.controls.ClearableEditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ysmagghe on 20/02/2018.
 */

public class TodoListActivity extends AppCompatActivity {

    private ClearableEditText mTaskToAdd;
    private ListView mListViewTodo;

    private List<String> mTodoTaskList = new ArrayList<>();
    private TaskAdapater mTaskAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_todolist);
        setTitle(R.string.title_todo_list);

        mTaskToAdd = findViewById(R.id.edit_text);
        mListViewTodo = findViewById(R.id.list_view);

        initBehavior();

    }

    private void initBehavior() {

        mTaskToAdd.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    addTask();
                    return true;
                }
                return false;
            }
        });

        // TODO : créer instance et l'adapter à la vue
        mTaskAdapter = new TaskAdapater(this, mTodoTaskList);
        mListViewTodo.setAdapter(mTaskAdapter);
    }

    private void addTask() {
        if (!TextUtils.isEmpty(mTaskToAdd.getText().toString())) {

            mTodoTaskList.add(mTaskToAdd.getText().toString());

            mTaskAdapter.notifyDataSetChanged();

            mTaskToAdd.setText("");
        }
    }


}
