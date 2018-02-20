package com.sqli.formation.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sqli.formation.R;

import java.util.List;

/**
 * Created by ysmagghe on 20/02/2018.
 */

public class TaskAdapater extends BaseAdapter {

    private Context mContext;
    private List<String> mTaskList;


    public TaskAdapater(Context context, List<String> taskList) {
        mContext = context;
        mTaskList = taskList;

    }

    @Override
    public int getCount() {
        return mTaskList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.task_item_list_layout, viewGroup, false);
            holder = new ViewHolder();
            holder.textViewTitle = convertView.findViewById(R.id.tv_task_title_parent);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }


        String item = mTaskList.get(position);
        holder.textViewTitle.setText(item);

        return  convertView;
    }

    private static class ViewHolder{
        private TextView textViewTitle;



    }
}
