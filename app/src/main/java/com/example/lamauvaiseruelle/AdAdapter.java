package com.example.lamauvaiseruelle;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

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
    public int getCount() { return adModelArrayList.size() ; } // Return ad number
    @Override
    public AdModel getItem(int i) { return adModelArrayList.get(i); } // Return ad number i
    @Override
    public long getItemId(int i) { return i ; } // Return ad id i
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // Get ad number i
        AdModel ad = getItem(i) ;
        view = inflater.inflate(R.layout.item_listview_ad, null);

        // Get the image view and both text views
        ImageView imageIV = ;
        TextView titleTV = ... ;
        TextView addressTV = ... ;
        imageIV.setImageResource(...);
        titleTV.setText(...);
        addressTV.setText(...);
        return view;
    }
}
