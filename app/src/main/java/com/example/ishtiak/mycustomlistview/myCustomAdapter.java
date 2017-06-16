package com.example.ishtiak.mycustomlistview;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.xml.parsers.SAXParser;

/**
 * Created by Ishtiak on 6/9/2017.
 */

class myCustomAdapter extends ArrayAdapter {
    List<String> mNameArray;
    List<Integer> mImageArray;
    List<String> mPhnArray;
    Context mcontex;


   public myCustomAdapter(@NonNull Context context, List nameArray, List imageArray, List phnArray) {
        super(context, 0, nameArray);
        this.mNameArray = nameArray;
        this.mImageArray = imageArray;
        this.mPhnArray = phnArray;
        this.mcontex = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView== null){
            LayoutInflater layoutInflater = (LayoutInflater) mcontex.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.custom_layout, parent, false);

        }

        ImageView imgview = (ImageView) convertView.findViewById(R.id.imgViewId);
        TextView txtView = (TextView) convertView.findViewById(R.id.cl_TxtView1);
        TextView textView2 = (TextView) convertView.findViewById(R.id.cl_TxtView2);

        imgview.setImageResource(mImageArray.get(position));
        txtView.setText(mNameArray.get(position).toString());
        textView2.setText(mPhnArray.get(position).toString());
        return convertView;
    }
}
