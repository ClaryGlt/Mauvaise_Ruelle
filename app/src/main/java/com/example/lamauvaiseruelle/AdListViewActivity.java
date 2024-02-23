package com.example.lamauvaiseruelle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AdListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.w("AdListViewActivity", "debut");

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

            Map<View, Button> resultatMap = adAdapter.getViewMap(i, findViewById(R.id.testtest), null);
            Set<View> keyset = resultatMap.keySet();
            View convertedView = keyset.stream().findFirst().get();
            Button button_desc = resultatMap.get(convertedView);
            linearLayout.addView(convertedView);
            int numero = i;
            button_desc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent lancementAdViewActivity = new Intent(AdListViewActivity.this, AdViewActivity.class);
                    lancementAdViewActivity.putExtra("numerotruc", numero);
                    startActivity(lancementAdViewActivity);
                }
            });

        }

        scrollView.addView((linearLayout));
        setContentView(scrollView);



    }
}

