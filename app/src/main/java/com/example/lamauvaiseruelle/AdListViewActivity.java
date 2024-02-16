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
import java.util.List;

public class AdListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.w("AdListViewActivity", "debut")

        AdAdapter adAdapter = new AdAdapter(this);

        Button button_descr = findViewById(R.id.button_description);
        Log.w("AdListViewActivity", "aprdebut")



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

        Log.w("AdListViewActivity", "avantfor")
        for(int i=0; i<adAdapter.getCount(); i++){
            Log.w("AdListViewActivity", "infor"+i)

            linearLayout.addView(adAdapter.getView(i, findViewById(R.id.testtest), null));

            final int numero = i;

            button_descr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent lancementAdViewActivity = new Intent(AdListViewActivity.this, AdViewActivity.class);
                    startActivity(lancementAdViewActivity);
                    lancementAdViewActivity.putExtra("numerotruc", numero);
                }
            });
            Log.w("AdListViewActivity", "fin_infor"+i)

        }

        scrollView.addView((linearLayout));
        setContentView(scrollView);



    }
}

