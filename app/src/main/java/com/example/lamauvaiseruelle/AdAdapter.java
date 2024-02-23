package com.example.lamauvaiseruelle;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public int getCount() {
        return adModelArrayList.size();
    } // Return ad number

    @Override
    public AdModel getItem(int i) {
        return adModelArrayList.get(i);
    } // Return ad number i

    @Override
    public long getItemId(int i) {
        return i;
    } // Return ad id

    public Map<View, Button> getViewMap(int i, View convertview, ViewGroup viewgroup) {
        // Get ad number i
        AdModel ad = getItem(i);
        Map<View, Button> Result;
        Result = new HashMap<View, Button>();
        convertview = inflater.inflate(R.layout.item_listview_ad, null);

        // Get the image view and both text views
        ImageView imageIV = convertview.findViewById(R.id.imageAdModel);
        TextView titleTV = convertview.findViewById(R.id.titreAdModel);
        TextView addressTV = convertview.findViewById(R.id.adresseAdModel);
        Button button_desc = convertview.findViewById(R.id.button_description);
        //poti boutton pour l'appeler différent, avec un nom en fonction de i, pour avoir que des bouttons différents
        imageIV.setImageResource(ad.getImage());
        titleTV.setText(ad.getTitle());
        addressTV.setText(ad.getAddress());

        Result.put(convertview, button_desc);
        return Result;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}

