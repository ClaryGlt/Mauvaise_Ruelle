package com.example.lamauvaiseruelle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AdAdapter adAdapter = new AdAdapter(this);

        ScrollView scrollView = new ScrollView(this);
        ViewGroup.LayoutParams scrollViewParams = new ViewGroup.LayoutParams(
                ScrollView.LayoutParams.MATCH_PARENT,
                ScrollView.LayoutParams.MATCH_PARENT
        );

        scrollView.setLayoutParams(scrollViewParams);

        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        linearLayout.setOrientation((LinearLayout.VERTICAL));
        linearLayout.setLayoutParams(linearLayoutParams);

        for(int i=0; i<adAdapter.getCount(); i++){
            linearLayout.addView(adAdapter.getView(i, findViewById(R.id.testtest), null));
        }

        scrollView.addView((linearLayout));
        setContentView(scrollView);



    }
}

