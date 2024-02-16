package com.example.lamauvaiseruelle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AdAdapter adAdapter = new AdAdapter(this);

        LinearLayout layout_items = new LinearLayout(this);
        layout_items.setOrientation (LinearLayout.VERTICAL);

        for(int i=0; i<adAdapter.getCount(); i++){
            layout_items.addView(adAdapter.getView(i, findViewById(R.id.testtest), null));
        }

        setContentView(layout_items);



    }
}

