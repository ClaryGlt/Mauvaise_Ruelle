package com.example.lamauvaiseruelle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdAdapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<AdModel> adModelArrayList;
    private final LayoutInflater inflater;

    // Constructor
    public AdAdapter(Context context) {
        this.context = context;
        inflater = (LayoutInflater.from(context));
        this.adModelArrayList = new AdManager().loadAdsFromJson(context);
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
        ImageView imageIV = view.findViewById(R.id.imageAdModel);
        TextView titleTV = view.findViewById(R.id.titreAdModel) ;
        TextView addressTV = view.findViewById(R.id.adresseAdModel) ;
        imageIV.setImageResource(ad.getImage());
        titleTV.setText(ad.getTitle());
        addressTV.setText(ad.getAddress());
        return view;
    }
}
