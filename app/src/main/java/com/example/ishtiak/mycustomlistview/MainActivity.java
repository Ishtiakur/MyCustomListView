package com.example.ishtiak.mycustomlistview;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static android.R.id.list;
import static android.R.id.list_container;

public class MainActivity extends AppCompatActivity {
    Context context;

    String name [] = {"Ishtiak","tajul","saif","rahman","shuvojit","Rupa's Lover"};
    String[] phn_number = {"01703490802","01703490802","01703490802",
                           "01762741757","0176223359", "01762741757"};
    int image[] = {R.drawable.picture,
            R.drawable.pic,
            R.drawable.icon_hammer_2,
            R.drawable.unnamed,
            R.drawable.icon_hammer_small,
            R.drawable.logo,
            R.drawable.logo2,};
    myCustomAdapter adapter;
    ArrayList<String> phnArray = new ArrayList<>();
    ArrayList<Integer> imageArray = new ArrayList<>();
    ArrayList<String> nameArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView = (ListView) findViewById(R.id.lv);
        context = this;

        //to increase array item
        for (int i = 0; i<10; i++){
            for (int j=0; j<name.length && j<image.length && j<phn_number.length;j++ ){
                nameArray.add(name[j]);
                imageArray.add(image[j]);
                phnArray.add(phn_number[j]);
            }
        }
        adapter = new myCustomAdapter(this, nameArray, imageArray, phnArray);
        // To Check Item click or not
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this,"You Clicked short " +
                        ""+parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
            }
        });


        //To delete Item From the list

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog alertDialogue = new AlertDialog.Builder(context).create();
                alertDialogue.setTitle("Attention");
                alertDialogue.setMessage("Are you sure you want to delete ?");
                alertDialogue.setButton(AlertDialog.BUTTON_POSITIVE, "YES",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                imageArray.remove(position);
                                nameArray.remove(position);
                                phnArray.remove(position);
                                adapter.notifyDataSetChanged();
                                dialog.dismiss();

                            }
                        });
                alertDialogue.setButton(AlertDialog.BUTTON_NEGATIVE, "NO",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                            }
                        });
                alertDialogue.show();
                return false;
            }
        });


    }
}
