package com.example.lamauvaiseruelle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_list_view);

        //récupérer la liste d'Admodels


    }
}

public class AdAdapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<AdModel> adModelArrayList;
    private final LayoutInflater inflater;
    // Constructor
    public AdAdapter(Context context, ArrayList<AdModel> adModelArrayList) {
        this.context = context;
        this.adModelArrayList = adModelArrayList;
        inflater = (LayoutInflater.from(context));
    }
    @Override
    public int getCount() { return ... ; } // Return ad number
    @Override
    public Object getItem(int i) { return ... ; } // Return ad number i
    @Override
    public long getItemId(int i) { return ... ; } // Return ad id i
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
    // Get ad number i
        AdModel ad = ... ;
        view = inflater.inflate(R.layout.item_listview_ad, null);

        // Get the image view and both text views
        ImageView imageIV = ... ;
        TextView titleTV = ... ;
        TextView addressTV = ... ;
        imageIV.setImageResource(...);
        titleTV.setText(...);
        addressTV.setText(...);
        return view;
    }
}